package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.ForumDetails;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;

import java.util.List;

@Repository
public interface ForumPostRepository extends JpaRepository<ForumDetails.ForumPost, Long> {

    @Query(value = "SELECT COALESCE(MAX(id), 0)+1 FROM forum_post", nativeQuery = true)
    public Long newId();

    @Query("SELECT f, u FROM ForumPost f INNER JOIN User u WHERE f.posterId = u.id")
    public JSONArray findAllForumPosts();

    List<ForumDetails.ForumPost> findByPosterId(long posterId);
}
