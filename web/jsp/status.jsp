<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ievhenbondarew
  Date: 07.08.2021
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
</head>
<body>
<a href="/app">Main page</a> <br>

<c:forEach items="${statuses}" var="item">
    ${item.id}, ${item.alias}, ${item.description} <br>
</c:forEach>
<a href="/app/accounts">Accounts</a> <br>
</body>
</html>
