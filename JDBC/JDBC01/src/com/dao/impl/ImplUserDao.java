package com.dao.impl;

import com.dao.UserDao;
import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImplUserDao implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void insert(int id, String userName, String password) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into t_stu(id, uname, pwd) VALUE (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("新增成功");
            } else {
                System.out.println("新增失败");
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

    @Override
    public void select(int id) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from t_stu where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            System.out.println("id\tuserName\tpassword");
            while (resultSet.next()) {
                int id_ = resultSet.getInt("id");
                String userName = resultSet.getString("uname");
                String password = resultSet.getString("pwd");
                System.out.println(id_ + "\t" + userName + "\t\t\t" + password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void selectAll() {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from t_stu";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("id\tuserName\tpassword");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("uname");
                String password = resultSet.getString("pwd");
                System.out.println(id + "\t" + userName + "\t\t\t" + password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }
    }
}
