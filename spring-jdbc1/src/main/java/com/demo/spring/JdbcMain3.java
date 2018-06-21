package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.entity.Emp;

public class JdbcMain3 {
	
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpDao dao =(EmpDao)ctx.getBean("empJdbcImpl");
	/*	Emp e = dao.findById(101);
		
		
		if(e != null){
			System.out.println(e.getName());
		}
		
		else{
			System.out.println("Emp not found!!");
		}
		
		List<Emp> empListGroup= dao.getAll();
		for (Emp e1 : empListGroup){
			System.out.println(e1.toString());
	}
		
		
		String status = dao.delete(54000);
		System.out.println(status);
*/
		
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(300, "Rahul","hyd",75000 ));
		empList.add(new Emp(301, "Irfan","che",85000 ));
		empList.add(new Emp(299, "Imran","bangl",95000 ));
		empList.add(new Emp(304, "Aarol","Cochin",65000 ));
		
		
		dao.saveSome(empList);
}
}
