package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class AnimalDetails {
    @Id
    @Column
    private Long id;
    @Column
    private String picPath;
    @Column
    private Long animalTypeCode;
    @Column
    private float weight;
    @Column
    private String vaccines;
    @Column
    private String specConds;
    @Column
    private Long breedCode;
    @Column
    private Date birthdate;
    @Column
    private boolean rescued;

    public AnimalDetails() {}

    public AnimalDetails(Long id, String picPath, Long animalTypeCode, float weight, String vaccines, String specConds, Long breedCode, Date birthdate, boolean rescued) {
        this.id = id;
        this.picPath = picPath;
        this.animalTypeCode = animalTypeCode;
        this.weight = weight;
        this.vaccines = vaccines;
        this.specConds = specConds;
        this.breedCode = breedCode;
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

    public Long getAnimalTypeCode() {
        return animalTypeCode;
    }

    public void setAnimalTypeCode(Long animalTypeCode) {
        this.animalTypeCode = animalTypeCode;
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

    public Long getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(Long breedCode) {
        this.breedCode = breedCode;
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

    @Override
    public String toString() {
        return "AnimalDetails{" +
                "id=" + id +
                ", picPath='" + picPath + '\'' +
                ", animalTypeCode=" + animalTypeCode +
                ", weight=" + weight +
                ", vaccines='" + vaccines + '\'' +
                ", specConds='" + specConds + '\'' +
                ", breedCode=" + breedCode +
                ", birthdate=" + birthdate +
                ", rescued=" + rescued +
                '}';
    }
}
