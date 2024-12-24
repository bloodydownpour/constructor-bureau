package bureau.controller.manager;

import bureau.domain.Request;
import bureau.services.RequestService;
import bureau.services.ServiceContainer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/manager/requests.html")
public class RequestListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceContainer container = new ServiceContainer()) {
            RequestService requestService = container.getRequestServiceInstance();
            List<Request> requests = requestService.getPendingRequests();
            System.out.println("Found requests: " + requests.size());
            req.setAttribute("requests", requests);

            req.getRequestDispatcher("/WEB-INF/jsp/manager/request-list.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Ошибка при загрузке заявок", e);
        }
    }
}
