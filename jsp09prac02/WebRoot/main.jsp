<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String jsessionId = (String) request.getAttribute("jsessionid");
	if (jsessionId == null) {
		response.sendRedirect("login.jsp");
		return;
	}
%>


This is main
