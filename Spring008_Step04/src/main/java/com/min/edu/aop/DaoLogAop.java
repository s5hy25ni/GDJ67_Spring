package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO 00_02 AOP Configuration Bean에서 사용할 Advice 메소드
public class DaoLogAop {

	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+""); // class => target
		logger.info("시작");
		
		Object[] obj = j.getArgs(); // arguments
		if(obj != null && obj.length != 0) {
			logger.info("method \t {}", j.getSignature().getName()); // method => signature
			
			for(int i=0; i<obj.length; i++) {
				logger.info(i+"번째 :\t", obj[i]);
			}
			
			logger.info("method \t {}", j.getSignature().getName()); // method => signature
		}
		
	}
	
	public void afterReturning(JoinPoint j) throws Throwable {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		
		ProceedingJoinPoint jp = (ProceedingJoinPoint)j;
		logger.info("끝 : {}", jp.proceed());
	}
	
	public void error(JoinPoint j, Exception e) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("에러 \t {}", j.getArgs());
		logger.info("에러 \t {}", j.toString());
	}
}
