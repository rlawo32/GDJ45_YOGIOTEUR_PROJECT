package com.tp.yogioteur.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class PreventLoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("loginMember") != null) { 		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('해당 기능은 사용할 수 없습니다.')");
			out.println("location.href='" + request.getContextPath() + "'");
			out.println("</script>");
			out.close();
			return false;		
		}
		return true;
	}
}
