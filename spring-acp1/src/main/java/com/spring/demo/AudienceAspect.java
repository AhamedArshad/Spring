package com.spring.demo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceAspect {
	
	@Pointcut("execution(* com.spring.demo.Singer.perform(..))")	
	private void pointCut(){}
	
	@Before("pointCut()")
	public void takeSeat(){
		System.out.println("Audience takes respective seats");
	}
	
	@Before("pointCut()")
	public void WelcomeDrink(){
		System.out.println("Audience served WelcomeDrink");
		
	}
	
	
	@AfterReturning("pointCut()")	
	public void claps(){
		System.out.println("Audienct Claps!!...");
	}

}
