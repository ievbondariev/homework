package servlets;

import services.ClientStatusService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.Logger;

public class ClientStatusServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ClientStatusServlet.class);

    private final ClientStatusService clientStatusService = new ClientStatusService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clientStatus", clientStatusService.findAllClientStatus());
        req.getRequestDispatcher("/jsp/clientStatus.jsp").forward(req, resp);

        logger.info("ClientStatusServlet is working");
    }
}
