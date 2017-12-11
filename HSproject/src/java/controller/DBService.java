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
    @Produces(MediaType.TEXT_HTML)
    public String register(@FormParam("username") String name, @FormParam("password") String password) {
        String r;
        //String SALT = "saltybitch";
        if (dbc.findUser(name).size() > 0){
            //if username exists return an error message to the client
            r = "Username already exists";
        } else {
            User u = new User();
            //String saltedpw = SALT + password;
            //String hashedpw = generateHash(saltedpw);
            u.setUsername(name);
            u.setPasswd(password);
            u.setReqDate(new Date());
            dbc.insertUser(u);
            r = "New user created!";
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
    
    
    /*public String generateHash(String input) {
    StringBuilder hash = new StringBuilder();

    try {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] hashedBytes = sha.digest(input.getBytes());
        char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
        for (int idx = 0; idx < hashedBytes.length; ++idx) {
            byte b = hashedBytes[idx];
            hash.append(digits[(b & 0xf0) >> 4]);
            hash.append(digits[b & 0x0f]);
        }
        } catch (NoSuchAlgorithmException e) {
            // handle error here.
	}
	return hash.toString();
    }*/
    
}


