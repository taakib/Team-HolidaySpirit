package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
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
@MultipartConfig(location = "/var/www/html/uploads")
public class DBService {
    
    @EJB
    private DBController dbc;
   
    public DBService() {
    }
  
    /*
    //store a new cookie
    @GET
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login() {
        NewCookie cookie = new NewCookie("name", "123");
        return Response.ok("OK").cookie(cookie).build();
    }
    //to retrieve a cookie
    @GET
    @Path("/foo")
    @Produces(MediaType.TEXT_PLAIN)
    public Response foo(@CookieParam("name") Cookie cookie) {
        if (cookie == null) {
            return Response.serverError().entity("ERROR").build();
        } else {
            return Response.ok(cookie.getValue()).build();
        }
    }
    
    //returns only the cookie value
    @GET
    @Path("/foo")
    @Produces(MediaType.TEXT_PLAIN)
    public Response foo(@CookieParam("name") String value) {
        System.out.println(value);
        if (value == null) {
            return Response.serverError().entity("ERROR").build();
        } else {
            return Response.ok(value).build();
        }
    }
    
    //removes a cookie
    @GET
    @Path("/logout")
    @Produces(MediaType.TEXT_PLAIN)
    public Response logout(@CookieParam("name") Cookie cookie) {
        if (cookie != null) {
            NewCookie newCookie = new NewCookie(cookie, null, 0, false);
            return Response.ok("OK").cookie(newCookie).build();
        }
        return Response.ok("OK - No session").build();
    }
    */
    
    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@FormParam("username") String name, @FormParam("password") String password) {
        Response r;
        if (dbc.findUsername(name) != null){
            //if username exists return an error message to the client
            r = Response.noContent().build();
        } else {
            User u = new User();
            u.setUsername(name);
            //hash password
            u.setPasswd(password);
            dbc.insertUser(u);
            r = Response.ok().build();
        }
        return r;
    }
    
    /*@POST
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
    }*/
    
    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logOut() {
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
