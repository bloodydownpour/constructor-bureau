package bureau.controller;
import bureau.domain.User;
import bureau.services.ServiceContainer;
import bureau.services.ServiceException;
import bureau.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/login/perform.html")
public class LoginPerformController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null && !login.isBlank() && !password.isBlank()) {
            try (ServiceContainer container = new ServiceContainer()) {
                UserService userService = container.getUserServiceInstance();
                Optional<User> user = userService.findByLoginAndPassword(login, password);
                if (user.isPresent()) {
                    HttpSession session = req.getSession();
                    session.setAttribute("session_user", user.get());
                    resp.sendRedirect(req.getContextPath());
                } else {
                    resp.sendRedirect(req.getContextPath() + "/login/form.html");
                }
            } catch (ServiceException | SQLException e) {
                throw new ServletException(e);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login/form.html");
        }
    }

}
