package Test;

import java.sql.*;

public class MainTest {
    public static void main(String[] args) {
        /*JDBC*/
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            /*注册驱动 com.mysql.jdbc.Driver*/
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            /*建立连接  connection*/
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8", "root", "030212");
            /*和数据库打交道   statement*/
            statement = connection.createStatement();
            /*执行查询*/
            final String sql = "select * from t_stu";
            // executeUpdate()增删改   executeQuery()查
            resultSet = statement.executeQuery(sql);    //  返回结果集   一整块数据
            /*拿出一条数据*/
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uname = resultSet.getString("uname");
                String pwd = resultSet.getString("pwd");
                System.out.println("id=" + id + "\tuserName=" + uname + "\tpassword=" + pwd);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } /*finally {
            resultSet.close();
            statement.close();
            connection.close();
        }*/

    }
}
