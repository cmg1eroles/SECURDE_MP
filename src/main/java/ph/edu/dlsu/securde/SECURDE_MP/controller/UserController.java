package ph.edu.dlsu.securde.SECURDE_MP.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.hibernate.annotations.Any;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private Gson gson = new Gson();

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value="id") Long id) {
        User user = userRepository.findOne(id);
        if (user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public HashMap<String, Object> loginUser(HttpServletRequest request, HttpServletResponse response,
                                @Valid @RequestBody String loginform) throws IOException {
        HashMap<String, Object> data = new HashMap();
        JSONObject json = new JSONObject(loginform);
        List<User> user = userRepository.findByUsernameAndPassword((String)json.get("username"), (String)json.get("password"));
        if (user.isEmpty()) {
            data.put("success", false);
        } else {
            data.put("success", true);
            data.put("user", user.get(0));
            request.getSession().setAttribute("user", user.get(0));
        }
        return data;
    }

    @PostMapping("/register")
    public HashMap<String, Object> registerUser(HttpServletRequest request, HttpServletResponse response,
                                                @Valid @RequestBody String regform) {
        HashMap<String, Object> data = new HashMap();

        JSONObject json = new JSONObject(regform);

        String name = (String)json.get("fullname");
        String email = (String)json.get("email");
        String uname = (String)json.get("username");
        String pw = (String)json.get("password");
        String confirm = (String)json.get("confirm");

        if (name.equals("") || email.equals("") || uname.equals("") || pw.equals("") || confirm.equals("")) {
            data.put("msg", "Please fill out all fields.");
        } else if (!pw.equals(confirm)) {
            data.put("msg", "Passwords do not match!");
        } else {
            Long id = userRepository.newId();
            User u = userRepository.save(new User(id, name, email, uname, pw, "", false));
            if (u != null) {
                data.put("msg", "success");
                data.put("user", u);
                request.getSession().setAttribute("user", u);
            }
            else data.put("msg", "User Registration failed!");
        }

        return data;
    }

    @PostMapping("/logout")
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ses = request.getSession(false);
            if (ses != null)
                ses.invalidate();
        return "success";
    }
}
