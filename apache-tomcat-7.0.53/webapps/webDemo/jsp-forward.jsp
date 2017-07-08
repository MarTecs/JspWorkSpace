<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>forward的原始页</title>
  </head>
  <body>
    <h3>forward的原始页</h3>
    <jsp:forward page="forward-result.jsp">
      <jsp:param name="age" value="29"/>
    </jsp:forward>


    

  </body>
</html>
