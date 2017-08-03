<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:if test="${user.getUserName == null }">
	return;
</c:if>

<style>

	.bigDiv {
		width: 1000px;
		height: 300px;
		margin: 20px auto;
		border: 1px solid red;
	}
	
	.smallDiv {
		
		width: 230px;
		height: 250px;
		margin: 25px auto;
		border: 1px solid blue;
		float: left;
		text-align: center;	
		
	}
	
	.showIma {
		width:160px;
		height: 160px;
		position: relative;
		left: 50%;
		height: 50%;
		margin-left: -80px;
	}
	
	h3 {
		margin-bottom: 20px;
	}
</style>


<c:forEach var="goods" varStatus="in" items="${list }">
	<!-- 一个大层开始 -->
	<c:if test="${in.index % 4 == 0 }">
		<div class="bigDiv">
	</c:if>
	
		<div class="smallDiv">
			
			<br />
			<div class="showIma">
				<a href="goods.do?method=findById&id=${goods.goodsid }">
					<img src="${pageContext.servletContext.contextPath }/image/${goods.goodsid}.jpg" />
				</a>
			</div>
			<br />
			<h3>${goods.goodsid }.${goods.goodsname }</h3>
		</div>
		
		
	
	<c:if test="${in.index % 4 == 3 || fn:length(list) == in.index + 1 }">
		</div>
	</c:if>
	



</c:forEach>