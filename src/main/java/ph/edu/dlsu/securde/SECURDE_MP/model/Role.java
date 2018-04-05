package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @Column
    private Long code;
    @Column
    private String role;

    public Role() {}

    public Role(Long code, String role) {
        this.code = code;
        this.role = role;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "code=" + code +
                ", role='" + role + '\'' +
                '}';
    }
}
