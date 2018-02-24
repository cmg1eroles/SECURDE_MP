package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

@Controller
public class URLController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    public String home(ModelMap model) {
        return "index";
    }

    @RequestMapping("/profile/{id}")
    public String profile(@PathVariable(value="id") Long id, ModelMap model) {
        User user = userRepository.findOne(id);
        model.put("username", user.getUsername());
        model.put("name", user.getName());
        model.put("email", user.getEmail());
        model.put("description", user.getDescription());
        return "userprofile";
    }
}
