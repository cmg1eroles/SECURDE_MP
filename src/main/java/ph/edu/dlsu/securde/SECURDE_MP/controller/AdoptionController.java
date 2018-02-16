package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.dlsu.securde.SECURDE_MP.model.Adoption;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostAdoption;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AdoptionRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
public class AdoptionController {

    @Autowired
    private AdoptionRepository adoptionRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostAdoption paRepo;

    /*@GetMapping("/adoptions")
    public List<Adoption> getAllAdoptions() {

    }*/

    /*@GetMapping("/adoptions/{id}")
    public Adoption getAdoption(@PathVariable(value = "id") Long id) {

    }*/

    /*@PostMapping("/adoptions/{id}")
    public Adoption updateAdoption(@PathVariable(value = "id") Long id) {

    }*/

    /*@GetMapping("/users/{id}/adoptions")
    public List<Adoption> getAdoptionsOfUser(@PathVariable(value = "id") Long id) {

    }*/
}
