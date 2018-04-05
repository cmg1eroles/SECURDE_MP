package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class URLController {

    @RequestMapping("/home")
    public String goToHome(ModelMap model) {
        return "home";
    }
    @RequestMapping("/forum")
    public String goToForum(ModelMap model) { return "forum"; }
    @RequestMapping("/admin")
    public String goToAdmin(ModelMap model) {
        return "admin";
    }
    @RequestMapping("/forumpage")
    public String goToForumPage(ModelMap model) {
        return "forumpage";
    }
    @RequestMapping("/petprofile")
    public String goToPetProfile(ModelMap model) { return "petprofile"; }
    @RequestMapping("/userprofile")
    public String goToUserProfile(ModelMap model) { return "userprofile"; }


}
