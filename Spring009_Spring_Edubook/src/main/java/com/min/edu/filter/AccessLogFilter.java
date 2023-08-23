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

public class AccessLogFilter implements Filter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("==== AccessLogFilter init() 실행 ====");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "URL 없음") ;
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
		
		logger.info("Client 요청주소 \n\t {}",url+queryString);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("==== AccessLogFilter init() 종료 ====");
	}

	
	
}
