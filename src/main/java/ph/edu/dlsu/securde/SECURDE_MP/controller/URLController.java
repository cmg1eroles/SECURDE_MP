package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.dlsu.securde.SECURDE_MP.model.*;
import ph.edu.dlsu.securde.SECURDE_MP.repository.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalDetails;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalType;
import ph.edu.dlsu.securde.SECURDE_MP.model.Breed;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    private CommentRepository commentRepository;
    @Autowired
    private ForumPostRepository forumPostRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AdoptionRepository adoptionRepository;

    @RequestMapping("/")
    public String defaultPage(HttpServletRequest request, ModelMap model) {
        return goToHome(request, model);
    }

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
    @RequestMapping("/search/{word}")
    public String goToSearch(@PathVariable(value="word") String word, ModelMap model) {
        System.out.println();
        model.put("search", word);
        return "search";
    }
    @RequestMapping("/type/{id}")
    public String goToType(@PathVariable(value="id") Long id, ModelMap model) {
        model.put("id", id);
        return "type";
    }
    @RequestMapping("/admin")
    public String goToAdminView(HttpServletRequest request, ModelMap model) {
        return goToHome(request, model);
    }

    @RequestMapping("/forumpage/{id}")
    public String goToForumPage(@PathVariable(value="id") Long id, ModelMap model) {
        ForumPost forum = forumPostRepository.findOne(id);
        User user = userRepository.findOne(forum.getPosterId());
        model.put("title", forum.getTitle());
        model.put("firstname", user.getFirstName());
        model.put("lastname", user.getLastName());
        model.put("date", forum.getPostDate());
        model.put("forumId", forum.getId());
        System.out.println(forum.getId());
        System.out.println(model.get("forumId"));
        return "forumpage";
    }
    @RequestMapping("/forum")
    public String goToForum(ModelMap model) { return "forum"; }

    @RequestMapping("/pet/{id}")
    public String pet(@PathVariable(value="id") Long id, ModelMap model) {
        AnimalDetails adopt = animalDetailsRepository.findOne(id);
        Adoption transaction = adoptionRepository.findByAnimalId(adopt.getId());
        AnimalType type = animalTypeRepository.findOne(adopt.getAnimalTypeCode());
        Breed breed = breedRepository.findOne(adopt.getBreedCode());
        model.put("type", type.getAnimalType() );
        model.put("breed", breed.getBreed());
        model.put("picPath", adopt.getPicPath());
        model.put("weight", adopt.getWeight());
        model.put("vaccines", adopt.getVaccines() );
        model.put("speccond", adopt.getSpecConds() );
        model.put("id", adopt.getId());
        if(transaction!= null) {
            model.put("status", transaction.getStatusCode());
        }
        else {
            model.put("status", '1');

        }

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
