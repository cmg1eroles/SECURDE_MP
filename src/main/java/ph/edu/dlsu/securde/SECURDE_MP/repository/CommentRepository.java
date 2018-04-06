package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT COALESCE(MAX(id), 0)+1 FROM comment", nativeQuery = true)
    public Long newId();

    List<Comment> findByForumId(long forumId);
}
