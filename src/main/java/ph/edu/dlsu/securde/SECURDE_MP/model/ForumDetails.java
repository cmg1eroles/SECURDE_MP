package ph.edu.dlsu.securde.SECURDE_MP.model;

import java.sql.Date;

public class ForumDetails {
    private Long id;
    private String firstname;
    private String lastname;
    private String title;
    private Date postDate;

   public ForumDetails(Long id, String firstname, String lastname, String title, Date postDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.postDate = postDate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }


}
