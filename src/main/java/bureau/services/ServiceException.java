package bureau.services;

import bureau.repository.RepositoryException;

import java.sql.SQLException;

public class ServiceException extends Exception {
    public ServiceException() {
        super();
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(RepositoryException e) {
        super(e.getMessage());
    }
}
