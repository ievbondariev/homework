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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Clients from Postgres</title>
</head>
<body>
<a href="/app"><font size="5" color="red">Main page</font></a> <br>
<style>
    body {
        background-image: url(https://oir.mobi/uploads/posts/2021-03/1616996910_11-p-fon-priroda-razmitii-11.jpg);
        background-color: #c7b39b;
    }
</style>
<font size="3" color="#8a2be2" face="Times New Roman"></font>
<div align="left">
    <h3>CLIENTS</h3>
    </form>
    <table  cellpadding="5" bgcolor="#b0c4de">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>About</th>
            <th>Age</th>
        </tr>
        <c:forEach items="${clients}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.email}</td>
                <td>${item.phone}</td>
                <td>${item.about}</td>
                <td>${item.age}</td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<form action="clients" method="post">
<%--    ID: <input type="number" name="id"> <br>--%>
    Name: <input type="text" name="name"> <br>
    Phone: <input type="number" name="phone"> <br>
    EMail: <input type="email" name="email"> <br>
    Age: <input type="number" name="age"> <br>
    <input type="submit">
</form>

<br>
<a href="/app/accounts"><font size="5" color="#8a2be2">Accounts</font></a> <br>
</body>
</html>
