package com.dao.impl;

import com.dao.UserDao;
import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void findAll() {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from t_stu";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uname = resultSet.getString("uname");
                String pwd = resultSet.getString("pwd");
                System.out.println(id + "-----" + uname + "-----" + pwd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void login(String userName, String password) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from t_stu where uname=? and pwd=?";
            // 对sql语句进行语法检查
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void insert(int id, String userName, String password) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into t_stu(id, uname, pwd) VALUE(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement);
        }
    }

    @Override
    public void delete(int id) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "delete from t_stu where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement);
        }
    }

    @Override
    public void update(int id, String userName, String password) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "update t_stu set uname=?,pwd=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement);
        }
    }

}
