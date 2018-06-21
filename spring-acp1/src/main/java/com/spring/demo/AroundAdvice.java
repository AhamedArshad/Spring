package com.spring.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AroundAdvice {
	
	@Pointcut("execution(* com.spring.demo.Singer.perform(..))")
	private void pointCut(){}
	
	
	@Around("pointCut()")
	public void invoke(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Musicians check");
		pjp.proceed();
		System.out.println("Musicians Play");
	}

}
