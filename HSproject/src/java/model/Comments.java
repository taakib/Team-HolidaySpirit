package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author blure
 */
@Entity
@Table(name = "Comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c")
    , @NamedQuery(name = "Comments.findById", query = "SELECT c FROM Comments c WHERE c.id = :id")
    , @NamedQuery(name = "Comments.findByCommentText", query = "SELECT c FROM Comments c WHERE c.commentText = :commentText")
    , @NamedQuery(name = "Comments.findByCommentTime", query = "SELECT c FROM Comments c WHERE c.commentTime = :commentTime")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 140)
    @Column(name = "comment_text", length = 140)
    private String commentText;
    @Column(name = "comment_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTime;
    @JoinColumn(name = "commenter_id", referencedColumnName = "ID")
    @ManyToOne
    private User commenterId;
    @JoinColumn(name = "post_id", referencedColumnName = "ID")
    @ManyToOne
    private Post postId;

    public Comments() {
    }

    public Comments(Integer id) {
        this.id = id;
    }

    public Comments(Integer id, String commentText) {
        this.id = id;
        this.commentText = commentText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public User getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(User commenterId) {
        this.commenterId = commenterId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((Integer)id).hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        return other.id == this.id;
    }

    @Override
    public String toString() {
        return "model.Comments[ id=" + id + " ]";
    }
    
}
