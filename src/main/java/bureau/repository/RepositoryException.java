package bureau.repository;

import java.sql.SQLException;

public class RepositoryException extends Exception {
    public RepositoryException() {
        super();
    }
    public RepositoryException(String message) {
        super(message);
    }
    public RepositoryException(SQLException e) {
        super(e.getMessage());
    }
}
