package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    
    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public void postUserRegister(@FormParam("username") String name, @FormParam("password") String password) {
        List<User> users = dbc.getAllUsers();
        for (User u : users){
            if (u.getUsername().contains(name)) {
                //return an error to the client side
                System.out.println("username already exists");
            } else {
                User userNew = new User();
                userNew.setUsername(name);
                userNew.setPasswd(password);
                dbc.insertUser(userNew);
            }
        }
    }
    
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public void postUserLogIn(@FormParam("username") String name, @FormParam("password") String password) {
        List <User> users = dbc.getAllUsers();
        for (User u : users){
            if (!u.getUsername().equals(name)) {
                //return an error message for the client
                System.out.println("username doesn't exist");
            } else {
                //create a session id?
                //what to do here? <o>
                //u.setLoggedIn(loggedIn);
            }
        }
    }
    
    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Post postUserLogOut() {
        return null;
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
