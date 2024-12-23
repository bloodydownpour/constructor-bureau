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

@WebServlet("/client/details.html")
public class ClientRequestDetailsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceContainer container = new ServiceContainer()) {
            RequestService requestService = container.getRequestServiceInstance();
            int requestId = Integer.parseInt(req.getParameter("id"));
            Request request = requestService.getRequestById(Long.valueOf(requestId)).get();

            if (request == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Request not found");
                return;
            }

            req.setAttribute("request", request);
            System.out.println(req.getContextPath());
            req.getRequestDispatcher("/WEB-INF/jsp/client/client-request-details.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
