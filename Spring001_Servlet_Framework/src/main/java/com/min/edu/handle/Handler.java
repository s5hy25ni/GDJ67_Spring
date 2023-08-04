package com.min.edu.handle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	public String handle(HttpServletRequest request, HttpServletResponse response);
}
