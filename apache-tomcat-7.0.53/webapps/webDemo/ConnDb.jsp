<%@page contentType="text/html; charset=utf-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>小脚本测试</title>
  </head>
  <body>
    <%
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s59",
      "root","1018222wxw");
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from emp");
    %>
    <table bgcolor="#9999dd" border="1" width="300">
      <%
        //遍历结果集
        while(rs.next())
        {
      %>

        <tr>
          <%-- 输出结果集 --%>
          <td><%=rs.getString(1)%></td>
          <td><%=rs.getString(2)%></td>
        </tr>
        <%}%>
    </table>
  </body>
</html>
