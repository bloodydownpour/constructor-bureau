package bureau.controller.client;

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

@WebServlet("/client/requests.html")
public class ClientRequestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceContainer container = new ServiceContainer()) {
            RequestService requestService = container.getRequestServiceInstance();

            List<Request> requests = requestService.getAllRequests();
            for (Request request : requests) {
                System.out.println("Title: " + request.getTitle());
                System.out.println("Creation Date: " + request.getCreationDate());
                System.out.println("Deadline: " + request.getDeadline());
            }
            req.setAttribute("requests", requests);
            req.getRequestDispatcher("/WEB-INF/jsp/client/client-requests.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private int getClientIdFromSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer clientId = (Integer) req.getSession().getAttribute("clientId");
        if (clientId == null) {
            resp.sendRedirect("/login.html"); // Перенаправление на логин
            return -1;
        }
        return clientId;
    }
}