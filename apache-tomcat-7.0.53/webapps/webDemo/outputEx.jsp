<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>输出表达式的值</title>
  </head>
  <%!
    public int count;
    public String info()
    {
      return "hello";
    }
  %>
  <body>
    <!-- 使用表达式输出变量的值 -->
    <%=count++%>
    <br />
    <!-- 使用表达式输出方法返回值 -->
    <%= info() %>
  </body>
</html>

<%-- 注意：输出表达式之后不能有分号 --%>
