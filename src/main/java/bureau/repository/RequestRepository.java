package bureau.repository;

import bureau.domain.Request;
import org.eclipse.tags.shaded.org.apache.regexp.RE;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class RequestRepository extends BaseRepository {
    public Optional<Request> findById(Long id) throws SQLException {
        String query = "SELECT * FROM request WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Request request = mapRowToRequest(resultSet);
                return Optional.of(request);
            }
            return Optional.empty();
        }
    }

    public List<Request> findByClientId(Long id) throws SQLException {
        String query = "SELECT * FROM request WHERE clientid = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            List<Request> requests = new ArrayList<>();

            while (set.next()) {
                requests.add(mapRowToRequest(set));
            }
            return requests;
        }
    }

    public List<Request> findAll() throws SQLException {
        String query = "SELECT * FROM request";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<Request> requests = new ArrayList<>();

            while (resultSet.next()) {
                requests.add(mapRowToRequest(resultSet));
            }
            return requests;
        }
    }

    public void save(Request request) throws SQLException {
        String query = "INSERT INTO request " +
                "(title, description, creationdate, deadline, status, clientid, managerid, leadid, projectteamid) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, request.getTitle());
            statement.setString(2, request.getDescription());
            statement.setDate(3, request.getCreationDate());
            statement.setDate(4, request.getDeadline());
            statement.setString(5, request.getStatus());
            statement.setInt(6, request.getClientID());
            statement.setInt(7, request.getManagerID());
            statement.setInt(8, request.getLeadID());
            statement.setInt(9, request.getProjectTeamID());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                request.setId(generatedKeys.getInt(1));
            }
        }
    }

    public void deleteById(Long id) throws SQLException {
        String query = "DELETE FROM request WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    public void acceptRequest(Long id) throws SQLException {
        String query = "UPDATE request SET status = \'In Progress\' WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
    public List<Request> getPendingRequests() throws SQLException {
        String query = "SELECT * FROM request WHERE status = \'Pending\'";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<Request> requests = new ArrayList<>();

            while (resultSet.next()) {
                requests.add(mapRowToRequest(resultSet));
            }
            return requests;
        }
    }

    private Request mapRowToRequest(ResultSet resultSet) throws SQLException {
        Request request = new Request();
        request.setId(resultSet.getInt("id"));
        request.setTitle(resultSet.getString("title"));
        request.setDescription(resultSet.getString("description"));
        request.setCreationDate(resultSet.getDate("creationdate"));
        request.setDeadline(resultSet.getDate("deadline"));
        request.setStatus(resultSet.getString("status"));
        request.setClientID(resultSet.getInt("clientid"));
        request.setManagerID(resultSet.getInt("managerid"));
        request.setLeadID(resultSet.getInt("leadid"));
        request.setProjectTeamID(resultSet.getInt("projectteamid"));
        return request;
    }


}
