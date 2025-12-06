<%@ page import="com.andrey.web2.Point" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 16.11.2025
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Points pointsBean = CDI.current().select(Points.class).get();
    Map<LocalDateTime, Point> points = pointsBean.getPoints();
%>
<html>
    <title>Answer</title>
    <link rel="stylesheet" href="styles/main.css">
    <script defer src="scripts/answer.js"></script>
</head>
<body>
<%
    request.setAttribute("point", new Point(
            Double.parseDouble(request.getParameter("x")),
            Double.parseDouble(request.getParameter("y")),
            Double.parseDouble(request.getParameter("r")),
            Boolean.parseBoolean(request.getParameter("h"))
    ));
%>
<%@include file="templates/header.jsp"%>
<table id="main_table">
    <tr>
        <td>
<%--            <jsp:include page="templates/mysvg.jsp">--%>

<%--            </jsp:include>--%>
            <%@include file="templates/mysvg.jsp"%>
        </td>
        <td>
            <% Point point = (Point) request.getAttribute("point"); %>
            <p>x = <%= request.getParameter("x")%></p>
            <p>y = <%= request.getParameter("y")%></p>
            <p>r = <span id="r_ans"><%=request.getParameter("r")%></span></p>
            <p>hit = <%= request.getParameter("h")%></p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <a id="return_a" href="./">Обратно на форму</a>
        </td>
    </tr>
</table>
</body>
</html>
