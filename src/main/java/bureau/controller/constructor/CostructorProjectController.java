package bureau.controller.constructor;
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
public class CostructorProjectController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/constructor/constructor-projects.jsp").forward(req, resp);
    }
}


