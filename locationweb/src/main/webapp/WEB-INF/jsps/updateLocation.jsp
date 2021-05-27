<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 18/02/2021
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Create Location</title>
</head>
<body>
<form action="updateLoc" method="post">
    <pre>
        Id: <input type="text" name="id" value="${location.id}" readonly="true"/>
        Code: <input type="text" name="code" value="${location.code}"/>
        Name: <input type="text" name="name" value="${location.name}"/>
        Type: Urban <input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''} />
            Rural <input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':''}/>
        <input type="submit" value="save"/>
        </pre>
</form>

</body>
</html>
