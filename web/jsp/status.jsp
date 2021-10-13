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
<a href="/app"><font size="5" color="red">com.hillel.Main page</font></a> <br>
<style>
    body {
        /*background-image: url(https://oir.mobi/uploads/posts/2021-03/1616996910_11-p-fon-priroda-razmitii-11.jpg);*/
        background-color: #c7b39b;
    }
</style>
<h3>STATUSES</h3>
<c:forEach items="${statuses}" var="item">
    ${item.id}, ${item.alias}, ${item.description} <br>
</c:forEach>
<a href="/app/clientStatus"><font size="5" color="#8a2be2">Client Statuses</font></a> <br>
</body>
</html>
