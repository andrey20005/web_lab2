<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 16.11.2025
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<svg width="300" height="300" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 500 500">
    <rect fill="#ffffff"
          width="600"
          height="600"></rect>
    <rect fill="#6399f7"
          width="120" height="60"
          x="130" y="190"></rect>
    <path d="M 250 130 A 120 120 0 0 1 370 250 L 250 250 Z" fill="#6399f7"></path>
    <polygon fill="#6399f7" points="250,250 370,250, 250,310"></polygon>
    <line stroke="black" stroke-width="3"
          x1="20" y1="250"
          x2="480" y2="250"></line>
    <line stroke="black" stroke-width="3"
          x1="250" y1="20"
          x2="250" y2="480"></line>

    <line stroke="black" stroke-width="3"
          x1="370" y1="253"
          x2="370" y2="247"></line>
    <line stroke="black" stroke-width="3"
          x1="310" y1="253"
          x2="310" y2="247"></line>
    <line stroke="black" stroke-width="3"
          x1="190" y1="253"
          x2="190" y2="247"></line>
    <line stroke="black" stroke-width="3"
          x1="130" y1="253"
          x2="130" y2="247"></line>
    <line stroke="black" stroke-width="3"
          x1="253" y1="370"
          x2="247" y2="370"></line>
    <line stroke="black" stroke-width="3"
          x1="253" y1="310"
          x2="247" y2="310"></line>
    <line stroke="black" stroke-width="3"
          x1="253" y1="190"
          x2="247" y2="190"></line>
    <line stroke="black" stroke-width="3"
          x1="253" y1="130"
          x2="247" y2="130"></line>

    <text id="mR" x="120" y="240" font-size="20" font-family="monospace">-R</text>
    <text id="mR2" x="180" y="240" font-size="20" font-family="monospace">-R/2</text>
    <text id="R2" x="300" y="240" font-size="20" font-family="monospace">R/2</text>
    <text id="R" x="360" y="240" font-size="20" font-family="monospace">R</text>
    <text id="R" x="257" y="135" font-size="20" font-family="monospace">R</text>
    <text id="R2" x="257" y="195" font-size="20" font-family="monospace">R/2</text>
    <text id="mR2" x="257" y="315" font-size="20" font-family="monospace">-R/2</text>
    <text id="mR" x="257" y="375" font-size="20" font-family="monospace">-R</text>

    <%
        if (request.getAttribute("point") != null) {
            Point point = (Point) request.getAttribute("point");
            String color;
            if (point.hit) color = "green";
            else color = "red";
    %>
    <circle
            r="6"
            cx="<%= 250 + point.x / point.r * 120%>"
            cy="<%= 250 + point.y / point.r * -120%>"
            fill="<%=color%>"
    >
    <%
        }
    %>
</svg>
