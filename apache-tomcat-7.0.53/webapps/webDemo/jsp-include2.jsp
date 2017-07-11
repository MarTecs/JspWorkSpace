<%page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>jsp-include测试</title>
  </head>
  <body>
    <jsp:include page="forward-result.jsp">
      <jsp:param name="age" value="32"/>
    </jsp:include>
  </body>
</html>
