package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("login".equals(method)){
			try {
				doLogIn(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void doLogIn(HttpServletRequest request, HttpServletResponse 
			response) throws Exception
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		if("sunjob".equals(username) && "sunjob".equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			Cookie username_cookie = new Cookie("username", username);
			Cookie password_cookie = new Cookie("password", password);
			
			
			//如果不设置，时间默认为临时cookie,只要浏览器缓存数据清空，将不会保存
			String time = request.getParameter("time");
			username_cookie.setMaxAge(Integer.parseInt(time));
			password_cookie.setMaxAge(Integer.parseInt(time));
			
			response.addCookie(username_cookie);
			response.addCookie(password_cookie);
			System.out.println("ss");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
		
	}
}
