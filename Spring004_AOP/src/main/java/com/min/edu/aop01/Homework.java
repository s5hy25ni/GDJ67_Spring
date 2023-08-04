package com.min.edu.aop01;

public class Homework {
	public void workProcess() {
		
		/*
		 * ◆ : 주기능의 상태 및 반복적으로 실행되는 기능
		 * ◎ : 실질적으로 실행되어야 하는 주기능
		 */
		System.out.println(" ◆ 업무를 시작하기 위한 준비 운동");
		
		try {
			System.out.println(" ◎ 업무를 시작한다");
		} catch (Exception e) {
			System.out.println(" ◆ 업무가 힘들 때 조퇴 한다");
		} finally {
			System.out.println(" ◆ 퇴근을 합니다");
		}
	}
}
