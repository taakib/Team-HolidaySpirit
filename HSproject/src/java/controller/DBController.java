package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;
import model.Post;
import model.Tags;
import model.Favourites;

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
    
    public List<User> getAll(){
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    public User insert(User u){
        em.persist(u);
        return u;
    }
}
