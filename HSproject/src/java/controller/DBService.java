package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
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

    /**
     * Creates a new instance of DBService
     */
    public DBService() {
    }

    /**
     * Retrieves representation of an instance of controller.DBService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getJson() {
        return dbc.getAllUsers();
    }
    

    /**
     * PUT method for updating or creating an instance of DBService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User post(@FormParam("value") String name) {
        User u = new User();
        u.setUsername(name);
        return dbc.insertUser(u);
    }
    
    /*@POST
    @Path("kissa")
    */
}
