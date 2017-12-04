package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
            String title = request.getParameter("imgTitle");
            String description = request.getParameter("imgDesc");
            //saves the img to the server
            request.getPart("uploadedImg").write(request.getPart("uploadedImg").getSubmittedFileName());
            out.print("{\"src\" : \"//10.114.34.129/uploads/" + request.getPart("uploadedImg").getSubmittedFileName() +"\"}");
           
        }   
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
