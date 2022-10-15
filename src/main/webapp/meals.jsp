<%--
  Created by IntelliJ IDEA.
  User: eugene
  Date: 12.10.2022
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://localhost:8080/topjava/meals" prefix="f" %>
<html lang="ru">
<head>
    <title>Meals list</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<style>
    .normal {
        color: green;
    }
    .excess {
        color: red;
    }
</style>

<p><a href="http://localhost:8080/topjava/meals?action=insert">Add Meal</a></p>
<table cellspacing="0" cellpadding="7" border="1" cols=4>
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>

    <jsp:useBean id="mealToList" scope="request" type="java.util.List"/>
    <c:forEach items="${mealToList}" var="meal">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr class="${meal.excess ? 'excess' : 'normal'}">
            <td><c:out value="${f:formatLocalDateTime(meal.dateTime, 'dd.MM.yyyy HH.ss')}"/></td>
            <td><c:out value="${meal.description}"/></td>
            <td><c:out value="${meal.calories}"/></td>
            <td><a href="mealDOP.jsp?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
            <td><a href="mealDOP.jsp?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </thead>
</table>


</body>

</html>
