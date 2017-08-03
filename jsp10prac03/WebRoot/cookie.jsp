<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
	
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies)
	{
		out.println(c.getDomain() + "<br />");					//生成该cookie的域名
		out.println(c.getPath() + "<br />");					//该cookie的生成路径
		out.println(c.getMaxAge() + "<br />");					//最大生命周期
		out.println(c.getValue() + "<br />");
		out.println("cookie遍历结束" + "<br />");
	}
%>