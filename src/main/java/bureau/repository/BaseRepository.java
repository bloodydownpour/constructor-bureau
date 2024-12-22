package bureau.repository;

import java.sql.Connection;

public abstract class BaseRepository {

    private Connection connection;
    public void setConnection(Connection connection) {
            this.connection = connection;
        }
    protected Connection getConnection() {
            return connection;
        }
}
