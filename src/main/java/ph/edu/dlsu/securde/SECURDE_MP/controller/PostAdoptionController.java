package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostAdoption;
import ph.edu.dlsu.securde.SECURDE_MP.repository.PostAdoptionRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@RestController
public class PostAdoptionController {

    @Autowired
    private PostAdoptionRepository paRepo;

    @GetMapping("/posts/adoptions")
    public List<PostAdoption> getAllPostAdoptions() {
        return paRepo.findAll();
    }

    @GetMapping("posts/adoptions/{id}")
    public ResponseEntity<PostAdoption> getPostAdoption(@PathVariable(value = "id") Long id) {
        PostAdoption pa = paRepo.findOne(id);
        if (pa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(pa);
    }

    @PostMapping("post/adoptions/register")
    public HashMap<String, Object> registerPet(HttpServletRequest request, HttpServletResponse response,
                                               @Valid @RequestBody String regform) {
        HashMap<String, Object> data = new HashMap<>();

        JSONObject json = new JSONObject(regform);
        String type = (String) json.get("type");
        String breed = (String) json.get("breed");
        String birthdate = (String) json.get("birthday");
        boolean rescued = (boolean) json.get("rescue");
        float weight = Float.parseFloat((String)json.get("weight"));
        String vaccines = (String) json.get("vaccines");
        String speccond = (String) json.get("speccond");

        if (type.equals("") || breed.equals("") || birthdate.equals("")|| weight == 0|| vaccines.equals("") || speccond.equals((""))) {

        } else {
            PostAdoption post = null;
            try {
                Long newId = paRepo.newId();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date bDate = new java.sql.Date((sdf.parse(birthdate)).getTime());
                post = paRepo.save(new PostAdoption(newId, "none", type, weight, vaccines,
                        speccond, breed, bDate, rescued));
            } catch (Exception e) {
                e.printStackTrace();
            }

           if(post != null) {
            data.put("msg", "success");
            data.put("post_adoption", (Object) post);
           }
        }
        return data;
    }

    @PostMapping("post/adoptions/{id}")
    public HashMap<String, Object> updatePostAdoption(@PathVariable(value = "id") Long id,
                                                      @Valid @RequestBody String form) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("success", false);

        JSONObject json = new JSONObject(form);
        String type = (String) json.get("type");
        String breed = (String) json.get("breed");
        String birthdate = (String) json.get("birthday");
        boolean rescued = (boolean) json.get("rescue");
        float weight = Float.parseFloat((String)json.get("weight"));
        String vaccines = (String) json.get("vaccines");
        String speccond = (String) json.get("speccond");

        if (type.equals("") || breed.equals("") || birthdate.equals("") || weight == 0|| vaccines.equals("") || speccond.equals((""))) {

         } else {
            try {
                PostAdoption adopt = paRepo.findOne(id);
                adopt.setType(type);
                adopt.setBreed(breed);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date bDate = new java.sql.Date((sdf.parse(birthdate)).getTime());
                adopt.setBirthdate(bDate);
                adopt.setRescued(rescued);
                adopt.setWeight(weight);
                adopt.setVaccines(vaccines);
                adopt.setSpecConds(speccond);
                paRepo.save(adopt);
                data.put("success", true);
                data.put("msg", "Adoption Post successfully updated");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return data;
    }
}
