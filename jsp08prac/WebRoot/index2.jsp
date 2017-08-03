<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	Date date = new Date();
	request.setAttribute("date", date);
	double s =	1.9888888789846;
	request.setAttribute("s",s);
	
	String s1 = "abcdefg";
	request.setAttribute("s1", s1);
 %>

<!-- 格式化日期 -->	
<fmt:formatDate value="${date }" pattern="yyyy-MM-dd hh:mm:ss EE"/>

<!-- 格式化数字 -->  : 保留四位小数
<fmt:formatNumber value="${s }" pattern=".####"></fmt:formatNumber>


<!-- 使用功能标签 -->
${fn:length(s1) }
${fn:substring(s, 1, 4) }			<!-- 从第1个截取到第4个，不包括第4个 -->
