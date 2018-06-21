package com.demo.spring;


import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	
	static HashMap<Integer, Emp> empDb = new HashMap<Integer, Emp>();
	static{
		empDb.put(1000, new Emp(1000, "Scott","Hyderabad", 75000));
		empDb.put(1001, new Emp(1001, "Rahul","Chennai", 45000));
		empDb.put(1002, new Emp(1002, "Sheikh","Riode", 55000));
		empDb.put(1003, new Emp(1003, "Naseer","Pausalo", 15000));
		empDb.put(1004, new Emp(1004, "Vinay","Bangl", 25000));
		empDb.put(1005, new Emp(1005, "Ronaldo","London", 35000));
		empDb.put(1006, new Emp(1006, "Pepe","Madrid", 95000));
		empDb.put(1007, new Emp(1007, "MoSalah","Bangl", 85000));
	}
	
	
	@RequestMapping(path="/info", method=RequestMethod.GET)
	public String info()
	{
		return "this is a Spring Restful Service";
	}
	
	@RequestMapping(path="/greet/{name}", method=RequestMethod.GET)
	public String greet(@PathVariable("name") String name)
	{
		return "Hello " + name;
	}
	
	@RequestMapping(path="/emp", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getEmp(@RequestParam("id") int id){
		if(empDb.containsKey(id)){
			Emp e = empDb.get(id); 
			return ResponseEntity.ok(e);
		}
		else
			return ResponseEntity.ok("Employee does not exist");				
	}
}
