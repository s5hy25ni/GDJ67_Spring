package com.min.edu.framework;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.handle.Handler;

public class DispatcherServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				Handler handle = handlerMapping(req, resp);
				System.out.println(handle);
				
				String viewName = handlerAdapter(handle, req, resp);
				System.out.println("이동해야 할 view jsp 이름 : "+viewName);
				
				helperView(viewName, req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private void helperView(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			String uri = prefix+viewName+suffix;
			req.getRequestDispatcher(uri).forward(req, resp);
			
		}

		private String handlerAdapter(Handler handle, HttpServletRequest req, HttpServletResponse resp) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Method handleMethod =
			handle.getClass().getMethod("handle", HttpServletRequest.class, HttpServletResponse.class);
			
			return (String)handleMethod.invoke(handle, req, resp);
			
		}

		private Handler handlerMapping(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		      String uri = req.getRequestURI();
		      System.out.println("요청된 주소"+uri);
		      
		      String handleName = "com.min.edu.service."+uri.substring(uri.lastIndexOf("/")+1)+"Handler";
		      System.out.println("실행되어야 할 JAVA의 위치명 : "+handleName);
		      
		      Class handlerClass = Class.forName(handleName);
		      Constructor<?> constructor = handlerClass.getConstructor(null);
		      return (Handler)constructor.newInstance(null);
		}
}  