package com.jaycao.jdbc;

import com.jaycao.domain.Emp;
import com.jaycao.util.JDBCUtils;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.swing.plaf.nimbus.State;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * @ClassName: JdbcDemo04
 * @Description:
 * @Author: CAO JAY
 * @Date: 2021/8/12 22:15
 */
public class JdbcDemo04 {
    /*
    演示JDBC工具类
     */
    public List<Emp> findAll() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<>();
        conn= JDBCUtils.getConnection();
        String sql = "select * from emp";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt("id");
            String ename = rs.getString("ename");
            int job_id = rs.getInt("job_id");
            int mgr = rs.getInt("mgr");
            Date joindate = rs.getDate("joindate");
            double salary = rs.getDouble("salary");
            double bonus = rs.getDouble("bonus");
            int dept_id = rs.getInt("dept_id");
            // 创建emp对象,并赋值
            Emp emp = new Emp();
            emp.setId(id);
            emp.setEname(ename);
            emp.setJob_id(job_id);
            emp.setMgr(mgr);
            emp.setJoindate(joindate);
            emp.setSalary(salary);
            emp.setBonus(bonus);
            emp.setDept_id(dept_id);

            //装载集合
            list.add(emp);
        }


        JDBCUtils.close(rs,stmt,conn);
        return list;
    }

}
