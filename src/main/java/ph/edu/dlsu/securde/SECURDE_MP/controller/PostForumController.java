package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostForum;
import ph.edu.dlsu.securde.SECURDE_MP.repository.PostForumRepository;

import java.util.List;

@RestController
public class PostForumController {

    @Autowired
    private PostForumRepository pfRepo;

    @GetMapping("/posts/forum")
    public List<PostForum> getAllPostForums() {
        return pfRepo.findAll();
    }

    @GetMapping("/posts/forum/{id}")
    public ResponseEntity<PostForum> getPostForum(@PathVariable(value = "id") Long id) {
        PostForum pf = pfRepo.findOne(id);
        if (pf == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(pf);
    }

    /*@PostMapping("/posts/forum/{id}")
    public ResponseEntity<PostForum> updatePostForum(@PathVariable(value = "id") Long id,
                                                     String form) {

    }*/
}
