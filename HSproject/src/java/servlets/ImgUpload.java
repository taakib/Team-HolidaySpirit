package servlets;

import controller.DBController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
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
@WebServlet(name = "ImgUpload", urlPatterns = {"/imgupload"})
@MultipartConfig(location = "/var/www/html/uploads") //set a maximum file size
public class ImgUpload extends HttpServlet {
    
    @EJB
    private DBController dbc;

   
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
        try (PrintWriter out = response.getWriter()) {
            //rename files so they are not overwritten 
            Post p = new Post();
            p.setSourceUrl("//10.114.34.129/uploads/" + request.getPart("imgfile").getSubmittedFileName());
            p.setTitle(request.getParameter("imgTitle"));
            p.setDescription(request.getParameter("imgDesc"));
            //p.setTagsCollection(tags);
            //p.setUploaderId(uploaderID); get id from cookies
            dbc.insertPost(p);   
            request.getPart("imgfile").write(request.getPart("imgfile").getSubmittedFileName());
            out.print("{\"src\" : \"//10.114.34.129/uploads/" + request.getPart("imgfile").getSubmittedFileName() +"\"}");
        }   
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
