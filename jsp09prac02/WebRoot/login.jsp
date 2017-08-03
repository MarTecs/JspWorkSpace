<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<span style="color: red; font-weight: bold;">
<% 
	String error = (String)request.getAttribute("error");
	if(error != null && !("".equals(error)) )
	{
		out.println(error);
	}
%>

</span>


<form action="user.do?method=login" method="post">
	用户名：<input type="text" name="username" /><br />
	密&nbsp;码：<input type="password" name="password" /><br />
	<input type="submit" value="登录" /><br />
	请选择保存时长：
	<select name="time">
		<option value="-1">不保存</option>
		<option value="30">30秒</option>
		<option value="3600">1小时</option>
	</select>
	
	<!-- session隐藏域 -->
	<input type="hidden" value="${session.id }" name="jsessionid" />
</form>