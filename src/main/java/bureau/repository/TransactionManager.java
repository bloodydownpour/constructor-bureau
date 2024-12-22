package bureau.repository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;

public class TransactionManager {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void start() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        try {
            connection.commit();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch(SQLException e) {
                connection = null;
            }
        }
    }

    public void rollback() throws SQLException {
        try {
            connection.rollback();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch(SQLException e) {
                connection = null;
            }
        }
    }
}
