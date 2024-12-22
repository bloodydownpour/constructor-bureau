package bureau.repository;

import bureau.domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository {
    public Optional<User> findById(Long id) throws SQLException {
        String query = "SELECT * FROM _user WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = mapRowToUser(resultSet);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public List<User> findAll() throws SQLException {
        String query = "SELECT * FROM _user";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(mapRowToUser(resultSet));
            }
            return users;
        }
    }

    public List<User> findByRole(String role) throws SQLException {
        String query = "SELECT * FROM users WHERE role = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, role);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                users.add(mapRowToUser(resultSet));
            }
            return users;
        }
    }

    public void save(User user) throws SQLException {
        String query = "INSERT INTO users (name, email, role) VALUES (?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getRole());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        }
    }

    public void deleteById(Long id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    private User mapRowToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(resultSet.getString("role"));
        return user;
    }
}
