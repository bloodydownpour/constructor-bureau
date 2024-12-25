package bureau.services;

import bureau.domain.Project;
import bureau.repository.ProjectRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProjectService extends BaseService {
    private ProjectRepository projectRepository;


    public void setProjectRepository(ProjectRepository repos) {
        this.projectRepository = repos;
    }


    public List<Project> getAllProjects() throws SQLException {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) throws SQLException {
        return projectRepository.findById(id);
    }

    public void createProject(Project project) throws SQLException {
        projectRepository.save(project);
    }

    public void deleteProject(Long id) throws SQLException {
        projectRepository.deleteById(id);
    }

    public List<Project> getProjectsByRequestId(Long requestId) throws SQLException {
        return projectRepository.findByRequestId(requestId);
    }

    public void updateProjectStatus(Long id, String status) throws SQLException {
        projectRepository.updateProjectStatus(id, status);
    }
}
