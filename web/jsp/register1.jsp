<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/11/30
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="../css/login2.css">
    <link rel="stylesheet" href="../css/common.css" type="text/css">
    <link rel="stylesheet" href="../css/register1.css" type="text/css">

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script><script src="../js/register1.js"></script>
    <script>
        function check() {
            let password = $("#password1").val();
            let re_password = $("#re_password1").val();
            if (password===re_password){
                return true;
            }
           alert("两次密码不对,两次密码应该一致");
            return false;
        }

    </script>
</head>
<body>
<div class="section">
    <div class="login-box-1">
        <form action="${pageContext.request.contextPath}/register.action" method="post"  onsubmit="return check()">
            <h1 class="login-text1">注册</h1>
            <div class="login-all" align="center">
                <div class="login-username">
                    <label>
                        账号: <input type="text" style="height: 30px" height="30px" id="username1" name="username" placeholder="字母加数字组成">
                    </label>
                </div>
                <p>${msg2}</p>
                <p id="message"></p>
                <div class="login-password"><label>
                    密码:  <input type="password" style=" height: 30px" id="password1" name="password">
                </label></div>
                <br>
                <div class="login-password"><label>
                    密码:  <input type="password" style=" height: 30px" id="re_password1" name="re_password">
                </label></div>
                <br>
<%--                <div class="login-submit1">--%>
                    <label>
                    &nbsp;   &nbsp; <input class="login-input-3" type="submit" value="注册" ></label>
<%--                </div>--%>
<%--                    <div class="login-submit2">--%>
                 <label>   <input type="button" class="login-input-4" value="登录"  onclick="window.location.href='${pageContext.request.contextPath}/toLogin'" >
                </label>
<%--            </div>--%>




            </div>

        </form>

    </div>


</div>
</body>
</html>
