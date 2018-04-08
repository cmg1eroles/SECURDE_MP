package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.*;
import ph.edu.dlsu.securde.SECURDE_MP.repository.CommentRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.ForumPostRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ForumController {

    @Autowired
    private ForumPostRepository forumPostRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/forums")
    public List<ForumDetails> getAllForums() {
        List<ForumPost> posts = forumPostRepository.findAll();
        List<ForumDetails> forums = new ArrayList<ForumDetails>();

        for(int i = 0; i < posts.size(); i++) {
            User user = userRepository.findOne(posts.get(i).getPosterId());
            forums.add( new ForumDetails(posts.get(i).getId(),
                                         user.getFirstName(),
                                         user.getLastName(),
                                         posts.get(i).getTitle(),
                                         posts.get(i).getPostDate()));
        }
        return forums;
    }

    @RequestMapping("/forums/{id}")
    public List<ForumComment> getForumComments(@PathVariable(value="id") Long id) {
        List<Comment> comments = commentRepository.findByForumId(id);
        List<ForumComment> forumPosts = new ArrayList<ForumComment>();

        for (int i = 0; i < comments.size(); i++) {
            User user = userRepository.findOne(comments.get(i).getCommentorId());
            forumPosts.add(new ForumComment(comments.get(i).getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    comments.get(i).getForumId(),
                    comments.get(i).getMsg(),
                    comments.get(i).getDatetime()
            ));
        }
        return forumPosts;
    }

    @DeleteMapping("/forums/{id}")
    public HashMap<String, Object> deleteAnimal(@PathVariable Long id) {
        HashMap<String, Object> data = new HashMap();

        List<ForumComment> comments = getForumComments(id);
        forumPostRepository.delete(id);
        for(int i = 0; i < comments.size(); i++)
            commentRepository.delete(comments.get(i).getId());
        data.put("success", true);
        return data;
    }
}

