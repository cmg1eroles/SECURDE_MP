package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.ForumPost;

import java.util.List;

@Repository
public interface ForumPostRepository extends JpaRepository<ForumPost , Long> {

    @Query(value = "SELECT COALESCE(MAX(id), 0)+1 FROM forum_post", nativeQuery = true)
    public Long newId();

    List<ForumPost> findByPosterId(long posterId);
}
