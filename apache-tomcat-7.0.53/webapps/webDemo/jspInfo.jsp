<%@ page contentType="text/html;charset=utf-8"%>
<!-- 指定info信息 -->
<%@ page info="This is a about sivan Wu's blog!"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>测试page指令的info属性</title>
  </head>
  <body>
    <!-- 输出info信息 -->
    <%=getServletInfo()%>
  </body>
</html>
