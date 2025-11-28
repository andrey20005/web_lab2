<%@ page import="com.andrey.web2.Point" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 16.11.2025
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Answer</title>
    <link rel="stylesheet" href="styles/main.css">
    <script defer src="scripts/answer.js"></script>
</head>
<body>
<%@include file="templates/header.jsp"%>
<table id="main_table">
    <tr>
        <td><%@include file="templates/mysvg.jsp"%></td>
        <td>
            <% Point point = (Point) request.getAttribute("point"); %>
            <p>x = <%= point.x%></p>
            <p>y = <%= point.y%></p>
            <p>r = <span id="r_ans"><%=point.r%></span></p>
            <p>hit = <%= point.hit%></p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <a href="./control">Обратно на форму</a>
        </td>
    </tr>
</table>
</body>
</html>
