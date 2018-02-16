package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Adoption {

    @Id
    @Column
    private Long id;
    @Column
    private Long adopterId;
    @Column
    private Long adminId;
    @Column
    private Date dateAdopted;

    public Adoption() {}

    public Adoption(Long id, Long adopterId, Long adminId, Date dateAdopted) {
        this.id = id;
        this.adopterId = adopterId;
        this.adminId = adminId;
        this.dateAdopted = dateAdopted;
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
}
