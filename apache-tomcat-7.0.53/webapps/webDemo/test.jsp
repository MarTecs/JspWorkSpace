<!-- 表明这是一个JSP页面 -->
<%@page contentType="text/html; charset=utf-8"%>
<html>
  <head>
    <title>第二个JSP页面</title>
  </head>
  <body>

    <!-- 下面是JAVA脚本 -->
    <%
      for(int i = 0; i < 7; i++)
      {
        out.println("<font size='" + i + "'>");

    %>
    疯狂的Java训练营（Wild Java Camp）</font>
    <br/>
    <%}%>

    <!-- 增加JSP注释 -->
    <%-- JSP注释部分 --%>
    <!-- 增加HTML注释 -->
    <!-- HTML注释部分 -->
  </body>
</html>
