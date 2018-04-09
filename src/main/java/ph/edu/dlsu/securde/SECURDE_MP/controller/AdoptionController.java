package ph.edu.dlsu.securde.SECURDE_MP.controller;import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.Adoption;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalDetails;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AdoptionRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AnimalDetailsRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.RoleRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
   @Autowired
   private RoleRepository roleRepository;
   @Autowired
   private AnimalDetailsRepository animalDetailsRepository;

    @GetMapping("/adoptions")
    public List<Adoption> getAllAdoptions() {
        List<Adoption> adopts = adoptionRepository.findAll();
        return adopts;
    }

    @GetMapping("/adoptions/{id}")
    public Adoption getAdoption(@PathVariable(value = "id") Long id) {
        return adoptionRepository.findOne(id);
    }

    @PostMapping("/adoptions/new")
    public HashMap<String, Object> addAdoption(@Valid @RequestBody String form) {
        HashMap<String, Object> data = new HashMap<>();

        Long newId = adoptionRepository.newId();


        JSONObject json = new JSONObject(form);
        Long adopterId = Long.parseLong((String)json.get("adopter_id"));
        Long petId = Long.parseLong((String)json.get("pet_id"));
        String str = (String)json.get("date");
        String array1[]= str.split("T");
        System.out.println(array1[0]);
        Date date = java.sql.Date.valueOf(array1[0]);

        Long status = new Long(1);
        Long adminId = animalDetailsRepository.findOne(petId).getAdminId();
        Adoption a = adoptionRepository.save(new Adoption(newId, adopterId, adminId, date, status, petId ));
        if (a != null) {

            data.put("msg", "success");
            data.put("a", a);

        } else data.put("msg", "Adoption Registration failed!");
        return data;
    }
    @PostMapping("/adoptions/{id}")
    public HashMap<String, Object> updateTransaction(HttpServletRequest request,
                                                @Valid @RequestBody String addForm, @PathVariable Long id) {
        HashMap<String, Object> data = new HashMap();

        HttpSession ses = request.getSession(false);
        if (ses == null) {
            data.put("success", false);
            data.put("msg", "You are unauthorized to commit this action!");
        } else {
            User u = (User) ses.getAttribute("user");
            if (u == null || u.getRoleCode() != roleRepository.findRoleByRole("ADMIN").getCode()) {
                data.put("success", false);
                data.put("msg", "You are unauthorized to commit this action!");
            } else {
                JSONObject json = new JSONObject(addForm);
                long status = Long.parseLong((String)json.get("status"));
                if ( status > 0 ){
                    Adoption adopt = adoptionRepository.findOne(id);
                    if (adopt != null) {
                        adopt.setStatusCode(status);
                        adoptionRepository.save(adopt);
                        data.put("success", true);
                        data.put("msg", "Transaction information successfully updated!");
                    }
                }
            }
        }
        return data;
    }
}
