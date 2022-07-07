package JDBC01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainTest {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    //  增
    @Test
    public void insert() {
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "insert into t_stu(id, uname, pwd) VALUE(4,'赵六','123')";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("新增成功");
            } else {
                System.out.println("新增失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement);
        }
    }

    //  删
    @Test
    public void delete() {
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "delete from t_stu where id=4";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement);
        }
    }

    //  改
    @Test
    public void update() {
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "update t_stu set uname='六' where uname='赵六'";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement);
        }
    }

    //  查
    @Test
    public void selectAll() {
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "select * from t_stu";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uname = resultSet.getString("uname");
                String pwd = resultSet.getString("pwd");
                System.out.println("id=" + id + "\tuserName=" + uname + "\tpassword=" + pwd);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
    }

    //  登录
    public static void login(String userName, String password) {
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "select * from t_stu";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String uname = resultSet.getString("uname");
                String pwd = resultSet.getString("pwd");
                if (uname.equals(userName) && pwd.equals(password)) {
                    System.out.println("登录成功");
                    return;
                }
            }
            System.out.println("登陆失败");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入用户名和密码：");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        String password = scanner.next();
        login(userName, password);
    }

}
