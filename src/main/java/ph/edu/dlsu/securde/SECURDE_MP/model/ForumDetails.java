package ph.edu.dlsu.securde.SECURDE_MP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

public class ForumDetails {
    @Entity
    public static class ForumPost {
        @Id
        @Column
        private Long id;
        @Column
        private Long posterId;
        @Column
        private String title;
        @Column
        private Date postDate;

        public ForumPost() {}

        public ForumPost(Long id, Long posterId, String title, Date postDate) {
            this.id = id;
            this.posterId = posterId;
            this.title = title;
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
                    ", postDate=" + postDate +
                    '}';
        }
    }
}
