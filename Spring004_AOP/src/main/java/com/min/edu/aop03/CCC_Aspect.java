package com.min.edu.aop03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CCC_Aspect{
	
	/*
	 * CC의 메소드가 실행되기 전 실행
	 */
	@Before("execution(public void com.min.edu.aop03.*.*(..))")
	public void beforeMethod() {
		System.out.println("메소드 실행");
	}
	
	/*
	 * CC의 메소드가 예외가 발생했을 때 실행
	 */
	@AfterThrowing(pointcut="execution(public void com.min.edu.aop03.*.*(..))", throwing="e")
	public void exceptionMethod(Exception e) {
		System.out.println("메소드에 예외가 발생했습니다" + e.getMessage());
	}
	
	/*
	 * CC의 메소드가 종료되었을 때 실행
	 */
	@After("execution(public void com.min.edu.aop03.CTO.*(..))")
	public void afterMethod() {
		System.out.println("CTO 메소드 종료");
	}
	
}
