package bureau.controller.constructor;

import bureau.services.ProjectService;
import bureau.services.ServiceContainer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/constructor/details/update")
public class ConstructorUpdateStatusController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceContainer container = new ServiceContainer()) {
            ProjectService projectService = container.getProjectServiceInstance();
            int projectId = Integer.parseInt(req.getParameter("id"));
            String status = req.getParameter("status");
            projectService.updateProjectStatus((long) projectId, status);

            resp.sendRedirect(req.getContextPath() + "/constructor/details.html?id=" + projectId);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
