package ph.edu.dlsu.securde.SECURDE_MP.model;

import java.sql.Date;

public class ForumComment {
    private Long id;
    private String firstname;
    private String lastname;
    private Long forumId;
    private String msg;
    private Date datetime;

    public ForumComment(Long id, String firstname, String lastname, Long forumId, String msg, Date datetime) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.forumId = forumId;
        this.msg = msg;
        this.datetime = datetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }


}
