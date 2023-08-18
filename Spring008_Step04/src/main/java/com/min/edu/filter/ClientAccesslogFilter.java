package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientAccesslogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(ClientAccesslogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Client 요청 정보 Filter 시작");
	}

	/*
	 * import javax.servlet.Filter 사용하면 선택할 수 있는 클래스 가 2개 나옴
	 * 1) 외부의 WAS인 tomcat9.0에 있는 라이브러리
	 * 2) Maven에 dependency에 선언된 servlet-api 에 있는 라이브러리
	 * 
	 * pom.xml의 scope 만약 Provide로 되어 있기 때문에 시스템의 Maven 사용이 가능하도록 만듦
	 * 현재 WAS의 라이브러리를 선택
	 * ☞ 배포하게 되면 배포 서버의 WAS를 사용하기 때문
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = req.getRemoteAddr();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		String referer = req.getHeader("Referer");
		String userAgent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(url).append("?").append(queryString).append(":").append(referer).append(":").append(userAgent);
		
		logger.info("[Client Filter Logger] {}", sb.toString());
		
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		logger.info("Client 요청 정보 Filter 종료");

	}

}
