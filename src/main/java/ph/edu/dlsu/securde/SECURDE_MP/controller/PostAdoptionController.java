package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostAdoption;
import ph.edu.dlsu.securde.SECURDE_MP.repository.PostAdoptionRepository;

import javax.xml.ws.Response;
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

    /*@PostMapping("post/adoptions/{id}")
    public ResponseEntity<PostAdoption> updatePostAdoption(@PathVariable(value = "id") Long id,
                                                           String form) {

    }*/
}
