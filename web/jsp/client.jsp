<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ievhenbondarew
  Date: 07.08.2021
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<a href="/app">Main page</a> <br>

<c:forEach items="${clients}" var="item">
    ${item.id}, ${item.name}, ${item.email}, ${item.phone}, ${item.about}, ${item.age} <br>
</c:forEach>
<a href="/app/clientStatus">ClientStatus</a> <br>
</body>
</html>
