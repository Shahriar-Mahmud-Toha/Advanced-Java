import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Dashboard extends HttpServlet {

    public void init() throws ServletException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Welcome, ");

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");

        // Use the retrieved data as needed
        out.println(firstName + " " + lastName);
    }
}