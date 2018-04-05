package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ForumPost {
    @Id
    @Column
    private Long id;
    @Column
    private Long posterId;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Date postDate;

    public ForumPost() {}

    public ForumPost(Long id, Long posterId, String title, String content, Date postDate) {
        this.id = id;
        this.posterId = posterId;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosterId() {
        return posterId;
    }

    public void setPosterId(Long posterId) {
        this.posterId = posterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "ForumPost{" +
                "id=" + id +
                ", posterId=" + posterId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
