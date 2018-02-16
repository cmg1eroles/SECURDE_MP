package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.dlsu.securde.SECURDE_MP.model.Comment;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostForum;
import ph.edu.dlsu.securde.SECURDE_MP.repository.CommentRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.PostForumRepository;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostForumRepository pfRepo;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable(value = "id") Long id) {
        return commentRepo.findOne(id);
    }

    @GetMapping("/post/forum/{id}/comments")
    public List<Comment> getCommentsOfPost(@PathVariable(value = "id") Long id) {
        return commentRepo.findCommentByForumId(id);
    }

    /*@PostMapping("/comments/{id}")
    public Comment updateComment(@PathVariable(value = "id") Long id,
                                 String form) {

    }*/
}
