<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Staff Update</title>
</head>
<body>

<form action="Dashboard" method="POST">

    <input type="hidden" name="update" value="staff-data" />

    <table>
        <tbody>
        <tr>
            <td><label>Id:</label></td>
            <td><input type="text" name="id" value="${staff.id}" /></td>
        </tr>

        <tr>
            <td><label>Name:</label></td>
            <td><input type="text" name="name" value="${staff.name}"/></td>
        </tr>

        <tr>
            <td><label>Date of Birth:</label></td>
            <td><input type="date" name="date_of_birth" value="${staff.date_of_birth}"/></td>
        </tr>

        <tr>
            <td><label>Email:</label></td>
            <td><input type="text" name="email" value="${staff.email}" /></td>
        </tr>

        <tr>
            <td><label>Joining Date:</label></td>
            <td><input type="date" name="joining_date" value="${staff.joining_date}"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="submit" /></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>