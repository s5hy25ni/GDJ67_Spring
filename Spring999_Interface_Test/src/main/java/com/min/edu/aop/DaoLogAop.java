package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoLogAop {

	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.warn("===============> 메소드 실행 전");
		Object[] obj = j.getArgs();
		if(obj != null){
			logger.warn("========== {} Arguments", j.getSignature().getName());
			for(int i=0; i<obj.length; i++) {
				logger.warn("{} 번째 arg {}", i, obj[i].toString());
			}
			logger.warn("========== END");
		}
	}
	
	public void afterReturning(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.warn("========== END "+j.getSignature().getName());
	}
	
	public void afterThrowing(JoinPoint j, Exception e) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.warn("!!!!!!!!!! ERROR "+j.getSignature().getName());
		logger.warn("Exception MSG : "+e.getMessage());
	}
}
