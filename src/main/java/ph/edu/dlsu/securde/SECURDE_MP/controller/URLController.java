package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostAdoption;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.PostAdoptionRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class URLController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostAdoptionRepository postAdoptionRepository;

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

    @RequestMapping("/user/manage")
    public String manageUser(ModelMap model, HttpServletRequest request) {
        if (request.getSession(false) != null) {
            User u = (User) request.getSession().getAttribute("user");
            if (u != null) {
                model.put("username", u.getUsername());
                model.put("name", u.getName());
                model.put("email", u.getEmail());
                model.put("description", u.getDescription());
                return "manageprofile";
            }
        }
        return "errorpage";
    }

    @RequestMapping("/pet/{id}")
    public String pet(@PathVariable(value="id") Long id, ModelMap model) {
        PostAdoption adopt = postAdoptionRepository.findOne(id);
        model.put("type", adopt.getType());
        model.put("breed", adopt.getBreed());
        model.put("birthdate",adopt.getBirthdate() );
        model.put("rescued", adopt.isRescued() );
        model.put("weight", adopt.getWeight());
        model.put("vaccines", adopt.getVaccines() );
        model.put("speccond", adopt.getSpecConds() );
        return "petprofile";
    }

    @RequestMapping("/pet/{id}/manage")
    public String managePet(@PathVariable(value="id") Long id, ModelMap model) {
        PostAdoption adopt = postAdoptionRepository.findOne(id);
        model.put("type", adopt.getType());
        model.put("breed", adopt.getBreed());
        model.put("birthdate",adopt.getBirthdate() );
        model.put("rescued", adopt.isRescued() );
        model.put("weight", adopt.getWeight());
        model.put("vaccines", adopt.getVaccines() );
        model.put("speccond", adopt.getSpecConds() );
        return "managepet";
    }
}
