<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Officer</title>
</head>
<body>

<form action="Dashboard" method="POST">

    <input type="hidden" name="page" value="login" />

    <table>
        <tbody>
        <tr>
            <td><label>Email:</label></td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td><label>Password:</label></td>
            <td><input type="Password" name="password" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="submit" /></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>

