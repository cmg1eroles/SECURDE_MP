package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

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
    public HashMap<String, Object> loginUser(String loginform) {
        HashMap<String, Object> data = new HashMap();
        return data;
    }

    @PostMapping("/register")
    public HashMap<String, Object> registerUser(String regform) {
        HashMap<String, Object> data = new HashMap();
        return data;
    }

    @PostMapping("/logout")
    public String logoutUser() {
        return "";
    }
}
