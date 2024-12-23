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
        String query = "INSERT INTO request (status, description) VALUES (?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, request.getStatus());
            statement.setString(2, request.getDescription());
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

    private Request mapRowToRequest(ResultSet resultSet) throws SQLException {
        Request request = new Request();
        request.setId(resultSet.getInt("id"));
        request.setTitle(resultSet.getString("title"));
        request.setDescription(resultSet.getString("description"));
        request.setCreationDate(resultSet.getDate("creationdate"));
        request.setDeadline(resultSet.getDate("deadline"));
        request.setStatus(resultSet.getString("status"));
        return request;
    }
}
