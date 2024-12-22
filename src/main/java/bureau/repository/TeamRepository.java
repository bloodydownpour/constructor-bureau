package bureau.repository;

import bureau.domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

public class TeamRepository extends BaseRepository {

    public Optional<ProjectTeam> findById(Long id) throws SQLException {
        String query = "SELECT * FROM projectteam WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ProjectTeam team = mapRowToTeam(resultSet);
                return Optional.of(team);
            }
            return Optional.empty();
        }
    }

    public List<ProjectTeam> findAll() throws SQLException {
        String query = "SELECT * FROM projectteam";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<ProjectTeam> teams = new ArrayList<>();

            while (resultSet.next()) {
                teams.add(mapRowToTeam(resultSet));
            }
            return teams;
        }
    }

    public List<ProjectTeam> findByProjectId(Long projectId) throws SQLException {
        String query = "SELECT * FROM projectteam WHERE project_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            List<ProjectTeam> teams = new ArrayList<>();

            while (resultSet.next()) {
                teams.add(mapRowToTeam(resultSet));
            }
            return teams;
        }
    }

    public void save(ProjectTeam team) throws SQLException {
        String query = "INSERT INTO projectteam (project_id, name) VALUES (?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, team.getProjectID());
            statement.setString(2, team.getName());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                team.setId(generatedKeys.getInt(1));
            }
        }
    }

    public void deleteById(Long id) throws SQLException {
        String query = "DELETE FROM projectteam WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    private ProjectTeam mapRowToTeam(ResultSet resultSet) throws SQLException {
        ProjectTeam team = new ProjectTeam();
        team.setId(resultSet.getInt("id"));
        team.setProjectID(resultSet.getInt("project_id"));
        team.setName(resultSet.getString("name"));
        return team;
    }
}
