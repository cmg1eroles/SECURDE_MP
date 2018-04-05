package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;

@Entity
public class Breed {
    @Id
    @Column
    private Long code;
    @Column
    private String breed;

    public Breed() {}


}
