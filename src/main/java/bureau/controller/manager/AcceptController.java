package bureau.controller.manager;

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
@WebServlet("/manager/request/accept.html")
public class AcceptController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (ServiceContainer container = new ServiceContainer()) {
            RequestService requestService = container.getRequestServiceInstance();
            Long requestId = Long.parseLong(req.getParameter("id"));
            Long leadId = Long.parseLong(req.getParameter("leadid"));
            System.out.println(leadId);
            System.out.println(requestId);

            Request request = requestService.getRequestById(requestId).get();
            requestService.acceptRequest(requestId);

            Project project = new Project();
            project.setName(request.getTitle());
            project.setStatus("In progress");
            project.setLeadID(Math.toIntExact(leadId));
            project.setRequestID(Math.toIntExact(requestId));
            project.setTeamID(1);

            ProjectService projectService = container.getProjectServiceInstance();
            projectService.createProject(project);





            resp.sendRedirect(req.getContextPath() + "/manager/requests.html");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException();
        }
    }

}
