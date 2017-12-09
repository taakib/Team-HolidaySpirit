package model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author blure
 */
@Entity
@Table(name = "Post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
    , @NamedQuery(name = "Post.findBySourceUrl", query = "SELECT p FROM Post p WHERE p.sourceUrl = :sourceUrl")
    , @NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title")
    , @NamedQuery(name = "Post.findByDescription", query = "SELECT p FROM Post p WHERE p.description = :description")
    , @NamedQuery(name = "Post.findByUploadTime", query = "SELECT p FROM Post p WHERE p.uploadTime = :uploadTime")
    , @NamedQuery(name = "Post.findByViews", query = "SELECT p FROM Post p WHERE p.views = :views")})
public class Post implements Serializable {

    @OneToMany(mappedBy = "postId")
    private List<Comments> commentsList;
    @Column(name = "views")
    private Integer views;
    @OneToMany(mappedBy = "postID")
    private List<Tags> tagsList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 200)
    @Column(name = "source_url", length = 200)
    private String sourceUrl;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 30)
    @Column(name = "title", length = 30)
    private String title;
    //@Size(max = 140)
    @Column(name = "description", length = 140)
    private String description;
    @Column(name = "upload_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;
    @JoinColumn(name = "uploader_id", referencedColumnName = "ID")
    @ManyToOne
    private User uploaderId;

    public Post() { 
        this.views = 0;
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String sourceUrl, String title) {
        this.id = id;
        this.sourceUrl = sourceUrl;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
    
    public User getUploaderId() {
        return uploaderId;
    }
    
     public void setUploaderId(User uploaderID) {
        this.uploaderId = uploaderID;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        return other.id == this.id;
    }

    @Override
    public String toString() {
        return "model.Post[ id=" + id + " ]";
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @XmlTransient
    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    @XmlTransient
    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }
}
