package com.min.edu.aop05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CCC_Aspect{

	@Pointcut("execution(public * * (..))")
	public void myPointCut() {}
	
	@Before("myPointCut()")
	public void beforeMethod() {
		System.out.println("메소드 실행");
	}

	@AfterThrowing(pointcut = "myPointCut()", throwing = "e")
	public void exceptionMethod(Exception e) {
		System.out.println("메소드에 예외가 발생했습니다" + e.getMessage());
	}

	@After("myPointCut()")
	public void afterMethod() {
		System.out.println("CTO 메소드 종료");
	}
	
}
