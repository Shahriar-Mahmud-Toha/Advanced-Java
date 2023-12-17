<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<h3>Registration</h3>

<form:form method="post" action="create" modelAttribute="student">

    <label>Name</label>
    <form:input type="text" path="name" id="name"/>
    <form:errors path="name"/>

    <br><br>

    <label>Email</label>
    <form:input type="text" path="email" id="email"/>
    <form:errors path="email"/>

    <br><br>

    <label>Date Of Birth</label>
    <form:input type="date" path="dateOfBirth" id="dateOfBirth"/>
    <form:errors path="dateOfBirth"/>

    <%
        String dateOfBirthValidationMsg = (String) session.getAttribute("dateOfBirthValidationMsg");
        if (dateOfBirthValidationMsg != null) {
    %>
    <span><%= dateOfBirthValidationMsg %></span>
    <%
        }
        session.removeAttribute("dateOfBirthValidationMsg");
    %>

    <br>

    <br><br>

    <label for="male">Male</label>
    <input type="radio" name="gender" id="male" value="MALE" />

    <label for="female">Female</label>
    <input type="radio" name="gender" id="female" value="FEMALE" />
    <form:errors path="gender"/>

    <br><br>

    <label for="quota">Quota</label>
    <input type="checkbox" name="quota" id="quota" value="1" />
    <form:errors path="quota"/>

    <br><br>

    <label for="country">Country</label>
    <form:select path="country" id="country">
        <form:option value="" label="---Select Country---" />
        <form:option value="Bangladesh" label="Bangladesh" />
        <form:option value="USA" label="United States" />
        <form:option value="UK" label="United Kingdom" />
    </form:select>
    <form:errors path="country"/>

    <br><br>

    <input type="submit" value="Register" />

</form:form>

</body>
</html>
