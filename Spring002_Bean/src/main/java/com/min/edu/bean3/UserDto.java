package com.min.edu.bean3;

import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Required;

public class UserDto {

	private String name;
	private Properties per;
	private Date myDate;
	private String hobby;
	
	public UserDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getPer() {
		return per;
	}

	public void setPer(Properties per) {
		this.per = per;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

//	@Required
	/*
	 * 생성자 주입을 통해 필수적으로 입력이 되도록 강요하기 위한 Annotation
	 * 하지만 @Required는 Spring framework 버전 5.1 이후에는 사용되지 않고 있음
	 */
	public String getHobby() {
		return hobby;
	}
	
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", per=" + per + ", myDate=" + myDate + ", hobby=" + hobby + "]";
	}

	
}
