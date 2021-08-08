<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ievhenbondarew
  Date: 07.08.2021
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
<a href="/app">Main page</a> <br>

<c:forEach items="${accounts}" var="item">
    ${item.id}, ${item.clientId}, ${item.number}, ${item.value} <br>
</c:forEach>
<a href="/app/statuses">Statuses</a> <br>
</body>
</html>
