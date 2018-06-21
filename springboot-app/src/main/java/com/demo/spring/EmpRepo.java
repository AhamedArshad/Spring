package com.demo.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public interface EmpRepo extends CrudRepository<Emp, Integer> {
	 

}
