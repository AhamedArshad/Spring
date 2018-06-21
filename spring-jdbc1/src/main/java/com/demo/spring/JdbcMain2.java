package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.demo.entity.Emp;

public class JdbcMain2 {

	
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jt =(JdbcTemplate)ctx.getBean("jdbcTemplate");
	
		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {
			
			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				return new Emp(rs.getInt("empno"),
						rs.getString("name"),rs.getString("address"),rs.getDouble("salary"));
			}
		});
		
		for (Emp e : empList){
			System.out.println(e.toString());
		}
		
		
	Emp singleEmp = jt.queryForObject("select * from emp where empno="+101, new RowMapper<Emp>() {
			
			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				return new Emp(rs.getInt("empno"),
						rs.getString("name"),rs.getString("address"),rs.getDouble("salary"));
			}
		});
	System.out.println(singleEmp.toString());
		
	}

}
