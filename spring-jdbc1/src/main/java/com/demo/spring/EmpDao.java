package com.demo.spring;

import java.util.List;

import com.demo.entity.Emp;

public interface EmpDao {

	
	public String save(Emp e);
	public String delete(int empId);
	public Emp findById(int id);
	public List<Emp> getAll();
	public String saveSome(List<Emp> emps);
	
}
