package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Emp;


@Repository
public class EmpJdbcImpl implements EmpDao {

	@Autowired
	JdbcTemplate jt;
	
	
	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		
	
		int count = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				
				PreparedStatement pst = conn.prepareStatement
									("insert into emp(empno, name, address, salary)"
											+ "values(?,?,?,?)");
				
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());;
				pst.setString(3, e.getCity());;
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});
    if(count==1){
    	return "emp saved";
    }
    else
    	
    	return "not saved";
	}

	@Override
	public String delete(int empId) {
		// TODO Auto-generated method stub
		
		int count = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				
				PreparedStatement pst = conn.prepareStatement
									("delete from emp where empno= ?");
				pst.setInt(1, empId);

				return pst;
			}
		});
		
		if(count==1){
			return "emp deleted";
		}
		else	
			return "not deleted";
}
		
	

	@Override
	public Emp findById(int id) {
		Emp singleEmp = null;
		try
		{
			singleEmp = jt.queryForObject("select * from emp where empno="+id, new RowMapper<Emp>() {
			
			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				return new Emp(rs.getInt("empno"),
						rs.getString("name"),rs.getString("address"),rs.getDouble("salary"));
			}
			});
		}
		
		catch(EmptyResultDataAccessException ex)
		{
			ex.printStackTrace();
			singleEmp = null;
		}
		catch(Exception ex){
			ex.printStackTrace();
			singleEmp = null;
		}
		return singleEmp;
	}

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		
		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {
			
			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				return new Emp(rs.getInt("empno"),
						rs.getString("name"),rs.getString("address"),rs.getDouble("salary"));
			}
		});
		
		return empList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveSome(List<Emp> emps) {
		// TODO Auto-generated method stub
		for(Emp e : emps){
			save(e);
		}
	 return "saveSome success!!";
	}

}
