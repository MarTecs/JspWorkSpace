<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>





<form action="user.do?method=login" method="post">

	用户名：<input type="text" name="username"><br />
	密码：<input type="password" name="password"><br />
	<input type="submit" value="登录">
	
	记住密码：
	<select name="time">
		<option value="0">不保存</option>
		<option value="20">20秒</option>
		<option value="86400">1天</option>
	</select>
	
	<!-- 设置隐藏域 -->
	
	<input type="hidden" value="${session.id }" name="jsessionid" />
</form>
