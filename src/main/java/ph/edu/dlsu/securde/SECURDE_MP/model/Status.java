package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @Column
    private Long code;
    @Column
    private String status;

    public Status() {}

    public Status(Long code, String status) {
        this.code = code;
        this.status = status;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", status='" + status + '\'' +
                '}';
    }
}
