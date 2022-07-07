package com.web.dao.impl;

import com.web.dao.UserDao;
import com.web.pojo.T_User;
import com.web.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    T_User user = null;

    @Override
    public T_User loginUser(String uname, String pwd) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from t_user where uname=? and pwd=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String uname1 = resultSet.getString("uname");
                String pwd1 = resultSet.getString("pwd");
                int id = resultSet.getInt("id");
                user = new T_User(id, uname, pwd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }
        return user;
    }

    @Override
    public int addUser(String uname, String pwd) {
        int n = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into t_user(uname, pwd) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pwd);
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement);
        }
        return n;
    }

    @Override
    public int updateUser(int id, String pwd) {
        int n = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "update t_user set pwd=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pwd);
            preparedStatement.setInt(2, id);
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement);
        }
        return n;
    }

    @Override
    public int deleteUser(String id) {
        int n = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "delete from t_user where id=?";
            preparedStatement = connection.prepareStatement(sql);
            int id_ = Integer.parseInt(id);
            preparedStatement.setInt(1, id_);
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement);
        }
        return n;
    }

    @Override
    public List<T_User> showAll() {
        List<T_User> users = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from t_user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uname = resultSet.getString("uname");
                String pwd = resultSet.getString("pwd");
                user = new T_User(id, uname, pwd);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
