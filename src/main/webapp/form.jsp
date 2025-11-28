<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.andrey.web2.Point" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.andrey.web2.Points" %>
<%@ page import="com.andrey.web2.Area.Circle" %>
<%@ page import="jakarta.enterprise.inject.spi.CDI" %>
<%@ page import="java.util.Comparator" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 16.11.2025
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="pointsBean" class="com.andrey.web2.Points" scope="session"/>--%>
<html>
<head>
    <title>form</title>
    <link rel="stylesheet" href="styles/main.css">
    <script defer src="scripts/form.js"></script>
</head>
<body>
<%@include file="templates/header.jsp"%>
<table id="main_table" class="layout-table">
    <tr>
        <td>
            <%@include file="templates/mysvg.jsp"%>
        <td>
            <form id="calculate_form">
                <!-- Группа для координаты X -->
                <fieldset>
                    <legend>X:</legend>
                    <div class="radio-group">
                        <label><input type="radio" name="x" value="-4"> -4</label>
                        <label><input type="radio" name="x" value="-3"> -3</label>
                        <label><input type="radio" name="x" value="-2"> -2</label>
                        <label><input type="radio" name="x" value="-1"> -1</label>
                        <label><input type="radio" name="x" value="0" checked> 0</label>
                        <label><input type="radio" name="x" value="1"> 1</label>
                        <label><input type="radio" name="x" value="2"> 2</label>
                        <label><input type="radio" name="x" value="3"> 3</label>
                        <label><input type="radio" name="x" value="4"> 4</label>
                    </div>
                </fieldset>

                <!-- Поле для координаты Y -->
                <fieldset>
                    <legend>Y:</legend>
                    <input type="text" id="y_input" name="y" required
                           pattern="(:?-?|\+?)0*(?:[012](?:[\.,][0-9]*)?|3(?:\.0*)?)"
                           title="Число от -3 до 3">
                </fieldset>

                <!-- Группа для параметра R -->
                <fieldset>
                    <legend>R:</legend>
                    <div class="radio-group">
                        <label><input type="checkbox" name="r" value="1"> 1</label>
                        <label><input type="checkbox" name="r" value="1.5"> 1.5</label>
                        <label><input type="checkbox" name="r" value="2" checked> 2</label>
                        <label><input type="checkbox" name="r" value="2.5"> 2.5</label>
                        <label><input type="checkbox" name="r" value="3"> 3</label>
                    </div>
                </fieldset>
                <button type="submit" title="sfdwddw fwsd w">Получить результат</button>
            </form>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <table id="res_table">
                <tr class="table-header">
                    <th>time</th>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Res/err</th>
                </tr>
                <%
                    Points pointsBean = CDI.current().select(Points.class).get();
                    Map<LocalDateTime, Point> points = pointsBean.getPoints();
                    for (LocalDateTime time : points.keySet().stream().sorted(Comparator.reverseOrder()).toList()) {
                        Point point = points.get(time);
                %>
                <tr>
                    <td><%=time%></td>
                    <td><%=point.x%></td>
                    <td><%=point.y%></td>
                    <td><%=point.r%></td>
                    <td><%=point.hit%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
