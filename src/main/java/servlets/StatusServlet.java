package servlets;

import services.StatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/statuses")
public class StatusServlet extends HttpServlet {
    private final StatusService statusService = new StatusService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("statuses", statusService.findAllStatuses());
        req.getRequestDispatcher("/jsp/status.jsp").forward(req, resp);
    }
}

