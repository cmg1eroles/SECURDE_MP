package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;

@Entity
public class AnimalType {
    @Id
    @Column
    private Long code;
    @Column
    private String animalType;

    public AnimalType() {}

    public AnimalType(Long code, String animalType) {
        this.code = code;
        this.animalType = animalType;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "code=" + code +
                ", animalType='" + animalType + '\'' +
                '}';
    }
}
