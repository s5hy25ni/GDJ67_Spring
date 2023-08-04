package com.min.edu.aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * TODO AOP02 02_03 주기능인 CC(CTO, Employee)를 auto-proxy하여 weaving을 통해서 새로운 객체로 만들어 준다.
 * 					현잰느 annotation 방법이 아니기 때문에 spring bean configuration을 통해 생성
 */
public class CCC_Aspect implements MethodInterceptor{


	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object resultObj = null;
		System.out.println(" ◆ 메소드를 실행한다");
		
		try {
			resultObj = invocation.proceed(); // CC를 끌고 오게 됨 Proxy 설정
		} catch (Throwable e) {
			System.out.println(" ◆ 오류가 발생했습니다");
		} finally {
			System.out.println(" ◆ 메소드가 종료되었습니다");
		}
		return resultObj;
	}
	
	
}
