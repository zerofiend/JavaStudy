package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass = null;
    static String url = null;
    static String userName = null;
    static String password = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = null;
        inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("JDBC/jdbc.properties");
        try {
            properties.load(inputStream);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName(driverClass);
        connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
}
