package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String args[]){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Performer performer = context.getBean(Performer.class);
		performer.perform();
	}

}
