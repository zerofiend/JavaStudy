package com.dao.impl;

import com.dao.UserDao;
import com.pojo.T_User;
import com.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImplUserDao implements UserDao {
    //处理数据 连接数据库
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    T_User user = null;

    @Override
    public T_User login(String uname, String pwd) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from t_user where uname=? and pwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("uname");
                String password = rs.getString("pwd");
                user = new T_User();
                user.setUname(name);
                user.setPwd(password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, ps, rs);
        }
        return user;
    }
}
