package com.min.edu.anno05;

/**
 * TODO anno05 05_01 Spring Bean Configuration의 xml을 통해서 여러 개의 bean을 생성할 객체
 * 		@Component에 의해서 하나만 사용되는 것이 아니라 여러 개를 선언하여 사용
 * @author GDJ67
 *
 */
public class Student {

	private String name;
	private String addr;
	private String age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String addr, String age) {
		super();
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
