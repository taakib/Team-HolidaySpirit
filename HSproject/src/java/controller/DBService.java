package controller;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
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
public class DBService {
    
    @Context
    private HttpServletRequest request;

    @EJB
    private DBController dbc;
   
    public DBService() {
    }

    @POST
    @Path("register")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response register(@FormParam("username") String name, @FormParam("password") String password) {
        Response r;
        if (dbc.findUser(name).size() > 0){
            //if username exists return an error message to the client
            r = Response.ok("User already exists!").build();
        } else {
            User u = new User();
            u.setUsername(name);
            u.setPasswd(password);
            u.setReqDate(new Date());
            dbc.insertUser(u);
            r = Response.accepted("New user created!").build();
        }
        return r;
    }

    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logOut() {
       HttpSession session = request.getSession();
       session.invalidate();
       return Response.ok("Session ended").build();
    }
    
    @GET
    @Path("fetchImgs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> fetchImgs(){
        return dbc.getPosts();
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getSearchedPost(@FormParam("search") String searchWord ) {
        //query for all the posts that include the tag "searchWord"
        //if no results return an empty gallery
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


