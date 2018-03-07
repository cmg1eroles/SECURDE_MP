package ph.edu.dlsu.securde.SECURDE_MP.model;

public enum RoleType {
    USER (1),
    ADMIN (2),
    SYSAD (3);

    private final int roleCode;

    RoleType(int roleCode) {
        this.roleCode = roleCode;
    }

    public int getCode() {
        return this.roleCode;
    }

    public String toString() {
        switch (this.roleCode) {
            case 1 : return "USER";
            case 2 : return "ADMINISTRATOR";
            case 3 : return "SYSTEM_ADMINISTRATOR";
            default : return "UNDEFINED";
        }
    }
}
