<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
		//用来判断是否已经登录认证，否则将可以在地址栏直接跳转到该界面，不需要登录
		
		//方法一：采用session进行跟踪
		/*
		String username = (String)session.getAttribute("username");
		if(username == null)
		{
			response.sendRedirect("login.jsp");
		}
		*/
		
		//方法二：采用隐藏表单域
		String jsessionid = request.getParameter("jsessionid");
		if(jsessionid == null && session.getId() != jsessionid){
			response.sendRedirect("login.jsp");
		}
		
		
 %>




this is main