package bureau.web;

import bureau.repository.ConnectionPool;
import bureau.repository.ConnectionPoolException;
import bureau.repository.DatabaseConnector;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationLifecycleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            ServletContext context = event.getServletContext();
            String jdbcDriver   = context.getInitParameter("jdbc-driver");
            String jdbcUrl      = context.getInitParameter("jdbc-url");
            String jdbcUser     = context.getInitParameter("jdbc-user");
            String jdbcPassword = context.getInitParameter("jdbc-password");
            int poolSize = 10;
            DatabaseConnector.init(jdbcDriver, jdbcUrl, jdbcUser, jdbcPassword);
            ConnectionPool.getInstance().init(poolSize);
        } catch(ClassNotFoundException | ConnectionPoolException e) {
            throw new RuntimeException(e);
        }
    }
}