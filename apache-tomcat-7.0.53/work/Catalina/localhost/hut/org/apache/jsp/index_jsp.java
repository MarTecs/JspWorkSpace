/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2017-07-14 02:35:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>欢迎使用正方教务管理系统！请登录</title>\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div id=\"container\">\r\n");
      out.write("      <div id=\"header\">\r\n");
      out.write("        <img class=\"logo\" src=\"images\\logo_school.png\" alt=\"请稍后再试\" >\r\n");
      out.write("        <img class=\"logo jw\" src=\"images\\logo_jw.png\" alt=\"请稍后再试\" >\r\n");
      out.write("        <img id=\"copyright\" src=\"images\\login_zf.jpg\" alt=\"请稍后再试\" >\r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"main\">\r\n");
      out.write("        <div id=\"left\">\r\n");
      out.write("          <img src=\"images/login_pic.png\" alt=\"请稍后再试\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"right\">\r\n");
      out.write("          <form action=\"doLogIn.jsp\" method=\"post\">\r\n");
      out.write("            <table>\r\n");
      out.write("              <tr class=\"data-line\">\r\n");
      out.write("                <td>\r\n");
      out.write("                  <span id=\"user\" class=\"data data-user\">用户名：</span>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <input type=\"text\" class=\"data-text\" name=\"data-username\" required>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr class=\"data-line\">\r\n");
      out.write("                <td>\r\n");
      out.write("                  <span id=\"pass\" class=\"data data-pass\">密&nbsp;&nbsp;&nbsp;码：</span>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <input type=\"password\" class=\"data-text\" name=\"data-password\" required>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr class=\"data-line\">\r\n");
      out.write("                <td>\r\n");
      out.write("                  <span id=\"validate\" class=\"data data-validate\">验证码：</span>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <input type=\"text\" class=\"data-text\" name=\"data-validate\" required>\r\n");
      out.write("                  <img id=\"icode\" src=\"http://218.75.197.123:83/CheckCode.aspx?\" alt=\"看不清换一张\">\r\n");
      out.write("                  <a href=\"\" style=\"text-decoration:none;color:blue;position:absolute;top:250px;right:90px;\">\r\n");
      out.write("                    看不清换一张\r\n");
      out.write("                  </a>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            <table class=\"data-jobs\">\r\n");
      out.write("              <tbody>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td class=\"data-td\">\r\n");
      out.write("                    <input type=\"radio\" name=\"jobs\" value=\"department\">\r\n");
      out.write("                    <label for=\"jobs\">部门</label>\r\n");
      out.write("                  </td>\r\n");
      out.write("                  <td class=\"data-td\">\r\n");
      out.write("                    <input type=\"radio\" name=\"jobs\" value=\"teacher\">\r\n");
      out.write("                    <label for=\"jobs\">教师</label>\r\n");
      out.write("                  </td>\r\n");
      out.write("                  <td class=\"data-td\">\r\n");
      out.write("                    <input type=\"radio\" name=\"jobs\" value=\"student\">\r\n");
      out.write("                    <label for=\"jobs\">学生</label>\r\n");
      out.write("                  </td>\r\n");
      out.write("                  <td class=\"data-td\">\r\n");
      out.write("                    <input type=\"radio\" name=\"jobs\" value=\"visitor\">\r\n");
      out.write("                    <label for=\"jobs\">访客</label>\r\n");
      out.write("                  </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("                <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td>\r\n");
      out.write("                    <input class=\"data-button\" type=\"image\" src=\"images/login_in.gif\">\r\n");
      out.write("                  </td>\r\n");
      out.write("                  <td>\r\n");
      out.write("                    <input class=\"data-button\" type=\"image\" src=\"images/login_res.gif\">\r\n");
      out.write("                  </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"footer\">\r\n");
      out.write("          <p>\r\n");
      out.write("            &copy;1999-2012&nbsp;<a href=\"http://www.zfsoft.com/\">正方软件股份有限公司</a>&nbsp;版权所有&nbsp;&nbsp;联系电话：0571-89902828\r\n");
      out.write("          </p>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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
