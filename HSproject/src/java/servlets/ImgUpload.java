package servlets;

import controller.DBController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            //rename files so they are not overwritten
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
            Date date = new Date();
            String d = sdf.format(date);
            request.getPart("imgfile").write(d + request.getPart("imgfile").getSubmittedFileName());
            Post p = new Post();
            p.setSourceUrl("//10.114.34.129/uploads/" + d + request.getPart("imgfile").getSubmittedFileName());
            p.setTitle(request.getParameter("imgTitle"));
            p.setDescription(request.getParameter("imgDesc"));
            p.setUploadTime(new Date());
            //how to set tags for the post?
            /*String[] tags = request.getParameterValues("tag");
            ArrayList<Tags> tagsList = new ArrayList();
            for (String t : tags){
                Tags tag = new Tags();
                tag.setTagName(t);
                tagsList.add(tag);
            }
            p.setTagsList(tagsList);*/
            //how to get id from a cookie?
            //p.setUploaderId();
            //out.print("{\"src\" :" + p.getSourceUrl() +"\"}");
            dbc.insertPost(p);
            out.print("{\"src\" : \"//10.114.34.129/uploads/" + d + request.getPart("imgfile").getSubmittedFileName() +"\"}");
        }   
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
