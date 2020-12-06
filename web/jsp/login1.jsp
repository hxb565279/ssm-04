<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/1
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
<%--    <embed src="../MP3/2.mp3"  autostart="true">--%>
    <link rel="stylesheet" type="text/css" href="../css/login2.css">
    <link rel="stylesheet" href="../css/common.css" type="text/css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/login1.js"></script>
    <script src="../js/login2.js"></script>
</head>
<body>

<div class="section" id="w">
    <div class="login-box-1">
        <form action="${pageContext.request.contextPath}/login.action" method="post" >
            <h1 class="login-text1">登录</h1>
            <div class="login-all" align="center">
                <div class="login-username">
                    <p>${msg_update}</p>
                    <label>
                        账号: <input type="text" style="height: 30px" height="30px" id="username" name="username" placeholder="字母和数字构成,8-16位"/>
                    </label>
                </div>
                <p style="color: red">
                    <span id="message">${msg1}</span>
                <p>
                <br>
                <div class="login-password"><label>
                    密码: <input type="password" style=" height: 30px" id="password" name="password" placeholder="小写字母和数字组成,8-16位"/>
                </label></div>
                <p style="color: red">
                    <span id="message2">${msg2}</span>
                <p>
                <br>
                <div class="radio">权限:
                    <label ><input type="radio" name="status" id="radio1" value="0">管理员</label>
                    <label ><input type="radio" name="status" id="radio2" value="1">普通用户</label>
                </div>
                <br>
<%--                <div class="login-submit1">--%>
                    <label>
               &nbsp;   &nbsp;
                        <input  class="login-input-1" type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%--                </div>--%>

<%--                <div class="login-submit2">--%>
                    <label> <input type="button" value="注册" class="login-input-2"
                                   onclick="window.location.href='${pageContext.request.contextPath}/toRegister'"/>
                    </label>
<%--            </div>--%>
                <br>
                <br>
                <h3><a href="${pageContext.request.contextPath}/toPassword">忘记密码</a></h3>
            </div>
        </form>

    </div>


</div>
</body>
</html>
