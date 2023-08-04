package com.min.edu.anno05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * TODO anno05 05_02 주입 방법에 따라서 받는 멤버필드 객체
 * 		작성된 bean을 주입(DI)하기 위해서는 반드시 Spring Bean Configuration에 <context:annotation-config>을 선언해야 함
 *
 */
public class School {
	
	//TODO anno05 05_03
//	@Autowired // 생성된 bean이 단 1개만 있을 경우 자동 DI, 여러 개인 경우 사용 불가
//	@Autowired(required = false) // 주입되는 객체가 없으면 null로 초기화, 반환
	
	//TODO anno05 05_04
//	@Autowired
//	@Qualifier("stu01") // 생성된 여러 개의 같은 타입 bean 중에서 해당 id의 bean을 주입
	
	//TODO anno05 05_05
	@Resource(name="stu01") // name을 통해 특정 bean을 주입
//	@Qualifier("stu01") // @Qualifier는 보통 Autowired에서만 사용
	private Student student;
	
	
	private int grade;
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}
	public School(Student student, int grade) {
		super();
		this.student = student;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "School [student=" + student + ", grade=" + grade + "]";
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
}
