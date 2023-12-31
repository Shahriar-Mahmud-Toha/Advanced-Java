<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Cost Form</title>
</head>
<body>
<h3>Enter Cost Information</h3>

<%--@elvariable id="cost" type="dev.domain.Cost"--%>
<form:form method="post" action="tax/calculate" modelAttribute="cost">

    <label>Gender</label>
    <form:select path="gender">
        <form:option value="" label="---Select Gender---" />
        <form:option value="male" label="Male" />
        <form:option value="female" label="Female" />
    </form:select>
    <form:errors path="gender"/>

    <br><br>

    <label>House Rent</label>
    <form:input type="number" path="houseRent" id="houseRent" />
    <form:errors path="houseRent"/>

    <br><br>

    <label>Transportation</label>
    <form:input type="number" path="transportation" id="transportation" />
    <form:errors path="transportation"/>

    <br><br>

    <label>Medical Cost</label>
    <form:input type="number" path="medicalCost" id="medicalCost" />
    <form:errors path="medicalCost"/>

    <br><br>

    <label>Average Income</label>
    <form:input type="number" path="savings" id="savings" />
    <form:errors path="savings"/>

    <br><br>

    <label>Educational Cost</label>
    <form:input type="number" path="educationalCost" id="educationalCost" />
    <form:errors path="educationalCost"/>

    <br><br>

    <label>Food Cost</label>
    <form:input type="number" path="foodCost" id="foodCost" />
    <form:errors path="foodCost"/>

    <br><br>

    <label>Grocery Cost</label>
    <form:input type="number" path="groceryCost" id="groceryCost" />
    <form:errors path="groceryCost"/>

    <br><br>

    <label>Shopping Cost</label>
    <form:input type="number" path="shoppingCost" id="shoppingCost" />
    <form:errors path="shoppingCost"/>

    <br><br>

    <label>Telecom Cost</label>
    <form:input type="number" path="telecomCost" id="telecomCost" />
    <form:errors path="telecomCost"/>

    <br><br>

    <label>Subscription Cost</label>
    <form:input type="number" path="subscriptionCost" id="subscriptionCost" />
    <form:errors path="subscriptionCost"/>

    <br><br>

    <label>Other Cost</label>
    <form:input type="number" path="otherCost" id="otherCost" />
    <form:errors path="otherCost"/>

    <br><br>

    <input type="submit" value="Submit" />

</form:form>

</body>
</html>
