package bureau.controller.constructor;

import bureau.domain.Project;
import bureau.domain.Request;
import bureau.services.ProjectService;
import bureau.services.RequestService;
import bureau.services.ServiceContainer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/constructor/details.html")
public class ConstructorViewProjectDetailsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceContainer container = new ServiceContainer()) {
           ProjectService projectService = container.getProjectServiceInstance();
            int projectId = Integer.parseInt(req.getParameter("id"));
            Project project = projectService.getProjectById(Long.valueOf(projectId)).get();

            if (project == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Project not found");
                return;
            }

            req.setAttribute("project", project);
            System.out.println(req.getContextPath());
            req.getRequestDispatcher("/WEB-INF/jsp/constructor/constructor-project-details.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
