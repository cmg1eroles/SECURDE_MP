package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.Adoption;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostAdoption;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AdoptionRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.PostAdoptionRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdoptionController {

    @Autowired
    private AdoptionRepository adoptionRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostAdoptionRepository paRepo;

    /*@GetMapping("/adoptions")
    public List<Adoption> getAllAdoptions() {
        List<Adoption> adopts = adoptionRepo.findAll();

        return adopts;
    }*/

    /*@GetMapping("/adoptions/{id}")
    public Adoption getAdoption(@PathVariable(value = "id") Long id) {

    }*/

    @PostMapping("/adoptions/new")
    public HashMap<String, Object> addAdoption(@Valid @RequestBody String form) {
        HashMap<String, Object> data = new HashMap<>();

        Long newId = adoptionRepo.newId();

        JSONObject json = new JSONObject(form);
        Long adopterId = Long.parseLong((String)json.get("adopter_id"));
        Long petId = Long.parseLong((String)json.get("pet_id"));
        Date date = new Date((new java.util.Date()).getTime());

        Adoption a = new Adoption();
        a.setId(newId);
        a.setAdopterId(adopterId);
        a.setAdminId(petId);
        a.setDateAdopted(date);

        adoptionRepo.save(a);

        return data;
    }

    /*@PostMapping("/adoptions/{id}")
    public Adoption updateAdoption(@PathVariable(value = "id") Long id) {

    }*/

    /*@GetMapping("/users/{id}/adoptions")
    public List<Adoption> getAdoptionsOfUser(@PathVariable(value = "id") Long id) {

    }*/
}
