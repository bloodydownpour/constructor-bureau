package bureau.services;

import bureau.domain.User;
import bureau.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService extends BaseService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) throws SQLException {
        return userRepository.findById(id);
    }

    public void createUser(User user) throws SQLException {
        userRepository.save(user);
    }

    public void deleteUser(Long id) throws SQLException {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByRole(String role) throws SQLException {
        return userRepository.findByRole(role);
    }
}
