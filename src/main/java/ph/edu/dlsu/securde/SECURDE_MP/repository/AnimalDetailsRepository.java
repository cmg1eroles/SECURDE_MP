package ph.edu.dlsu.securde.SECURDE_MP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalDetails;

@Repository
public interface AnimalDetailsRepository extends JpaRepository<AnimalDetails, Long> {
    @Query(value = "SELECT COALESCE(MAX(id), 0)+1 FROM animal_details", nativeQuery = true)
    public Long newId();
}
