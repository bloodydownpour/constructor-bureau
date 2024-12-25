package bureau.repository;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseRepository {

    private Connection connection;
    public void setConnection(Connection connection) {
            this.connection = connection;
        }
    protected Connection getConnection() {
            return connection;
    }
    protected void close() throws SQLException {
        connection.close();
        this.connection = null;
    }
}
