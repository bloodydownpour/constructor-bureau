package bureau.services;

import bureau.repository.*;



import java.sql.Connection;
import java.sql.SQLException;

public class ServiceContainer implements AutoCloseable {

    private ProjectService projectService;
    public ProjectService getProjectServiceInstance() throws SQLException {
        if (projectService == null) {
            projectService = new ProjectService();
            projectService.setTransactionManager(getTransactionManagerInstance());
            projectService.setProjectRepository(getProjectRepositoryInstance());
        }
        return projectService;
    }

    private RequestService requestService;
    public RequestService getRequestServiceInstance() throws SQLException {
        if (requestService == null) {
            requestService = new RequestService();
            requestService.setTransactionManager(getTransactionManagerInstance());
            requestService.setRequestRepository(getRequestRepositoryInstance());
        }
        return requestService;
    }

    private TeamService teamService;
    public TeamService getTeamServiceInstance() throws SQLException {
        if (teamService == null) {
            teamService = new TeamService();
            teamService.setTransactionManager(getTransactionManagerInstance());
            teamService.setTeamRepository(getTeamRepositoryInstance());
        }
        return teamService;
    }

    private UserService userService;
    public UserService getUserServiceInstance() throws SQLException {
        if (userService == null) {
            userService = new UserService();
            userService.setTransactionManager(getTransactionManagerInstance());
            userService.setUserRepository(getUserRepositoryInstance());
        }
        return userService;
    }

    private TransactionManager transactionManager;
    private TransactionManager getTransactionManagerInstance() throws SQLException {
        if (transactionManager == null) {
            transactionManager = new TransactionManager();
            transactionManager.setConnection(getConnectionInstance());
        }
        return transactionManager;
    }

    private ProjectRepository projectRepository;
    private ProjectRepository getProjectRepositoryInstance() throws SQLException {
        if (projectRepository == null) {
            projectRepository = new ProjectRepository();
            projectRepository.setConnection(getConnectionInstance());
        }
        return projectRepository;
    }

    private RequestRepository requestRepository;
    private RequestRepository getRequestRepositoryInstance() throws SQLException {
        if (requestRepository == null) {
            requestRepository = new RequestRepository();
            requestRepository.setConnection(getConnectionInstance());
        }
        return requestRepository;
    }

    private TeamRepository teamRepository;
    private TeamRepository getTeamRepositoryInstance() throws SQLException {
        if (teamRepository == null) {
            teamRepository = new TeamRepository();
            teamRepository.setConnection(getConnectionInstance());
        }
        return teamRepository;
    }

    private UserRepository userRepository;
    private UserRepository getUserRepositoryInstance() throws SQLException {
        if (userRepository == null) {
            userRepository = new UserRepository();
            userRepository.setConnection(getConnectionInstance());
        }
        return userRepository;
    }

    private Connection connection;
    private Connection getConnectionInstance() {
        if (connection == null) {
            try {
                connection = ConnectionPool.getInstance().getConnection(); // Используйте ваш класс для подключения к БД
            } catch (ConnectionPoolException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {}
        }
    }
}
