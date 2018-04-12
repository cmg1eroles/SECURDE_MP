package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.*;
import ph.edu.dlsu.securde.SECURDE_MP.repository.*;
import ph.edu.dlsu.securde.SECURDE_MP.service.LoggingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalDetailsRepository animalDetailsRepository;
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private AnimalTypeRepository animalTypeRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LoggingService logService;

    @GetMapping("/animal/types")
    public List<AnimalType> getAllTypes() {
        return animalTypeRepository.findAll();
    }

    @GetMapping("/animal/adoptions")
    public List<AnimalDetails> getAllPostAdoptions() {
        return animalDetailsRepository.findAll();
    }

    @GetMapping("/animal/adoptions/{id}")
    public List<AnimalDetails> getAllPostAdoptionsByType(@PathVariable Long id) {
        return animalDetailsRepository.findByAnimalTypeCode(id);
    }

    @GetMapping("/animal/{id}")
    public AnimalDetails getAnimalDetails(@PathVariable Long id) {
        return animalDetailsRepository.findOne(id);
    }

    @GetMapping("/animal/breeds")
    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }

    @GetMapping("/animal/status")
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @PostMapping("/animal/register")
    public HashMap<String, Object> addAnimal(HttpServletRequest request,
                                             @Valid @RequestBody String addForm) {
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
                long type = Long.parseLong((String) json.get("type"));
                long breed = Long.parseLong((String) json.get("breed"));
                float weight = Float.parseFloat((String) json.get("weight"));
                String vaccines = (String) json.get("vaccines");
                String speccond = (String) json.get("speccond");
                String picpath = (String) json.get("picpath");
                long adminId = Long.parseLong((String)json.get("adminId"));

                if (type == 0 || breed == 0 || weight == 0 || vaccines.equals("")
                        || speccond.equals("") || picpath.equals("")) {
                    data.put("msg", "Please fill out all fields.");
                } else {
                    Long id = animalDetailsRepository.newId();
                    AnimalDetails animal = animalDetailsRepository.save(new AnimalDetails(id, picpath, type, weight, vaccines, speccond, breed, adminId));
                    if (animal != null && animal.isValid()) {

                        data.put("msg", "success");
                        data.put("animal", animal);
                        logService.addAnimal(u, animal);

                    } else data.put("msg", "Animal Registration failed!");
                }
            }
        }
        return data;
    }

    @PostMapping("/animal/{id}")
    public HashMap<String, Object> updateAnimal(HttpServletRequest request,
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
                float weight = Float.parseFloat((String) json.get("weight"));
                String vaccines = (String) json.get("vaccines");
                String speccond = (String) json.get("speccond");
                //long adminId = Long.parseLong((String)json.get("adminId"));

                if (weight == 0 || vaccines.equals("")
                        || speccond.equals("")) {
                    data.put("msg", "Please fill out all fields.");
                } else {
                    long adminId = 2;
                    AnimalDetails animal = animalDetailsRepository.findOne(id);
                    if (animal != null) {
                        animal.setWeight(weight);
                        animal.setVaccines(vaccines);
                        animal.setSpecConds(speccond);
                        animalDetailsRepository.save(animal);
                        data.put("success", true);
                        data.put("msg", "Animal information successfully updated!");
                        logService.editAnimalInfo(u, animal);
                    }
                }
            }
        }
        return data;
    }

    @DeleteMapping("/animal/{id}")
    public HashMap<String, Object> deleteAnimal(HttpServletRequest request, @PathVariable Long id) {
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
                AnimalDetails animal = animalDetailsRepository.findOne(id);
                animalDetailsRepository.delete(id);
                data.put("success", true);
                logService.deleteAnimal(u, animal);
            }
        }
        return data;
    }
}