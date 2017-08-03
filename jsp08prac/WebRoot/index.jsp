<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 设置偶数行背景为蓝色 -->
<style>
	
	.even{
		background-color: blue;
	}
	
	.odd{
		background-color: blue;
	}
</style>



<!-- 核心标签库 -->
<%
	String[] strs = new String[]{"ss","bb","ssd"};
	session.setAttribute("strs", strs);

 %>


<br />
<!-- 设置偶数行与奇数行背景不同 -->
<table>
	<c:forEach varStatus="in" items="${strs}" var="st">
		<tr class="${in.index % 2 == 0 ? 'even' : 'odd'}">
			<td>${in.index % 2 == 0 ? 'even' : 'odd'}</td>
			<td>${in.index }</td>
			<td>${st }</td>
		</tr>
	</c:forEach>
</table>

