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
    private Float weight;
    @Column
    private String vaccines;
    @Column
    private String specConds;
    @Column
    private Long breedCode;
    @Column
    private Long adminId;

    public AnimalDetails() {}

    public AnimalDetails(Long id, String picPath, Long animalTypeCode, Float weight, String vaccines, String specConds, Long breedCode, Long adminId) {
        this.id = id;
        this.picPath = picPath;
        this.animalTypeCode = animalTypeCode;
        this.weight = weight;
        this.vaccines = vaccines;
        this.specConds = specConds;
        this.breedCode = breedCode;
        this.adminId = adminId;
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

    public Float getWeight() {
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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
                ", adminId=" + adminId +
                '}';
    }

    public boolean isValid()  {
        if(picPath.length() <= 0 || animalTypeCode <= 0 || weight <= 0 || vaccines.length() <= 0 || specConds.length() <= 0 || breedCode <= 0)
            return false;
        String animalcode = String.valueOf(getAnimalTypeCode());
        String weight = String.valueOf(getWeight());
        String breedcode = String.valueOf(getBreedCode());

        for(int i = 0; i < animalcode.length(); i++) {
            if(Character.isLetter(animalcode.charAt(0)))
                return false;
        }
        for(int i = 0; i < weight.length(); i++) {
            if(Character.isLetter(weight.charAt(i)))
                return false;
        }

        for(int i = 0; i < breedcode.length(); i++) {
            if(Character.isLetter(breedcode.charAt(0)))
                return false;
        }
        return true;
    }
}
