<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>声明示例</title>
  </head>
  <!-- 下面是JSP声明部分 -->
  <%!
    //声明一个整形变量
    public int count;
    //声明一个方法
    public String info(){
      return "hello";
    }
  %>
  <body>
    <%
      //将count的值输出后再加1
      out.println(count++);
      %>
      <br />
      <%
        //输出info()方法的返回值
        out.println(info());
      %>
  </body>
</html>


<%-- 这里关于为什么每次刷新页面Count值都会加1，这是因为JSP页面会编译成一个Servlet类，每个Servlet在容器
中只有一个实例，在JSP中声明的变量是成员变量，成员变量只在创建的时候初始化，该变量的值将会被一直保存，直到
实例销毁！
 --%>
