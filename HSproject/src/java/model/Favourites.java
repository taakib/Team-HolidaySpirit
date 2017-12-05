package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author blure
 */
@Entity
@Table(name = "Favourites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favourites.findAll", query = "SELECT f FROM Favourites f")
    , @NamedQuery(name = "Favourites.findByUserID", query = "SELECT f FROM Favourites f WHERE f.favouritesPK.userID = :userID")
    , @NamedQuery(name = "Favourites.findByPostID", query = "SELECT f FROM Favourites f WHERE f.favouritesPK.postID = :postID")
    , @NamedQuery(name = "Favourites.findByFavouriteTime", query = "SELECT f FROM Favourites f WHERE f.favouriteTime = :favouriteTime")})
public class Favourites implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavouritesPK favouritesPK;
    @Column(name = "favourite_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date favouriteTime;

    public Favourites() {
    }

    public Favourites(FavouritesPK favouritesPK) {
        this.favouritesPK = favouritesPK;
    }

    public Favourites(int userID, int postID) {
        this.favouritesPK = new FavouritesPK(userID, postID);
    }

    public FavouritesPK getFavouritesPK() {
        return favouritesPK;
    }

    public void setFavouritesPK(FavouritesPK favouritesPK) {
        this.favouritesPK = favouritesPK;
    }

    public Date getFavouriteTime() {
        return favouriteTime;
    }

    public void setFavouriteTime(Date favouriteTime) {
        this.favouriteTime = favouriteTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favouritesPK != null ? favouritesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favourites)) {
            return false;
        }
        Favourites other = (Favourites) object;
        if ((this.favouritesPK == null && other.favouritesPK != null) || (this.favouritesPK != null && !this.favouritesPK.equals(other.favouritesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Favourites[ favouritesPK=" + favouritesPK + " ]";
    }
    
}
