package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.Post;
import model.Tags;

/**
 *
 * @author blure
 */
@WebServlet(name = "FileUpload", urlPatterns = {"/fileupload"})
@MultipartConfig(location = "/var/www/html/uploads") //create folder for imgs
public class FileUpload extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.setContentType("application/json");
        
        //saves file to the server tmp folder
        request.getPart("uploadedImg").write(request.getPart("uploadedImg").getSubmittedFileName());
        Post p = new Post();
        p.setSourceUrl("10.114.34.129/uploads/" + request.getPart("uploadedImg").getSubmittedFileName() +"\"}");
        //p.setUploaderId(uploaderID); //get from session id?
        p.setTitle(request.getParameter("imgTitle"));
        p.setDescription(request.getParameter("imgDesc"));
        //p.setTags(); //how to set multiple? list etc?
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
