/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author blure
 */
@Embeddable
public class FavouritesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_ID")
    private int userID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_ID")
    private int postID;

    public FavouritesPK() {
    }

    public FavouritesPK(int userID, int postID) {
        this.userID = userID;
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userID;
        hash += (int) postID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavouritesPK)) {
            return false;
        }
        FavouritesPK other = (FavouritesPK) object;
        if (this.userID != other.userID) {
            return false;
        }
        if (this.postID != other.postID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FavouritesPK[ userID=" + userID + ", postID=" + postID + " ]";
    }
    
}
