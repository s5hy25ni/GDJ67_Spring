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

public class AccessLogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("들어옴");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = StringUtils.defaultString(req.getHeader("remoteAddr"));
		String uri = StringUtils.defaultString(req.getRequestURI()); 
		String url = StringUtils.defaultString(req.getRequestURL().toString());
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
		String referer = StringUtils.defaultString(req.getHeader("Referer"));
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"));
		
		String fullUrl = url;
		fullUrl += StringUtils.isNotEmpty(req.getQueryString())?"?"+queryString:queryString;
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(fullUrl).append(":").append(referer).append(":").append(agent);
		
		logger.info("[Logger Filter {}", sb.toString());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("나감");

	}

}
