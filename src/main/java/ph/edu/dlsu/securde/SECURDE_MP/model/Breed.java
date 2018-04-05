package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;

@Entity
public class Breed {
    @Id
    @Column
    private Long code;
    @Column
    private Long animalTypeCode;
    @Column
    private String breed;

    public Breed() {}

    public Breed(Long code, Long animalTypeCode, String breed) {
        this.code = code;
        this.animalTypeCode = animalTypeCode;
        this.breed = breed;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getAnimalTypeCode() {
        return animalTypeCode;
    }

    public void setAnimalTypeCode(Long animalTypeCode) {
        this.animalTypeCode = animalTypeCode;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "code=" + code +
                ", animalTypeCode=" + animalTypeCode +
                ", breed='" + breed + '\'' +
                '}';
    }
}
