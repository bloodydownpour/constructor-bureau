package bureau.repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bureau.domain.*;
public class ProjectRepository extends BaseRepository {

    public Optional<Project> findById(Long id) throws SQLException {
        String query = "SELECT * FROM project WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Project project = mapRowToProject(resultSet);
                return Optional.of(project);
            }
            return Optional.empty();
        }
    }
     public List<Project> findAll() throws SQLException {
         String query = "SELECT * FROM project";
         try (PreparedStatement statement = getConnection().prepareStatement(query)) {
             ResultSet resultSet = statement.executeQuery();
             List<Project> projects = new ArrayList<>();
             while (resultSet.next()) {
                 projects.add(mapRowToProject(resultSet));
             }
             return projects;
         }
     }
     public void save(Project project) throws SQLException {
        String query = "INSERT INTO project (name, request_id) VALUES (?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, project.getName());
            statement.setLong(2, project.getRequestID());
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    project.setId(generatedKeys.getInt(1));
                }
            }
        }

        public void deleteById(Long id) throws SQLException {
            String query = "DELETE FROM project WHERE id = ?";
            try (PreparedStatement statement = getConnection().prepareStatement(query)) {
                statement.setLong(1, id);
                statement.executeUpdate();
            }
        }

        private Project mapRowToProject(ResultSet resultSet) throws SQLException {
            Project project = new Project();
            project.setId(resultSet.getInt("id"));
            project.setName(resultSet.getString("name"));
            project.setRequestID(resultSet.getInt("request_id"));
            return project;
        }

    public List<Project> findByRequestId(Long requestId) throws SQLException {
        String query = "SELECT * FROM project WHERE request_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, requestId);
            ResultSet resultSet = statement.executeQuery();
            List<Project> projects = new ArrayList<>();

            while (resultSet.next()) {
                projects.add(mapRowToProject(resultSet));
            }
            return projects;
        }
    }
    }
