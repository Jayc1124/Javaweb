package com.jaycao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包.
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn=DriverManager.getConnection("jdbc:mysql://119.8.123.19:3306/db3","root","caojie1124");
        //4.定义sql语句
        String sql = "update account set balance = 1000 where id = 1";
        //5.获取执行sql的对象statement

        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
