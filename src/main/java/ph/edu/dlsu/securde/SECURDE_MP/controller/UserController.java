package ph.edu.dlsu.securde.SECURDE_MP.controller;

import com.google.gson.Gson;
import org.passay.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.RoleRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;
import ph.edu.dlsu.securde.SECURDE_MP.service.BruteForcePreventionService;
import ph.edu.dlsu.securde.SECURDE_MP.service.ForgotPasswordService;
import ph.edu.dlsu.securde.SECURDE_MP.service.LoggingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ForgotPasswordService fpwService;
    @Autowired
    private LoggingService logService;

    private Gson gson = new Gson();

    private BruteForcePreventionService bfpService = BruteForcePreventionService.getInstance();

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
        Date now = new Date();
        HashMap<String, Object> data = new HashMap();
        JSONObject json = new JSONObject(loginform);
        List<User> user = userRepository.findByEmail((String)json.get("username"));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User u;

        data.put("success", false);
        if (user.isEmpty()) u = null; else u = user.get(0);
        if (u == null) {
            data.put("msg", "Invalid email or password!");
            logService.login(null, false);
        } else {
            String email = u.getEmail();
            Date timeOut = bfpService.getTimeOut(email);
            if (now.before(timeOut)) {
                data.put("msg", "timed-out");
                data.put("timeout", (timeOut.getTime() - now.getTime())/1000);
                logService.login(u, false);
            } else {
                if (!encoder.matches((String)json.get("password"), u.getPassword())) {
                    data.put("msg", "Invalid email or password!");
                    bfpService.addFailedAttempt(email);
                    timeOut = bfpService.getTimeOut(email);
                    if (now.before(timeOut)) {
                        data.put("msg", "timed-out");
                        data.put("timeout", (timeOut.getTime() - now.getTime())/1000);
                    }
                    logService.login(u, false);
                } else {
                    bfpService.attemptSuccess(email);
                    data.put("success", true);
                    data.put("user", user.get(0));
                    request.getSession().setAttribute("user", u);
                    logService.login(u, true);
                }
            }
        }

        /*(!encoder.matches((String)json.get("password"), u.getPassword())) {
            data.put("msg", "Invalid email or password!");
            if (!user.isEmpty()) {
                String email = u.getEmail();
                bfpService.addFailedAttempt(email);
                Date timeOut = bfpService.getTimeOut(email);
            }
        } else {
            data.put("success", true);
            data.put("user", user.get(0));
            request.getSession().setAttribute("user", u);
        }*/
        return data;
    }

    @PostMapping("/register")
    public HashMap<String, Object> registerUser(HttpServletRequest request, HttpServletResponse response,
                                                @Valid @RequestBody String regform) {
        HashMap<String, Object> data = new HashMap();

        JSONObject json = new JSONObject(regform);

        String fName = (String)json.get("firstname");
        String lName = (String)json.get("lastname");
        String email = (String)json.get("email");
        String uname = (String)json.get("username");
        String pw = (String)json.get("password");
        String confirm = (String)json.get("confirm");

        if (fName.equals("") || lName.equals("") || email.equals("") || uname.equals("") || pw.equals("") || confirm.equals("")) {
            data.put("msg", "Please fill out all fields.");
        } else if (!userRepository.findByEmail(email).isEmpty()) {
            data.put("msg", "A user with this email already exists!");
        } else if (!pw.equals(confirm)) {
            data.put("msg", "Passwords do not match!");
        } else {
            Long id = userRepository.newId();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (passwordIsValid(pw)) {
                pw = encoder.encode(pw);
                User u = new User(id, fName, lName, uname, pw, email, "", 0L, true);
                if (u != null && u.isValid()) {
                    userRepository.save(u);
                    data.put("msg", "success");
                    data.put("user", u);
                    request.getSession().setAttribute("user", u);
                    logService.register(u);
                }
                else data.put("msg", "User Registration failed!");
            }
            else data.put("msg", "Password must be 8 to 30 characters long, have at least 1 uppercase, 1 lowercase, 1 numeric, 1 special character, and no whitespaces");
        }

        return data;
    }

    @RequestMapping("/logout")
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ses = request.getSession(false);
        if (ses != null) {
            User u = (User) ses.getAttribute("user");
            if (u != null)
                logService.logout(u);
            ses.invalidate();
        }
        return "success";
    }

    @PostMapping("/changePassword")
    public HashMap<String, Object> changePassword(HttpServletRequest request,
                                                  @Valid @RequestBody String form) {
        HashMap<String, Object> data = new HashMap();
        data.put("success", false);

        JSONObject json = new JSONObject(form);
        String oPsw = (String)json.get("old");
        String nPsw = (String)json.get("new");
        String cPsw = (String)json.get("con");

        if (oPsw.equals("") || nPsw.equals("") || cPsw.equals("")) {
            data.put("msg", "Please fill out all fields.");
        } else if (!nPsw.equals(cPsw)) {
            data.put("msg", "Passwords do not match!");
        } else if (request.getSession(false) != null) {
            User user = (User) request.getSession(false).getAttribute("user");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!passwordIsValid(nPsw)) {
                data.put("msg", "Password must be 8 to 30 characters long, have at least 1 uppercase, 1 lowercase, 1 numeric, 1 special character, and no whitespaces");
            } else if (!encoder.matches(oPsw, user.getPassword())) {
                data.put("msg", "Incorrect password!");
            } else {
                user.setPassword(encoder.encode(nPsw));
                userRepository.save(user);
                data.put("msg", "Password successfully changed!");
                data.put("success", true);
                logService.changePassword(user);
            }
        } else {
            data.put("msg", "No user is logged in!");
        }

        return data;
    }

    @PostMapping("/user/{id}")
    public HashMap<String, Object> updateUser(HttpServletRequest request,
                                              @PathVariable(value="id") Long id,
                                              @Valid @RequestBody String form) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("success", false);

        JSONObject json = new JSONObject(form);
        String uname = (String)json.get("username");
        String fName = (String)json.get("firstname");
        String lName = (String)json.get("lastname");
        String email = (String)json.get("email");
        String desc = (String)json.get("description");
        String pword = (String)json.get("password");

        if (uname.equals("") || fName.equals("") || lName.equals("") || email.equals("") || pword.equals("")) {
            data.put("msg", "Please fill out all fields.");
        } else {
            User user = userRepository.findOne(id);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(pword, user.getPassword())) {
                user.setUsername(uname);
                user.setFirstName(fName);
                user.setLastName(lName);
                user.setEmail(email);
                user.setDescription(desc);
                userRepository.save(user);
                request.getSession().setAttribute("user", user);
                data.put("success", true);
                data.put("msg", "User information successfully updated!");
                logService.editProfileInfo(user);
            }
            else {
                data.put("msg", "Incorrect password!");
            }
        }

        return data;
    }

    @PostMapping("/user/{id}/access")
    public HashMap<String, Object> changeUserAccessControl(HttpServletRequest request,
                                                           @PathVariable(value="id") Long id,
                                                           @Valid @RequestBody String form) {
        HashMap<String, Object> data = new HashMap<>();

        HttpSession ses = request.getSession(false);
        if (ses == null) {
            data.put("success", false);
            data.put("msg", "You are unauthorized to commit this action!");
        } else {
            User u = (User) ses.getAttribute("user");
            if (u == null || u.getRoleCode() != roleRepository.findRoleByRole("ADMIN").getCode()) {
                data.put("success", false);
                data.put("msg", "You are unauthorized to commit this action!");
            } else {
                JSONObject json = new JSONObject(form);
                Boolean enabled = Boolean.valueOf((String)json.get("enabled"));
                Long type = Long.valueOf((String)json.get("type"));
                User user = userRepository.findOne(id);
                user.setEnabled(enabled);
                user.setRoleCode(type);
                userRepository.save(user);
                data.put("success", true);
                logService.changeUserStatus(user, roleRepository.findOne(type));
            }
        }
        return data;
    }

    @PostMapping("/password/reset")
    public HashMap<String, Object> resetPassword(@Valid @RequestBody String form) {

        HashMap<String, Object> data = new HashMap<>();
        data.put("success", false);

        JSONObject json = new JSONObject(form);
        String email = (String)json.get("email");

        List<User> users = userRepository.findByEmail(email);
        if (users.isEmpty()) {
            data.put("msg", "This email is invalid!");
        } else {
            User u = users.get(0);
            //ForgotPasswordService forgotPwService = ForgotPasswordService.getInstance();
            if (!fpwService.forgotPassword(u)) {
                data.put("msg", "Error in reseting password!");
            } else {
                data.put("msg", "Your password has been reset! Please check your email.");
                data.put("success", true);
                logService.passwordReset(u);
            }
        }
        return data;
    }

    private boolean passwordIsValid(String password) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new WhitespaceRule()
        ));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        return false;
    }
}
