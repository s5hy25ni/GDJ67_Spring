package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoLoggerAop {

	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.warn("===============> 메소드 실행 전");	
		Object[] obj = j.getArgs();
		if(obj != null) {
			logger.warn("===============> {} Arguments", j.getSignature().getName());	
			int cnt=1;
			for (Object o : obj) {
				logger.warn("{} 번째 arg {}", cnt++, String.valueOf(o));
			}
			logger.warn("===============> {}", j.getSignature().getName());	
		}
	}
	
	public void afterReturning(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.warn("===============> 종료 : \t {}", j.getSignature().getName());
	}
	
	public void afterThrowing(JoinPoint j, Exception exception) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.warn("!!!!!!!!!!!!!!! 에러발생 : \t {}", j.getSignature().getName());		
		logger.warn("Exception Msg : \t {}", exception.getMessage());		
	}
}
