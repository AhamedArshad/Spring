package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.entity.Emp;

public class JpaMain {
	
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);		
		EmpDao dao =(EmpDao)ctx.getBean("empDaoJpaImpl");
		//dao.save(new Emp(400, "Tiger", "Dandeli", 56000));
		
		
		List<Emp> emps = dao.getAll();
		for(Emp e: emps){
			System.out.println(e.getName()+ " "+ e.getCity());
		}
		
		dao.delete(101);
	}

}
