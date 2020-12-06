<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/1
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script src=" https://cdn.staticfile.org/vue/2.2.2/vue.min.js"></script>
    <script src="../js/shadow.js"></script>
    <script src="../js/password.js" type="text/javascript"></script>
    <script src="../js/Captcha.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../css/login2.css">
    <link rel="stylesheet" href="../css/common.css" type="text/css">
    <link rel="stylesheet" href="../css/shadow.css" type="text/css">

    <script>

    </script>
</head>
<body onload="show(); ">

<%--  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;<div class="shadow1" id="shadow1">--%>
<%--    <form class="shadow-form1"  action="${pageContext.request.contextPath}/update_password1.action" method="post">--%>
<%--        <div class="shadow1-text1">--%>
<%--            <p id="username_check1">查找账号:${user.username}</p>--%>
<%--            <p id="username-check2">查询密码:${user.password}</p>--%>
<%--&lt;%&ndash;            <h1 id="username-check3" class="username-check3">修改密码</h1>&ndash;%&gt;--%>
<%--        </div>--%>
<%--          <div class="shadow1-input1">--%>
<%--              <label >--%>
<%--                账号信息:  <input type="text" name="username" id="shadow-username1" style="height: 30px">--%>
<%--              </label>--%>
<%--              <br>--%>
<%--              <br>--%>
<%--              <label >--%>
<%--                 修改密码: <input type="password" style="height: 30px" name="password" id="shadow-password1">--%>
<%--              </label>--%>
<%--              <br>--%>
<%--              <br>--%>
<%--              <label>--%>
<%--                确认密码:  <input type="password" style="height: 30px"  name="password1" id="shadow-password2">--%>
<%--              </label>--%>
<%--          </div>--%>

<%--         <div class="shadow1-button1">--%>
<%--             <label ><input type="submit" class="shadow1-input2" value="确认修改"></label>--%>
<%--             <label > <input type="button" class="shadow1-input3" value="取消" onclick="quit()"></label>--%>
<%--         </div>--%>
<%--    </form>--%>
<%--</div>--%>




<div class="section" >
    <div class="login-box-1">
        <form action="${pageContext.request.contextPath}/checkUser2.action" method="post" >
            <h1 class="login-text2">找回密码</h1>
            <div class="login-all" align="center">
                <div class="login-username">
                    <label>
                      你的账号: <input type="text" style="height: 30px" height="30px" id="username" name="username" />
                    </label>
                </div>
<%--                <p style="color: #4bc0c8"><scan id="text"><%=session["PASSWORD_SESSION"]%></scan></p>--%>
                <p style="color: red">
                    <span id="message"></span>
                <p>
                <label >
                    <br>
                  &nbsp;&nbsp; 身份证:  <input type="text" style="height: 30px" id="ID_Card" name="id_card">
                </label>
                <br>

                <br>
                <label >
                    &nbsp;&nbsp;&nbsp;验证码: <input type="text" style="height: 30px" id="captcha" name="captcha">
                </label>
                <br>
                <br>
                <scan id="Captcha"></scan>
                <input type="button" value="刷新二维码" onclick="show()">
                <br>
                <br>
<%--                <div class="login-submit1">--%>
                <label>
                <input type="submit" value="找回密码" class="login-input-1" onclick="return check()"/>&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%--            </div>--%>
                <br><br>
<%--                <div class="login-submit2">--%>
                    <label> <input type="button" value="注册" class="login-input-2"
                                   onclick="window.location.href='${pageContext.request.contextPath}/toRegister'"/>
                    </label>
<%--            </div>--%>
            </div>
        </form>

    </div>


</div>
</body>
</html>
