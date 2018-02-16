package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PostAdoption {

    @Id
    @Column
    private Long id;
    @Column
    private String picPath;
    @Column
    private String type;
    @Column
    private float weight;
    @Column
    private String vaccines;
    @Column
    private String specConds;
    @Column
    private String breed;
    @Column
    private Date birthdate;
    @Column
    private boolean rescued;

    public PostAdoption() {}

    public PostAdoption(Long id, String picPath, String type, float weight, String vaccines, String specConds, String breed, Date birthdate, boolean rescued) {
        this.id = id;
        this.picPath = picPath;
        this.type = type;
        this.weight = weight;
        this.vaccines = vaccines;
        this.specConds = specConds;
        this.breed = breed;
        this.birthdate = birthdate;
        this.rescued = rescued;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public String getSpecConds() {
        return specConds;
    }

    public void setSpecConds(String specConds) {
        this.specConds = specConds;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isRescued() {
        return rescued;
    }

    public void setRescued(boolean rescued) {
        this.rescued = rescued;
    }
}
