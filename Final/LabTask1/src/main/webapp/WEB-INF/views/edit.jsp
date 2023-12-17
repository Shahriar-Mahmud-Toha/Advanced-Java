<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h3>Edit Student</h3>

<%--@elvariable id="student" type="dev.domain.Student"--%>
<form:form action="${pageContext.request.contextPath}/update" method="post" modelAttribute="student">

    <form:input type="hidden" path="id" />

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
    <br><br>

    <label>Gender</label>
    <input type="radio" name="gender" value="MALE" ${student.gender == 'MALE' ? 'checked' : ''}/> Male
    <input type="radio" name="gender" value="FEMALE" ${student.gender == 'FEMALE' ? 'checked' : ''}/> Female
    <form:errors path="gender"/>

    <br><br>

    <label>Quota</label>
    <input type="checkbox" name="quota" id="quota" ${student.quota == '1' ? 'checked' : ''} value="1" />
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

    <input type="submit" value="Update" />
</form:form>
</body>
</html>
