<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person List</title>
</head>
<body>
<table border="2px">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Gender</th>
    <th>Date of Birth</th>
    </thead>
<c:forEach items="${persons}" var="person">
<%--    ${person.id} - ${person.name} - ${person.gender} - ${person.dateOfBirth}--%>
<%--    <hr>--%>
    <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
        <td>${person.gender}</td>
        <td>${person.dateOfBirth}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>