<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/9
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    function check1(){
        let username=  document.getElementById('username').value;
        let password= document.getElementById('password').value;
        if (username==="admin"&&password==="123"){
            alert("登录成功")
            return true;
        }
        else{
            alert("登录失败")
            return false;
        }

    }
</script>
<a href="${pageContext.request.contextPath}/toIndex">测试</a>
<a href="${pageContext.request.contextPath}/toCustomer">顾客信息</a>
<form  action="${pageContext.request.contextPath}/selectAllCustomer"  method="post" >
    <label >
        账号: <input type="text" id="username" name="username">
    </label><label >
    密码:<input type="password" id="password" name="password">
</label>
    <label ><input type="submit" value="登录" onclick="return check1()"></label>

</form>
</body>
</html>
