package ph.edu.dlsu.securde.SECURDE_MP.controller;import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.Adoption;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalDetails;
import ph.edu.dlsu.securde.SECURDE_MP.model.Breed;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private AnimalDetailsRepository animalDetailsRepository;

    @RequestMapping("/search/find/{word}")
    public List<AnimalDetails> goSearch(@PathVariable(value="word") String word, ModelMap model) {
        Breed breed = breedRepository.findBreedByBreed(word);
        if (breed != null) {
            model.put("success", true);
            return animalDetailsRepository.findByBreedCode(breed.getCode());
        } else {
            model.put("success", false);
            model.put("msg","Breed Not Found!");
            return null;
        }

    }

}
