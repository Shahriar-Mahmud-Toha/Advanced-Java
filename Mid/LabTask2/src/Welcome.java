import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Welcome extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String fullname = (String) session.getAttribute("fullname");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Welcome.jsp");
        request.setAttribute("user", new User(email,null,fullname));
        requestDispatcher.forward(request, response);
        response.sendRedirect("Welcome.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}