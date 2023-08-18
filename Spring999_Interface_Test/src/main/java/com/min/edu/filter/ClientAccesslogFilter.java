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
		logger.info(">>>>>>>>>> Client 요청 정보 Filter 시작");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		logger.info("[Client Filter Logger] {} {}", url, queryString);
		
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		logger.info(">>>>>>>>>> Client 요청 정보 Filter 종료");

	}

}
