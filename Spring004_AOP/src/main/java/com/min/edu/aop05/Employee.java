package com.min.edu.aop05;

public class Employee implements IHumanWork {

	@Override
	public void work() {
		System.out.println(" ◎ 회사원의 주 기능인 점심식사를 합니다");
	}

}
