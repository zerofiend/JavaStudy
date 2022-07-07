package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Niko
 * @老师QQ 2700778743
 * @company 享学信息科技有限公司
 * @create 2021-11-14 17:15
 */
public class JDBCUtil {

   /* static  String driveClass="com.mysql.jdbc.Driver";
   static String url="jdbc:mysql://localhost/Student";
   static String name="root";
   static String pwd="123456";*/

    static  String driveClass=null;
   static String url=null;
   static String name=null;
   static String pwd=null;

   //读配置文件
   static {
       //创建一个属性配置对象
       Properties properties=new Properties();
       InputStream is= null;
       try {
          // is = new FileInputStream("jdbc.properties");
           is=JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

           properties.load(is);

           driveClass= properties.getProperty("driverClass");
           url= properties.getProperty("url");
           name= properties.getProperty("name");
           pwd= properties.getProperty("pwd");

       } catch (Exception e) {
           e.printStackTrace();
       }

   }



    //获取链接对象
    public static  Connection getConn()  {
        Connection conn=null;
        try {
           Class.forName(driveClass);
            conn= DriverManager.getConnection(url,name,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public  static  void release(Connection conn,Statement st,ResultSet rs){
            closeRs(rs);
            closeSt(st);
            closeConn(conn);
    }

    private static  void closeRs(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    private static  void closeSt(Statement st){
        if (st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    private static  void closeConn(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
