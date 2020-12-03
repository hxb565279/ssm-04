<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/11/30
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <link rel="stylesheet" type="text/css" href="../css/login1.css">
        <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"> </script>
    <script>
        //登录，点击登录显示登录框
        $(document).ready(function (){
            $("#login-link").click(function () {
                $("#login-box").show();
                $("#shadow").show();
            });
            //关闭登录框，点击关闭按钮关闭
            $("#close-login-btn").click(function () {
                $("#login-box").hide();
                $("#shadow").hide();
            });
        })


    </script>


</head>
<body>
<input type="button" id="login-link" value="登录">
<form action="${pageContext.request.contextPath}/login.action" method="post">
    <div style="display: none" class="shadow" id="shadow"></div>
    <div style="display: none" id="login-box" class="login-box">
        <div class="close-btn">
            <img src="../images/close.jpg" width="30" height="30" id="close-login-btn" alt="">
        </div>
        <div class="close-btn">
        </div>
        <div class="input-item">
            <label for="username">用户名</label>
            <input type="text" name="username" id="username" placeholder="用户名/邮箱/手机号码">
        </div>
        <div class="input-item">
            <label for="password">密　码</label>
            <input type="password" name="password" id="password" placeholder="密码">
        </div>

        <div class="input-item">
            <button type="submit" id="login-btn">登　录</button>
        </div>
    </div>
</form>
</body>
</html>
