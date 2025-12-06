package com.andrey.web2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (checkArgumentExists(req)) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/check_area");
                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("form.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("400: " + e.getMessage());
        }
    }

    private static boolean checkArgumentExists(HttpServletRequest req) throws NumberFormatException {
        if (req.getParameter("x") != null &&
            req.getParameter("y") != null &&
            req.getParameter("r") != null) {
            double x = Double.parseDouble(req.getParameter("x"));
            if (x < -4 || 4 < x) throw new NumberFormatException("x out of range [-4, 4]");
            req.setAttribute("x", x);
            double y = Double.parseDouble(req.getParameter("y"));
            if (y < -5 || 3 < y) throw new NumberFormatException("y out of range [-3, 3]");
            req.setAttribute("y", y);
            double r = Double.parseDouble(req.getParameter("r"));
            if (r < 1 || 3 < r) throw new NumberFormatException("r out of range [1, 3]");
            req.setAttribute("r", r);
            return true;
        }
        return false;
    }
}
