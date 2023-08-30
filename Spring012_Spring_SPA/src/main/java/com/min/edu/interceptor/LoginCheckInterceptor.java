package com.min.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/*
 * TODO 17_02 로그인 Session을 확인하년 Interceptor
 * 		Spring mvc:interceptor를 통해서 특정 RequestMapping이 실행되기 전에 로직으로 수행하고
 * 		결과에 따른 흐름제어가 가능하도록 설정
 * 		로그인이 되어야 호출되는 페이지를 interceptor
 */
@Slf4j
public class LoginCheckInterceptor implements AsyncHandlerInterceptor {

	// preHandle : 비동기요청이 처리되기 전에 호출된다. 반환값을 boolean 값을 반환하며, false를 반환하면 해당 요청이 처리되지 않는다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		return AsyncHandlerInterceptor.super.preHandle(request, response, handler);
		log.info("인터셉터 시작, 로그인 Session 확인 : 존재하면 true, 없으면 false logout.do 호출");
		if(request.getSession().getAttribute("loginVo") == null) {
			log.info("로그인 정보 없음");
			response.sendRedirect("./logout.do");
			return false;
		}
		return true;
	}
	
	// postHandle : 요청 처리가 완료되고 "뷰렌더링" 되기 전에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("인터셉터 종료");
		AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	// afterComplete : 요청 처리가 완료되고 뷰가 렌더링된 후에 호출, 예외가 발생하면 afterComplete 메소드는 예외를 처리하고 다시 발생시킬 수 있다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("인터셉터 view 렌더링 종료");
		AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	// afterConcurrentHandlingStarted : 비동기 요청이 처리되기 시작했을 때 호출됩니다.
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("비동기 ResponseBody 호출이 되었을 때 실행");
		AsyncHandlerInterceptor.super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
