package com.min.edu.aop01;

public class AOP01_Main {
	
	/*
	 * ◆ : 주기능의 상태 및 반복적으로 실행되는 기능
	 * ◎ : 실질적으로 실행되어야 하는 주기능
	 */
	public static void main(String[] args) {
		System.out.println(" ◆ 프로그램을 실행시킨다");
		
		Homework work = new Homework();
		work.workProcess();
		
		System.out.println(" ◆ 프로그램을 종료한다");
	}

}
