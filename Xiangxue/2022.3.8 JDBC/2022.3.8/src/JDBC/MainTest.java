package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        connection = JDBCUtil.getConnection();
        statement = connection.createStatement();
        final String sql = "select * from t_stu";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String uname = resultSet.getString("uname");
            String pwd = resultSet.getString("pwd");
            System.out.println("id="+id+"\tuserName="+uname+"\tpassword="+pwd);
        }
    }
}
