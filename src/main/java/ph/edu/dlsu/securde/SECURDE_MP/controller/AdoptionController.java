package ph.edu.dlsu.securde.SECURDE_MP.controller;import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.Adoption;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AdoptionRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import javax.validation.Valid;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdoptionController {

   @Autowired
   private AdoptionRepository adoptionRepository;
   @Autowired
   private UserRepository userRepository;

    @GetMapping("/adoptions")
    public List<Adoption> getAllAdoptions() {
        List<Adoption> adopts = adoptionRepository.findAll();
        return adopts;
    }

    /*@GetMapping("/adoptions/{id}")
    public Adoption getAdoption(@PathVariable(value = "id") Long id) {
    }*/

    @PostMapping("/adoptions/new")
    public HashMap<String, Object> addAdoption(@Valid @RequestBody String form) {
        HashMap<String, Object> data = new HashMap<>();

        Long newId = userRepository.newId();
        Long newI = adoptionRepository.newId();

        JSONObject json = new JSONObject(form);
        Long adopterId = Long.parseLong((String)json.get("adopter_id"));
        Long petId = Long.parseLong((String)json.get("pet_id"));
        Date date = new Date((new java.util.Date()).getTime());

        Adoption a = new Adoption();
        a.setId(newId);
        a.setAdopterId(adopterId);
        a.setAdminId(petId);
        a.setDateAdopted(date);


        return data;
    }
}
