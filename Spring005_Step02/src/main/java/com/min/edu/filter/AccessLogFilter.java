package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO 12 요청에서 정보 추출(요청 주소, 접근자, 접근 브라우저 등) header 정보 및 HttpServletRequest에서 조회, 출력
public class AccessLogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("들어옴");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 요청 정보를 출력
		HttpServletRequest req = (HttpServletRequest)request;
		
		/*
		 * 1. HttpServletRequest 정보
		 * 	1) 요청주소(remoteAddr)
		 * 	2) 요청값(queryString)
		 * 2. Header 정보
		 * 	1) User-Agent
		 * 	2) Referer
		 * ※ Pragma, Cache-Control, Expires : 캐쉬 정보 -> 뒤로가기 정보 삭제
		 */
		
		// 1) 접근을 시도하는 Client의 주소를 출력
		String remoteAddr = req.getRemoteAddr(); // default IPv6
//		System.out.println(remoteAddr);
		
		// 2) URL / URI
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		
//		System.out.println(uri);
//		System.out.println(url);
		
		// 3) 전달 받은 요청 값(쿼리 스트링)
		String queryString = req.getQueryString();
//		queryString = queryString==null?"":queryString; // java의 삼항연산자를 통한 문자열 값 변경
		queryString = StringUtils.defaultIfEmpty(queryString, ""); // commons-lang3 라이브러리를 통한 문자열 값처리
		
//		System.out.println(queryString);
		
		// 4) 이전 요청 페이지 확인
		String referer = StringUtils.defaultIfEmpty(req.getHeader("Referer"),"-");
		
		// 5) 요청 정보(운영체제, 브라우저)
		String agent = StringUtils.defaultIfEmpty(req.getHeader("User-Agent"),"-");
		
		////////////////////////////////////////////////////////////////
		String fullUrl = url;
		fullUrl += StringUtils.isNotEmpty(queryString)?"?"+queryString:queryString;
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(fullUrl).append(":").append(referer).append(":").append("agent");
		
		logger.info("[Logger Filter {}", sb.toString());
		chain.doFilter(request, response);
	}	

	@Override
	public void destroy() {
		logger.info("나감");
	}

}
