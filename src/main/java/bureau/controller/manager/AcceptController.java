package bureau.controller.manager;

import bureau.services.RequestService;
import bureau.services.ServiceContainer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/manager/request/accept.html")
public class AcceptController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (ServiceContainer container = new ServiceContainer()) {
            RequestService requestService = container.getRequestServiceInstance();
            Long requestId = Long.parseLong(req.getParameter("id"));
            requestService.acceptRequest(requestId);

            resp.sendRedirect(req.getContextPath() + "/manager/requests.html");
        } catch (SQLException e) {
            throw new ServletException();
        }
    }

}
