package servlets;

import daos.AccountDAO;
import org.apache.log4j.Logger;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AccountServlet.class);

    private final AccountDAO accountDao = new AccountDAO();
    private final AccountService accountService = new AccountService(accountDao);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accounts", accountService.findAllAccounts());
        req.getRequestDispatcher("/jsp/account.jsp").forward(req, resp);

        logger.info("AccountServlet is working");
    }
}
