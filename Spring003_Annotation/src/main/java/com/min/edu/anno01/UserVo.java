package com.min.edu.anno01;

import org.springframework.stereotype.Component;

@Component
public class UserVo {
	
	private String weather;
	
	public UserVo() {
		this.weather = "맑음";
	}

	@Override
	public String toString() {
		return "UserVo [weather=" + weather + "]";
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	
}
