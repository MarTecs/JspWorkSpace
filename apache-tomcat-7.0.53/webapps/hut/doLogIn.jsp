<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*,java.io.*" %>

<%
    String username = request.getParameter("data-username");
    String password = request.getParameter("data-password");
    String identity = request.getParameter("jobs");
    String validate = request.getParameter("data-validate");

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = null;
    out.println(username);
    try{
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hut","root","1018222wxw");
      String sql = "select username,password from user where username = ? and password = ? and identity = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      out.println(sql);
      ps.setObject(1, username);
      ps.setObject(2, password);
      ps.setObject(3, identity);
      out.println(sql);
      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        out.println("sss");
        // response.sendRedirect("main.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);
      }else{
        out.println("dds");
        PrintWriter pw = response.getWriter();
        pw.write("账号或密码错误，请稍后再试");
      }
    }catch(Exception e){
      e.printStackTrace();

    }finally{
      try{
        conn.close();
      }catch(Exception e){
        e.printStackTrace();
      }
    }

%>

<h1>这是一个</h1>
