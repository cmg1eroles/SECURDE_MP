package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

    @RequestMapping("/home")
    public String goToHome(ModelMap model) {
        return "home";
    }
}
