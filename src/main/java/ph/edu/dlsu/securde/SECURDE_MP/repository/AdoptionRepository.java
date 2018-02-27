package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.Adoption;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

    @Query(value = "SELECT MAX(id)+1 FROM adoption",
            nativeQuery = true)
    public Long newId();
}
