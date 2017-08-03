<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<style>

	*{
		marin: 0px;
		padding: 0px;
		
	}
	.bigDiv {
		width: 1000px;
		height: 350px;
		margin: 30px auto; 
		border: 1px solid red;
	}
	
	.smallDiv {
		width: 230px;
		height: 300px;
		margin: 25px auto;
		float: left;
		border: 1px solid blue;
	}
	
	.showImg {
		margin: 20px 35px;;
	}
	
	h3 {
		text-align: center;
	}
	
	
</style>

<c:forEach items="${list }" var="goods" varStatus="in">
	
	<!-- 开始一个大层 -->
	<c:if test="${in.index % 4 == 0 }">
		<div class="bigDiv">
	</c:if>
	
		<div class="smallDiv">
			<div class="showImg">
				<a href="all.do?method=showDetail&id=${goods.goodsid }">
					<img src="${pageContext.servletContext.contextPath }/image/${goods.goodsid}.jpg">
				</a>
			</div>
			<br />
			<h3>
				${goods.goodsname }&nbsp;
					<span style="color: red;">
						${goods.goodsprice }
					</span>
				<a href="" style="text-decoration: none; color: blue;">添加到购物车</a>
			</h3>
		</div>
	
	
	
	<!-- 大层结束 -->
	<c:if test="${in.index % 4 == 3 || fn:length(list) == in.index + 1 }">
		</div>
	</c:if>
	
		
</c:forEach>