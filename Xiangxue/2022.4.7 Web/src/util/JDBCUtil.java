package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass = null;
    static String url = null;
    static String userName = null;
    static String password = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                connection = null;
            }
        }
    }

    private static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement = null;
            }
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                resultSet = null;
            }
        }
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }

    public static void release(Connection connection, Statement statement) {
        closeStatement(statement);
        closeConnection(connection);
    }
}
