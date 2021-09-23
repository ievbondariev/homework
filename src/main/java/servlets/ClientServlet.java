package servlets;

import daos.ClientDAO;
import org.apache.log4j.Logger;
import services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ClientServlet.class);

    private  final ClientDAO clientDao = new ClientDAO();
    private final ClientService clientService = new ClientService(clientDao);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients", clientService.findAllClients());
        req.getRequestDispatcher("/jsp/client.jsp").forward(req, resp);

        logger.info("ClientServlet is working");
    }
}
