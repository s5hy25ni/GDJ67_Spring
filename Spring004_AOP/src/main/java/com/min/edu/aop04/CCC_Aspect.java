package com.min.edu.aop04;

public class CCC_Aspect{
	
	/*
	 * CC의 메소드가 실행되기 전 실행
	 */
	public void beforeMethod() {
		System.out.println("메소드 실행");
	}
	
	/*
	 * CC의 메소드가 예외가 발생했을 때 실행
	 */
	public void exceptionMethod(Exception e) {
		System.out.println("메소드에 예외가 발생했습니다" + e.getMessage());
	}
	
	/*
	 * CC의 메소드가 종료되었을 때 실행
	 */
	public void afterMethod() {
		System.out.println("CTO 메소드 종료");
	}
	
}
