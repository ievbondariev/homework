package com.hillel.servlets;

import com.hillel.daos.ClientDAO;
import com.hillel.dto.ClientDto;
import org.apache.log4j.Logger;
import com.hillel.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {

//    private static final Logger logger = Logger.getLogger(ClientServlet.class);

    private final ClientDAO clientDao = new ClientDAO();
    private final ClientService clientService = new ClientService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients", clientService.findAllClients());
        req.getRequestDispatcher("jsp/client.jsp").forward(req, resp);

//        logger.info("ClientServlet is working");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientDto clientDto = new ClientDto();
        clientDto.setName(req.getParameter("name"));
        clientDto.setEmail(req.getParameter("email"));
        clientDto.setPhone(Long.parseLong(req.getParameter("phone")));
        clientDto.setAge(Integer.parseInt(req.getParameter("age")));
        clientService.save(clientDto);
        req.setAttribute("clients", clientService.findAllClients());
        req.getRequestDispatcher("jsp/client.jsp").forward(req, resp);
    }
}
