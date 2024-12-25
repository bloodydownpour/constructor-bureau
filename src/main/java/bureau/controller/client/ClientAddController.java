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
import java.rmi.ServerError;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
@WebServlet("/client/request/new.html")

public class ClientAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/jsp/client/client-add-new.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (ServiceContainer container = new ServiceContainer()) {
            RequestService requestService = container.getRequestServiceInstance();

            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String deadlineStr = req.getParameter("deadline");

            Date deadline = null;
            if (deadlineStr != null && !deadlineStr.isEmpty()) {
                deadline = Date.valueOf(deadlineStr);
            } else deadline = new Date(System.currentTimeMillis());

            Request request = new Request(
                    title,
                    description,
                    new Date(System.currentTimeMillis()),
                    deadline,
                    "Pending",
                    1
            );

            requestService.createRequest(request);

            resp.sendRedirect(req.getContextPath() + "/client/requests.html");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
