/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2017-05-21 04:05:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class registerAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/s59";
    String user = "root";
    String pass = "1018222wxw";
    Connection conn = DriverManager.getConnection(url, user, pass);

    String sql = "insert into emp(dId, eName, eSex, eBorn, elove) values(?,?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);

    //由于传参数使用request获得的中文是乱码，所以设置下编码
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("username");
    int id = Integer.parseInt(request.getParameter("dep"));
    String sex = request.getParameter("sex");
    String born = request.getParameter("birth");
    String[] s = request.getParameterValues("hobby");
    StringBuffer sb = new StringBuffer();
    for(String str : s){
        sb.append(str).append(",");
    }

    sb.setCharAt(sb.length()-1, ' ');  //这里如果写成 '' 将会报出不合法的字符常量
    String a = sb.toString();
    out.println(sb + "<br>");
    out.println(name + "<br>");
    out.println(id + "<br>");
    out.println(sex + "<br>");
    out.println(born + "<br>");
    if(sb != null && born != null && sex != null && name != null){
      //避免空指针异常
      ps.setInt(1, id);
      ps.setObject(2, name);
      ps.setObject(3, sex);
      ps.setObject(4, born);
      //将StringBuffer转换成String
      ps.setObject(5, a);
      int n = ps.executeUpdate();
      if(n > 0){
        response.sendRedirect("index.jsp");
      }else{
        out.println("新增失败");
      }
    }

      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
