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
<a href="/app"><font size="5" color="red">Main page</font></a> <br>
<style>
    body {
        /*background-image: url(https://oir.mobi/uploads/posts/2021-03/1616996910_11-p-fon-priroda-razmitii-11.jpg);*/
        background-color: #c7b39b;
    }
</style>
<%--<c:forEach items="${accounts}" var="item">--%>
<%--    ${item.id}, ${item.clientId}, ${item.number}, ${item.value} <br>--%>
<%--</c:forEach>--%>
<font size="3" color="#8a2be2" face="Times New Roman"></font>
<div align="left">
    <h3>ACCOUNTS</h3>
    </form>
    <table  cellpadding="5" bgcolor="#b0c4de">
        <tr>
            <th>ID</th>
            <th>Client Id</th>
            <th>Number</th>
            <th>Value</th>
        </tr>
        <c:forEach items="${accounts}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.clientId}</td>
                <td>${item.number}</td>
                <td>${item.value}</td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="/app/statuses"><font size="5" color="#8a2be2">Statuses</font></a> <br>
<a href="https://lms.ithillel.ua"><font size="4" color="navy">Hillel LMS</font></a> <br>
</body>
</html>
