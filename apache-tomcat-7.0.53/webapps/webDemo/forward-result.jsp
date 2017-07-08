<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>forward结果页</title>
  </head>
  <body>
    <!-- 使用request内置对象获取age参数的值 -->
    <%= request.getParameter("age") %>
    <!-- 输出username请求参数的值 -->
    <%= request.getParameter("username") %>
  </body>
</html>
