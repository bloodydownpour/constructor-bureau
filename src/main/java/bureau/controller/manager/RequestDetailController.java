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

@WebServlet("/manager/details.html")
public class RequestDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceContainer container = new ServiceContainer()) {
            int requestId = Integer.parseInt(req.getParameter("id"));
            RequestService requestService = container.getRequestServiceInstance();
            Request request = requestService.getRequestById((long) requestId).get();
            System.out.println(request);
            req.setAttribute("request", request);

            req.getRequestDispatcher("/WEB-INF/jsp/manager/manager-request-details.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Ошибка при загрузке заявок", e);
        }
    }
}
