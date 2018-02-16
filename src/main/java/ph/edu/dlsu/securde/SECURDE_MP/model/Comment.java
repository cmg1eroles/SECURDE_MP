package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {

    @Id
    @Column
    private Long id;
    @Column
    private Long commentorId;
    @Column
    private Long forumId;
    @Column
    private String msg;
    @Column
    private Date datetime;

    public Comment() {}

    public Comment(Long id, Long commentorId, Long forumId, String msg, Date datetime) {
        this.id = id;
        this.commentorId = commentorId;
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

    public Long getCommentorId() {
        return commentorId;
    }

    public void setCommentorId(Long commentorId) {
        this.commentorId = commentorId;
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
