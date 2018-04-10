package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.Adoption;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    @Query(value = "SELECT COALESCE(MAX(id), 0)+1 FROM adoption", nativeQuery = true)
    public Long newId();

    List<Adoption> findByAdopterId(long adopterId);
    Adoption findByAnimalId(long animalId);
}
