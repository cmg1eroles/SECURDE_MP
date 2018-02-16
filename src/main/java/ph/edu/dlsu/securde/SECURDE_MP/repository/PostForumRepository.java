package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.PostForum;

@Repository
public interface PostForumRepository extends JpaRepository<PostForum, Long> {
}
