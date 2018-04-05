package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByEmailAndPassword(String username, String password);

    @Query(value = "SELECT COALESCE(MAX(id), 0)+1 FROM user", nativeQuery = true)
    public Long newId();
}