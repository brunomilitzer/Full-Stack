<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 19/02/2021
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Locations</title>
</head>
<body>
<h2>Locations:</h2>
<table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>type</th>
    </tr>
    <c:forEach items="${locations}" var="location">
        <tr>
            <td>${location.id}</td>
            <td>${location.code}</td>
            <td>${location.name}</td>
            <td>${location.type}</td>
            <td><a href="showUpdate?id=${location.id}">edit</a></td>
            <td><a href="deleteLocation?id=${location.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="showCreate">Add Location</a>
</body>
</html>
