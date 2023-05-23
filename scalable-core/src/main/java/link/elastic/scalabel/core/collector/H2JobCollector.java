package link.elastic.scalabel.core.collector;

import java.sql.*;
import java.util.UUID;

import static java.sql.DriverManager.getConnection;

public class H2JobCollector extends AbstractJobCollector {
    private static final String JDBC_URL = "jdbc:h2:~/SCALABLE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASS = "org.h2.Driver";

    private Connection conn = null;

    public H2JobCollector() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS);
        Statement stmt = null;
        try {
            conn = getConnection(JDBC_URL, USER, PASSWORD);
            stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS JOB_INFO");
            stmt.execute("CREATE TABLE JOB_INFO(id VARCHAR(36) PRIMARY KEY,name VARCHAR(100),cron VARCHAR(100),jobHandler VARCHAR(100))");
        } finally {
            if (null != null) {
                stmt.close();
            }
        }

    }

    public void collect() throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO JOB_INFO VALUES('" + UUID.randomUUID() + "','test','* * * * * ?','link.elastic.scalabel.core.handler.NoOpJobHandler')");

        } finally {
            stmt.close();
        }
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
