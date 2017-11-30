package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;
import model.Post;
import model.Tags;
import model.Favourites;
import model.FavouritesPK;

/**
 *
 * @author blure
 */
@Stateless
public class DBController {
    
    @PersistenceContext
    private EntityManager em;
    
    public DBController() {
    }
    
    public List<User> getAllUsers(){
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    public User insertUser(User u){
        em.persist(u);
        return u;
    }
    
    public List<Post> getAllPosts(){
        return em.createNamedQuery("Post.findAll").getResultList();
    }
    
    public Post insertPost(Post p){
        em.persist(p);
        return p;
    }
    
    public List<Tags> getAllTags(){
        return em.createNamedQuery("Tags.findAll").getResultList();
    }
    
    public List<Favourites> getAllFavs(){
        return em.createNamedQuery("Favourites.findAll").getResultList();
    }
    
    public Favourites insertFav(Favourites f){
        em.persist(f);
        return f;
    }
    
    public List<FavouritesPK> getAllFavsPK(){
        return em.createNamedQuery("FavouritesPK.findAll").getResultList();
    }
    
    public FavouritesPK insertFavsPK(FavouritesPK f){
        em.persist(f);
        return f;
    }
}
