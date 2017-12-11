package servlets;

import controller.DBController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.NewCookie;
import model.User;

/**
 *
 * @author pirat
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

   
    @EJB
    private DBController dbc;


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            List<User> userList = dbc.findLoginCredentials(username, password);
            if (userList.size() > 0) {
                HttpSession session = request.getSession();
                session.setAttribute(username, dbc.getUserIdByName(username));
                //setting session to expire in 3 mins
                session.setMaxInactiveInterval(3*60);
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(60 * 1);
                response.addCookie(cookie);
                //request.getSession().setAttribute("userList", userList);
                //response.sendRedirect("search.html");
                out.print("Login successful");
            } else if (userList.isEmpty()) {
                out.print("error, Unknown user. Please try again");
                //request.setAttribute("error", "Unknown user, please try again");
                //request.getRequestDispatcher("/login.html").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
