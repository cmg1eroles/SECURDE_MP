package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalDetails;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalType;
import ph.edu.dlsu.securde.SECURDE_MP.model.Breed;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class URLController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnimalDetailsRepository animalDetailsRepository;
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private AnimalTypeRepository animalTypeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/home")
    public String goToHome(HttpServletRequest request, ModelMap model) {
        HttpSession ses = request.getSession(false);
        if (ses == null)
            return "home";
        else {
            User u = (User) ses.getAttribute("user");
            if (u == null || u.getRoleCode() != roleRepository.findRoleByRole("ADMIN").getCode()) {
                return "home";
            } else {
                return "admin";
            }
        }
    }

    @RequestMapping("/admin")
    public String goToAdminView(HttpServletRequest request, ModelMap model) {
        return goToHome(request, model);
    }

    @RequestMapping("/forum")
    public String goToForum(ModelMap model) { return "forum"; }
    @RequestMapping("/forumpage")
    public String goToForumPage(ModelMap model) {
        return "forumpage";
    }
    @RequestMapping("/pet/{id}")
    public String pet(@PathVariable(value="id") Long id, ModelMap model) {
        AnimalDetails adopt = animalDetailsRepository.findOne(id);
        AnimalType type = animalTypeRepository.findOne(adopt.getAnimalTypeCode());
        Breed breed = breedRepository.findOne(adopt.getBreedCode());
        model.put("type", type.getAnimalType() );
        model.put("breed", breed.getBreed());
        model.put("picPath", adopt.getPicPath());
        model.put("weight", adopt.getWeight());
        model.put("vaccines", adopt.getVaccines() );
        model.put("speccond", adopt.getSpecConds() );
        model.put("id", adopt.getId() );
        return "petprofile";
    }
    @RequestMapping("/profile/{id}")
    public String profile(@PathVariable(value="id") Long id, ModelMap model) {
        User user = userRepository.findOne(id);
        model.put("username", user.getUsername());
        model.put("firstname", user.getFirstName());
        model.put("lastname", user.getLastName());
        model.put("email", user.getEmail());
        model.put("description", user.getDescription());
        return "userprofile";
    }
}
