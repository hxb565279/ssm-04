<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/3
  Time: 17:18
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
</head>
<body>
<div class="shadow1" id="shadow1">
    <form class="shadow-form1"  action="${pageContext.request.contextPath}/update_password1.action" method="post">
        <div class="shadow1-text1">
            <p id="username_check1">账号:${user2.username}</p>
            <p id="id_card_check">该身份证:</p>${user2.id_card}
            <p id="username-check2">查询密码:${user2.password}</p>
            <%--            <h1 id="username-check3" class="username-check3">修改密码</h1>--%>
        </div>
        <div class="shadow1-input1">
            <label >
                账号信息:  <input type="text" name="username" id="shadow-username1" style="height: 30px" placeholder="账号">
            </label>
            <br>
            <br>
            <label >
                修改密码: <input type="password" style="height: 30px" name="password" id="shadow-password1">
            </label>
            <br>
            <br>
            <label>
                确认密码:  <input type="password" style="height: 30px"  name="password1" id="shadow-password2">
            </label>
        </div>

        <div class="shadow1-button1">
            <label ><input type="submit" class="shadow1-input2" value="确认修改"></label>
            <label > <input type="button" class="shadow1-input3" value="取消" onclick="quit()"></label>

        </div>
        <div class="shadow1-href">
            <a href="${pageContext.request.contextPath}/toLogin">登录</a>
            &nbsp; &nbsp;  &nbsp;     &nbsp;
            <a href="${pageContext.request.contextPath}/toRegister">注册</a>

        </div>
    </form>
</div>

</body>
</html>
