import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/control")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkArgumentExists(req)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/check_area");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("form.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private static boolean checkArgumentExists(HttpServletRequest req) {
        return req.getParameter("X") != null &&
                req.getParameter("Y") != null &&
                req.getParameter("R") != null;
    }
}


