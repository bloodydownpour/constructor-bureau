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
import java.util.List;

@WebServlet("/constructor/projects.html")
public class CostructorViewProjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceContainer container = new ServiceContainer()) {
            ProjectService projectService = container.getProjectServiceInstance();

            List<Project> projects = projectService.getAllProjects();
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("/WEB-INF/jsp/constructor/constructor-projects.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}


