package com.jaycao.jdbc;

import com.jaycao.domain.Emp;

import java.sql.SQLException;
import java.util.List;

public class JdbcDemo03 {
    public static void main(String[] args) throws SQLException {
        List<Emp> list = new JdbcDemo04().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }
}
