package servlets;

import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountServlet extends HttpServlet {
    private final AccountService accountService = new AccountService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accounts", accountService.findAllAccounts());
        req.getRequestDispatcher("/jsp/account.jsp").forward(req, resp);
    }
}
