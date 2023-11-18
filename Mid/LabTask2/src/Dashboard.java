import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Dashboard extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("login.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("page")!=null && request.getParameter("page").equals("registration")){
            User user = new User(request.getParameter("email"), request.getParameter("password"), request.getParameter("fullname"));
            try {
                RegistrationDB.create(user);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("login.jsp");
        }
        if(request.getParameter("page")!=null && request.getParameter("page").equals("login")){
            User user = new User(request.getParameter("email"), request.getParameter("password"), null);
            try {
                String fullname = RegistrationDB.authenticate(user);
                if(fullname!=null){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("loginStatus", true);
                    session.setAttribute("email", request.getParameter("email"));
                    session.setAttribute("fullname", fullname);
                    response.sendRedirect("Welcome");
                }
                else {
                    response.sendRedirect("login.jsp");
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}