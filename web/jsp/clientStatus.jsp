<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ievhenbondarew
  Date: 07.08.2021
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ClientStatus</title>
</head>
<body>
<a href="/app"><font size="5" color="red">Main page</font></a> <br>

<c:forEach items="${clientStatus}" var="item">
    ${item.clientId}, ${item.statusId} <br>
</c:forEach>

<a href="/app/clients">Clients</a> <br>
</body>
</html>
