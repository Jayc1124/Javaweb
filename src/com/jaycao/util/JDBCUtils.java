package com.jaycao.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @ClassName: JDBCUtils
 * @Description:jDBC工具类
 * @Author: CAO JAY
 * @Date: 2021/8/12 22:37
 */
public class JDBCUtils {
    /*
     文件的读取，只需要读取一次可拿到这些值，使用静态代码块
     */
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        Properties prop = new Properties();
        try {
            //2.加载配置文件
//            prop.load(new FileReader("D:\\Code\\IDEACode\\Javaweb\\jbdc\\src\\jdbc.properties"));
            //获取src下文件的方式-->Classloader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res  = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            prop.load(new FileReader(path));

            //3.获取数据
            JDBCUtils.url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url,user,password);
    }
    public static void close(Statement stmt,Connection conn){
        if(stmt !=null){
            try {
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs !=null){
            try {
                rs.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
