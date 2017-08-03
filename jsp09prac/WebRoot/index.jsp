<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



session的Id编号为<%=session.getId() %>
<br />
seesion最新：<%=session.isNew() %>

<%
	//设置session最大生命周期为10秒钟，只是客户端丢掉了sessionId,服务器并没有销毁session
	session.setMaxInactiveInterval(10);
 %>