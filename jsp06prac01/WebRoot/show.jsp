<%@ page language="java" import="java.util.*,com.pojo.*" pageEncoding="UTF-8"%>
<%
	List<UserInfo> list = (List)request.getAttribute("list");
%>

<table>
	<tr>
		<th>用户名</th>
		<th>密码</th>
		<th>操作</th>
	</tr>
	<%for(UserInfo user : list){ %>
		<tr>
			<td><%=user.getUsername() %></td>
			<td><%=user.getPassword() %></td>
			<td>
				<a href="user.do?method=add&username=<%=user.getUsername() %>">新增</a>|
				<a href="user.do?method=delete&username=<%=user.getUsername() %>">删除</a>|
				<a href="user.do?method=update&username=<%=user.getUsername() %>">修改</a>
			</td>
		</tr>
	<%} %>
</table>