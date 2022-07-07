package com.dao.impl;

import com.dao.LoginDao;
import com.pojo.T_User;
import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    T_User user = null;

    @Override
    public T_User login(String uname, String pwd) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from t_user where uname=? and pwd=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new T_User();
                user.setUname(resultSet.getString("uname"));
                user.setPwd(resultSet.getString("pwd"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }
        return user;
    }
}
