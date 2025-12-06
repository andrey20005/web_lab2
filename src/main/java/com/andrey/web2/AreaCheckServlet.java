package com.andrey.web2;

import com.andrey.web2.Area.*;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/check_area")
public class AreaCheckServlet extends HttpServlet {

    public static Area area;
    static {
        AndArea quarterCircle = new AndArea(new ArrayList<>());
        quarterCircle.addArea(new AboveLine(0, 0, 1, 0));
        quarterCircle.addArea(new AboveLine(0, 0, 0, 1));
        quarterCircle.addArea(new Circle(1, 0, 0));
        AndArea lowerTriangle = new AndArea(new ArrayList<>());
        lowerTriangle.addArea(new AboveLine(0, 0, 1, 0));
        lowerTriangle.addArea(new AboveLine(0, 0, 0, -1));
        lowerTriangle.addArea(new AboveLine(0, -0.5, -1, 1));
        AndArea rectangle = new AndArea(new ArrayList<>());
        rectangle.addArea(new AboveLine(0, 0, -1, 0));
        rectangle.addArea(new AboveLine(0, 0, 0, -1));
        rectangle.addArea(new AboveLine(-1, -1, 1, 0));
        rectangle.addArea(new AboveLine(-1, -1, 0, 1));
        OrArea orArea = new OrArea(new ArrayList<>());
        orArea.addArea(quarterCircle);
        orArea.addArea(lowerTriangle);
        orArea.addArea(rectangle);
        area = orArea;
    }

    @Inject
    private Points points;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Point point = new Point(
                (double) req.getAttribute("x"),
                (double) req.getAttribute("y"),
                (double) req.getAttribute("r"),
                area
        );
        points.addPoint(point);
        points.getPoints().forEach((t, p) -> System.out.println(t + " " + p.x + " " + p.y + " " + p.r + " " + p.hit));
        req.setAttribute("point", point);
//        System.out.println("x=" + req.getAttribute("x") + " y=" + req.getAttribute("y") + " r=" + req.getAttribute("r"));
//        RequestDispatcher dispatcher = req.getRequestDispatcher("answer.jsp");
//        dispatcher.forward(req, resp);
        resp.sendRedirect("answer.jsp?x=" + req.getAttribute("x") + "&y=" + req.getAttribute("y") + "&r=" + req.getAttribute("r") + "&h=" + point.hit + "&s=true");
    }
}
