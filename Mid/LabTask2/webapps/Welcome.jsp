<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--<%--%>
<%--    if(request.getSession().getAttribute("loginStatus")== null || !(boolean)(request.getSession().getAttribute("loginStatus"))){--%>
<%--        response.sendRedirect("Dashboard");--%>
<%--    }--%>
<%--%>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>
    Welcome, ${user.fullName}
</h1>

</body>
</html>