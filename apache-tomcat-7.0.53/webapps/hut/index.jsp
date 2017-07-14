<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>欢迎使用正方教务管理系统！请登录</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    <div id="container">
      <div id="header">
        <img class="logo" src="images\logo_school.png" alt="请稍后再试" >
        <img class="logo jw" src="images\logo_jw.png" alt="请稍后再试" >
        <img id="copyright" src="images\login_zf.jpg" alt="请稍后再试" >
      </div>
      <div id="main">
        <div id="left">
          <img src="images/login_pic.png" alt="请稍后再试">
        </div>
        <div id="right">
          <form action="doLogIn.jsp" method="post">
            <table>
              <tr class="data-line">
                <td>
                  <span id="user" class="data data-user">用户名：</span>
                </td>
                <td>
                  <input type="text" class="data-text" name="data-username" required>
                </td>
              </tr>
              <tr class="data-line">
                <td>
                  <span id="pass" class="data data-pass">密&nbsp;&nbsp;&nbsp;码：</span>
                </td>
                <td>
                  <input type="password" class="data-text" name="data-password" required>
                </td>
              </tr>
              <tr class="data-line">
                <td>
                  <span id="validate" class="data data-validate">验证码：</span>
                </td>
                <td>
                  <input type="text" class="data-text" name="data-validate" required>
                  <img id="icode" src="http://218.75.197.123:83/CheckCode.aspx?" alt="看不清换一张">
                  <a href="" style="text-decoration:none;color:blue;position:absolute;top:250px;right:90px;">
                    看不清换一张
                  </a>
                </td>
              </tr>
            </table>
            <table class="data-jobs">
              <tbody>
                <tr>
                  <td class="data-td">
                    <input type="radio" name="jobs" value="department">
                    <label for="jobs">部门</label>
                  </td>
                  <td class="data-td">
                    <input type="radio" name="jobs" value="teacher">
                    <label for="jobs">教师</label>
                  </td>
                  <td class="data-td">
                    <input type="radio" name="jobs" value="student">
                    <label for="jobs">学生</label>
                  </td>
                  <td class="data-td">
                    <input type="radio" name="jobs" value="visitor">
                    <label for="jobs">访客</label>
                  </td>
                </tr>
                </table>
                <table>
                <tr>
                  <td>
                    <input class="data-button" type="image" src="images/login_in.gif">
                  </td>
                  <td>
                    <input class="data-button" type="image" src="images/login_res.gif">
                  </td>
                </tr>
              </tbody>
            </table>

          </form>
        </div>
        <div id="footer">
          <p>
            &copy;1999-2012&nbsp;<a href="http://www.zfsoft.com/">正方软件股份有限公司</a>&nbsp;版权所有&nbsp;&nbsp;联系电话：0571-89902828
          </p>
        </div>
      </div>

    </div>
  </body>
</html>
