<%@ page import="com.hxb.po.User" %><%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/5
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>主页</title>
    <link rel="stylesheet" href="../css/base.css"/>
    <link rel="stylesheet" href="../css/common1.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
</head>
<body>

<!--快捷导航-->
<form id="form1" >
    <section class="shortcut">
        <div class="w">
            <div class="fl">
                <ul>
                    <li>欢迎你管理员
                    </li>
                    <li>
                        <%
                            User user = (User) session.getAttribute("USER_SESSION");
                        %>
                        <%=user.getUsername()%>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/toLogin">登录</a>
                        <a class="style_read" href="${pageContext.request.contextPath}/toRegister">免费注册</a>
                    </li>
                </ul>
            </div>
            <div class="fr">
                <ul>
                    <li class="arrow-icon"><a href="https://github.com/hxb565279">学习网</a></li>
                    <li></li>
                    <li class="arrow-icon">我的代码</li>
                    <li></li>
                    <li class="arrow-icon">我的命</li>
                    <li></li>
                    <li class="arrow-icon">心理咨询网</li>
                    <li></li>
                    <li class="arrow-icon"><a href="https://www.baidu.com">百度</a></li>
                    <li></li>
                    <li class="arrow-icon">个人资料</li>
                </ul>
            </div>
        </div>
    </section>
    <!--header头部-->
    <header class="header w">
        <!--logo模块-->
        <div class="logo">
            <a href="#" title="购物">购物</a>
        </div>
        <!--搜索框-->
        <div class="search">
            <label ><input type="search" name="" id="" placeholder="语言开发"></label>
            <button>搜索</button>
        </div>
        <!--hot模块-->
        <div class="hotwords">
            <a href="#" class="style_read">办公 </a>
            <a href="#"> 个人中心</a>
            <a href="#">信息管理</a>
            <a href="#"> 商品管理</a>
            <a href="#"> python</a>
            <a href="#"> php</a>
            <a href="#"> math</a>
        </div>

    </header>


</form>
</body>
</html>