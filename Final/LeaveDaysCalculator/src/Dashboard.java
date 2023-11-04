import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

public class Dashboard extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("showPage") == null){
            List<Officer> officers = OfficerDB.getAll();
            request.setAttribute("officers", officers);
            List<Staff> staffs = StaffDB.getAll();
            request.setAttribute("staffs", staffs);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeDetails.jsp");
            requestDispatcher.forward(request, response);
        }
        if(request.getParameter("showPage") != null && request.getParameter("showPage").equals("officerUpdatePage") && request.getParameter("id") != null && OfficerDB.getOfficer(request.getParameter("id"))!=null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("officerUpdate.jsp");
            request.setAttribute("officer", OfficerDB.getOfficer(request.getParameter("id")));
            requestDispatcher.forward(request, response);
            response.sendRedirect("officerUpdate.jsp");
        }
        if(request.getParameter("showPage") != null && request.getParameter("showPage").equals("staffUpdatePage") && request.getParameter("id") != null && StaffDB.getStaff(request.getParameter("id"))!=null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("staffUpdate.jsp");
            request.setAttribute("staff", StaffDB.getStaff(request.getParameter("id")));
            requestDispatcher.forward(request, response);
            response.sendRedirect("staffUpdate.jsp");
        }
        if(request.getParameter("showPage")!=null && request.getParameter("showPage").equals("officerDeletePage") && request.getParameter("id")!=null){
            OfficerDB.delete(request.getParameter("id"));
            response.sendRedirect("Dashboard");
        }
        if(request.getParameter("showPage")!=null && request.getParameter("showPage").equals("staffDeletePage") && request.getParameter("id")!=null){
            StaffDB.delete(request.getParameter("id"));
            response.sendRedirect("Dashboard");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("showPage")!=null && request.getParameter("showPage").equals("officerCreatePage")){
            String dateOfBirthStr = request.getParameter("date_of_birth");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
            String joiningDateStr = request.getParameter("joining_date");
            LocalDate joiningDate = LocalDate.parse(joiningDateStr);

            Officer officer = new Officer(request.getParameter("id"), request.getParameter("name"), dateOfBirth, request.getParameter("email"), joiningDate);
            OfficerDB.create(officer);
            response.sendRedirect("Dashboard");
        }
        if(request.getParameter("showPage")!=null && request.getParameter("showPage").equals("staffCreatePage")){
            String dateOfBirthStr = request.getParameter("date_of_birth");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
            String joiningDateStr = request.getParameter("joining_date");
            LocalDate joiningDate = LocalDate.parse(joiningDateStr);

            Staff staff = new Staff(request.getParameter("id"), request.getParameter("name"), dateOfBirth, request.getParameter("email"), joiningDate);
            StaffDB.create(staff);
            response.sendRedirect("Dashboard");
        }
        if(request.getParameter("update")!=null && request.getParameter("update").equals("officer-data")){
            String dateOfBirthStr = request.getParameter("date_of_birth");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
            String joiningDateStr = request.getParameter("joining_date");
            LocalDate joiningDate = LocalDate.parse(joiningDateStr);

            Officer officer = new Officer(request.getParameter("id"), request.getParameter("name"), dateOfBirth, request.getParameter("email"), joiningDate);
            OfficerDB.update(officer);
            response.sendRedirect("Dashboard");
        }
        if(request.getParameter("update")!=null && request.getParameter("update").equals("staff-data")){
            String dateOfBirthStr = request.getParameter("date_of_birth");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
            String joiningDateStr = request.getParameter("joining_date");
            LocalDate joiningDate = LocalDate.parse(joiningDateStr);

            Staff staff = new Staff(request.getParameter("id"), request.getParameter("name"), dateOfBirth, request.getParameter("email"), joiningDate);
            StaffDB.update(staff);
            response.sendRedirect("Dashboard");
        }
    }
}