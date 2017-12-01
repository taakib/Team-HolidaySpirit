package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.User;
import model.Post;
import model.Tags;
import model.Favourites;
import model.FavouritesPK;

/**
 * REST Web Service
 *
 * @author blure
 */
@Path("service")
public class DBService {

    @EJB
    private DBController dbc;

    public DBService() {
    }

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserJson() {
        return dbc.getAllUsers();
    }
    
    @PUT
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putUserJson(String content) {
    }

    @POST
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public User postUser(@FormParam("value") String name) {
        User u = new User();
        u.setUsername(name);
        return dbc.insertUser(u);
    }
    
    @GET
    @Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPostJson() {
        return dbc.getAllPosts();
    }
    
    @POST
    @Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    public Post postPost() {
        return null;
    }
    
    @GET
    @Path("tags")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tags> getTagsJson() {
        return dbc.getAllTags();
    }
    
    @GET
    @Path("favourites")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Favourites> getFavsJson() {
        return dbc.getAllFavs();
    }
    @POST
    @Path("favourites")
    @Produces(MediaType.APPLICATION_JSON)
    public Post postFav() {
        return null;
    }  
}
