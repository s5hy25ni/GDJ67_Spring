package com.min.edu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.handle.Handler;

public class HelloHandler implements Handler {

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("invoke 패턴에 의해서 위임되어 실행되어지는 service");
		String name = request.getParameter("name");
		
		// DAO처리 실행
		request.setAttribute("result", name);
		
		return "Hellopage";
	}

}
