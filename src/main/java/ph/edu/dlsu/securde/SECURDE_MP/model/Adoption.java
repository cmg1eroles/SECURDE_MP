package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Adoption {
    @Id
    @Column
    private Long id;
    @Column
    private Long adopterId;
    @Column
    private Long animalId;
    @Column
    private Long adminId;
    @Column
    private Date dateAdopted;
    @Column
    private Long statusCode;

    public Adoption() {}

    public Adoption(Long id, Long adopterId, Long adminId, Date dateAdopted, Long statusCode, Long animalId) {
        this.id = id;
        this.adopterId = adopterId;
        this.adminId = adminId;
        this.dateAdopted = dateAdopted;
        this.statusCode = statusCode;
        this.animalId = animalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(Long adopterId) {
        this.adopterId = adopterId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Date getDateAdopted() {
        return dateAdopted;
    }

    public void setDateAdopted(Date dateAdopted) {
        this.dateAdopted = dateAdopted;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public Long getAnimalId() { return animalId;}

    public void setAnimalId(Long animalId) { this.animalId = animalId; }

    @Override
    public String toString() {
        return "Adoption{" +
                "id=" + id +
                ", adopterId=" + adopterId +
                ", adminId=" + adminId +
                ", dateAdopted=" + dateAdopted +
                ", statusCode=" + statusCode +
                '}';
    }
}
