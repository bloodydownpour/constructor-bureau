package by.vsu.ist.controller.cashier;

import by.vsu.ist.domain.Account;
import by.vsu.ist.service.AccountService;
import by.vsu.ist.service.ServiceContainer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/cashier/account/view.html")
public class AccountViewController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long id = Long.parseLong(req.getParameter("id"));
			try(ServiceContainer container = new ServiceContainer()) {
				AccountService accountService = container.getAccountServiceInstance();
				Optional<Account> account = accountService.findByIdWithTransfers(id);
				if(account.isPresent()) {
					req.setAttribute("account", account.get());
					req.getRequestDispatcher("/WEB-INF/jsp/cashier/account/view.jsp").forward(req, resp);
				} else {
					throw new IllegalArgumentException();
				}
			} catch(SQLException e) {
				throw new ServletException(e);
			}
		} catch(IllegalArgumentException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
