package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.*;
import ph.edu.dlsu.securde.SECURDE_MP.repository.CommentRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.ForumPostRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.RoleRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;
import ph.edu.dlsu.securde.SECURDE_MP.service.LoggingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LoggingService logService;

    @PostMapping("/forums/new")
    public HashMap<String, Object> addForum(HttpServletRequest request, HttpServletResponse response,
                                             @Valid @RequestBody String addForm) {
        HashMap<String, Object> data = new HashMap();

        JSONObject json = new JSONObject(addForm);
        long userid = Long.parseLong((String) json.get("userid"));
        String title = (String) json.get("title");
        if ( title.equals("")) {
            data.put("msg", "Please fill out all fields.");
        } else {
            Long id = forumPostRepository.newId();
            java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
            ForumPost forum = forumPostRepository.save(new ForumPost(id,userid, title, date));
            if (forum != null) {

                data.put("success", true);
                logService.newForum(userRepository.findOne(userid), forum);

            } else data.put("msg", "Forum Registration failed!");
        }

        return data;
    }

    @PostMapping("/forums/comments/new")
    public HashMap<String, Object> addComment(HttpServletRequest request, HttpServletResponse response,
                                            @Valid @RequestBody String addForm) {
        HashMap<String, Object> data = new HashMap();

        JSONObject json = new JSONObject(addForm);
        long userid = Long.parseLong((String) json.get("userid"));
        long formid = Long.parseLong((String) json.get("formid"));
        ForumPost forum = forumPostRepository.findOne(formid);
        String msg = (String) json.get("msg");
        if ( msg.equals("")) {
            data.put("msg", "Please fill out all fields.");
        } else {
            Long id = commentRepository.newId();
            java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
            Comment comment = commentRepository.save(new Comment(id, userid, formid, msg, date));
            if (comment != null) {
                data.put("success", true);
                logService.commentForum(userRepository.findOne(userid), forum, comment);
            } else data.put("msg", "Comment Registration failed!");
        }

        return data;
    }
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
    @GetMapping("/forums/user/{id}")
    public List<ForumDetails> getUserForums(@PathVariable(value="id") Long id) {
        List<ForumPost> posts = forumPostRepository.findByPosterId(id);
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

    @GetMapping("/forums/{id}")
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
                List<ForumComment> comments = getForumComments(id);
                ForumPost forum = forumPostRepository.findOne(id);
                forumPostRepository.delete(id);
                for(int i = 0; i < comments.size(); i++)
                    commentRepository.delete(comments.get(i).getId());
                data.put("success", true);
                logService.deleteForum(u, forum);
            }
        }
        return data;
    }

}

