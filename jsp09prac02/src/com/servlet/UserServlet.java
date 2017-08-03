package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.UserInfo;
import com.util.DBUtil;

public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		if ("login".equals(method)) {
			doLogIn(request, response);
		}
	}

	public void doLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//定制一个错误消息提示符
		String errMSG = "";
		
		String sql = "SELECT username, password FROM userinfo where username = ? and password = ? ";
		List list = DBUtil.query(UserInfo.class, sql, username, password);
		if(list.isEmpty()){
			errMSG = "用户名或密码错误";
			request.setAttribute("error", errMSG);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			HttpSession session = request.getSession();
			request.setAttribute("jsessionid", session.getId());
			
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				System.out.println("domain\t" + cookie.getDomain());
				System.out.println("comment:\t" + cookie.getComment());
				System.out.println("value:\t" + cookie.getValue());
				System.out.println("path:\t" + cookie.getPath());
				System.out.println("MaxAge:\t" + cookie.getMaxAge());
			}
			
			
			String time = request.getParameter("time");
			Cookie username_Coolie = new Cookie("username", username);
			Cookie password_Cookie = new Cookie("password", password);
			
			//设置cookie生命周期
			username_Coolie.setMaxAge(Integer.parseInt(time));
			password_Cookie.setMaxAge(Integer.parseInt(time));
			
			//添加cookie
			response.addCookie(username_Coolie);
			response.addCookie(password_Cookie);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

}
