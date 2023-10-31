import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SamplePage extends HttpServlet {

    public void init() throws ServletException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Lab 6 - Task 2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Registration</h1>");
        out.println("<form action=\"dashboard\" method=\"post\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>");
        out.println("<fieldset>");
        out.println("<legend>General Information</legend>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td><label for=\"fname\"><b>First Name :</b></label></td>");
        out.println("<td><input id=\"fname\" name=\"fname\" type=\"text\"></td>");
        out.println("</tr>");
        out.println("<tr><td></td><td></td></tr>");
        out.println("<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"lname\"><b>Last Name :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"lname\" name=\"lname\" type=\"text\"><br>" +
                "</td>" +
                "</tr>");

        out.println("<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"male\"><b>Gender :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"male\" name=\"gender\" type=\"radio\">Male" +
                "<input id=\"female\" name=\"gender\" type=\"radio\">Female" +
                "</td>" +
                "</tr>");
        out.println("<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"ftname\"><b>Father's Name :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"ftname\" type=\"text\"> &nbsp; &nbsp;<input id=\"photo\" type=\"file\">" +
                "</td>" +
                "</tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"mtname\"><b>Mother's Name :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"mtname\" type=\"text\">" +
                "</td>" +
                "</tr>");
        out.println("<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"bog\"><b>Blood Group :</b></label>" +
                "</td>" +
                "<td>" +
                "<select name=\"bog\" id=\"bog\">" +
                "<option value=\"A+\">A+</option>" +
                "<option value=\"A\">A</option>" +
                "<option value=\"A-\">A-</option>" +
                "<option value=\"B+\">B+</option>" +
                "<option value=\"B\">B</option>" +
                "<option value=\"B-\">B-</option>" +
                "<option value=\"O+\">O+</option>" +
                "<option value=\"O-\">O-</option>" +
                "<option value=\"AB+\">AB+</option>" +
                "<option value=\"AB-\">AB-</option>" +
                "</select>" +
                "</td>" +
                "</tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"bog\"><b>Religion :</b></label>" +
                "</td>" +
                "<td>" +
                "<select name=\"religion\" id=\"religion\">" +
                "<option selected value=\"Islam\">Islam</option>" +
                "<option value=\"Hindu\">Hindu</option>" +
                "<option value=\"Buddhist\">Buddhist</option>" +
                "<option value=\"Christians\">Christians</option>" +
                "</select>" +
                "</td>" +
                "</tr>");
        out.println("<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "</table>" +
                "</fieldset>" +
                "</td>" +
                "</td>" +
                "<td>" +
                "<fieldset>" +
                "<legend>Contact Information</legend>" +
                "<table>" +
                "<tr>" +
                "<td>" +
                "<label for=\"email\"><b>Email :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"email\" type=\"text\"><br><br>" +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"phone\"><b>Phone/Mobile :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"phone\" type=\"text\">" +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"website\"><b>Website :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"website\" type=\"text\"><br><br>" +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"address\"><b>Address :</b></label>" +
                "</td>" +
                "<td>" +
                "<fieldset>" +
                "<legend>Present Address</legend>" +
                "<select name=\"country\" id=\"country\">" +
                "<option selected value=\"Bangladesh\">Bangladesh</option>" +
                "<option value=\"India\">India</option>" +
                "<option value=\"USA\">USA</option>" +
                "<option value=\"England\">England</option>" +
                "</select>" +
                "<select name=\"district\" id=\"district\">" +
                "<option selected value=\"Dhaka\">Dhaka</option>" +
                "<option value=\"Rajshahi\">Rajshahi</option>" +
                "<option value=\"Barisal\">Barisal</option>" +
                "<option value=\"Khulna\">Khulna</option>" +
                "</select><br><br>" +
                "<textarea name=\"Current Address\" id=\"address\" cols=\"30\" rows=\"5\" placeholder=\"Road/Street/City\"></textarea><br><br>"
                +
                "<input id=\"postcode\" name=\"postcode\" type=\"text\" placeholder=\"Post Code\"><br>" +
                "</fieldset>" +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</fieldset>");
        out.println("</td>" +
                "<td>" +
                "<fieldset>" +
                "<legend>Account Information</legend>" +
                "<table>" +
                "<tr>" +
                "<td>" +
                "<label for=\"username\"><b>Username :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"username\" name=\"username\" type=\"text\">" +
                "</td>" +
                "</tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"password\"><b>Password :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"password\" name=\"password\" type=\"password\">" +
                "</td>" +
                "</tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr>" +
                "<td>" +
                "<label for=\"cpassword\"><b>Confirm Password :</b></label>" +
                "</td>" +
                "<td>" +
                "<input id=\"cpassword\" name=\"cpassword\" type=\"password\">" +
                "</td>" +
                "</tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "<tr><td></td><td></td></tr>" +
                "</table>" +
                "</fieldset>" +
                "</td>" +
                "</tr>" +
                "</table><br>" +
                "<button type=\"submit\">Register</button>" +
                "</form>" +
                "</body>" +
                "</html>");
    }
}