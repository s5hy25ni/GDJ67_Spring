package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Spring Framework 프로젝트의 Controller에서 Alert를 호출하기 위한 ServletAlert
 * @since 2023. 08. 24
 * @author SoHyeon
 *
 */
public class SpringUtils {
	
	/**
	 * 반환되는 Response에 이동 URL과 메시지를 전달하려 script를 통해서 alert 동작
	 * @param response 브라우저에 응답을 해주는 객체
	 * @param msg alert의 전달 메시지 전달
	 * @param url url 이동 경로
	 * @throws IOException
	 */
	public static void servletAlert(HttpServletResponse response,
										String msg,
										String url) throws IOException {
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.printf("<script>alert('%s'); location.href='./%s';</script>", msg, url);
		out.flush();
	}
}
