<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/10
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学习网</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script src="../js/script-head.js"></script>
    <script src="../js/index-js1.js"></script>
    <script src="../js/index.js"></script>
    <link rel="stylesheet" href="../css/index-css1.css"/>
    <link rel="stylesheet" href="../css/index2.css">
    <link rel="stylesheet" href="../css/style-head.css">
</head>
<style>
    body{
        background-color: #F0DAD2;
    }
</style>
<body>

<div class="menuHolder">
    <div class="menuWindow">
        <ul class="p1">
            <li class="s1"><a href="#">导航菜单</a>
                <ul id="p2" class="p2">
                    <li class="s2"><a href="#"><span>个人管理</span></a>
                        <ul class="p3 a3">
                            <li><a  href="${pageContext.request.contextPath}/toPerson1" target="mainframe" >个人信息</a></li>
                            <li><a   href="${pageContext.request.contextPath}/selectCustomer1" target="mainframe" >管理</a></li>
                            <li><a  href="${pageContext.request.contextPath}/toPerson3" target="mainframe" >个人空间</a></li>
                        </ul>
                    </li>
                    <li class="s2"><a href="#" ><span>图书管理</span></a>
                        <ul class="p3 a3">
                            <li><a href="javascript:;" target="mainframe"></a></li>
                            <li><a href="javascript:;" target="mainframe">编辑</a></li>
                            <li><a href="javascript:;" target="mainframe">保管</a></li>
                        </ul>
                    </li>
                    <li class="s2"><a href="javascript:;"><span>微信公众号监测</span></a>
                        <ul class="p3 a6">
                            <li><a href="javascript:;" target="mainframe">支持</a></li>
                            <li><a href="javascript:;" target="mainframe">销售</a></li>
                            <li><a href="javascript:;" target="mainframe" >购买</a></li>
                            <li><a href="javascript:;"  target="mainframe">摄影师</a></li>
                            <li><a href="javascript:;" target="mainframe">零售商</a></li>
                            <li><a href="javascript:;" target="mainframe">常规</a></li>
                        </ul>
                    </li>
                    <li class="s2"><a href="javascript:;"><span>信息安全风险监测</span></a>
                        <ul class="p3 a3">
                            <li><a href="javascript:;" target="mainframe">南区</a></li>
                            <li><a href="javascript:;" target="mainframe">北区</a></li>
                            <li><a href="javascript:;" target="mainframe">中心区</a></li>
                        </ul>
                    </li>
                    <li class="s2"><a href="javascript:;"><span>协同联动</span></a>
                        <ul class="p3 a3">
                            <li><a href="javascript:;" target="mainframe">邮箱</a></li>
                            <li><a href="javascript:;" target="mainframe">邮递</a></li>
                            <li><a href="javascript:;" target="mainframe">电话</a></li>
                        </ul>
                    </li>
                    <li class="s2 "><a href="javascript:;"><span>综合管理</span></a>
                        <ul class="p3 a5">
                            <li><a href="javascript:;" target="mainframe">数码单反机身</a></li>
                            <li><a href="javascript:;" target="mainframe">镜头</a></li>
                            <li><a href="javascript:;" target="mainframe">闪光枪</a></li>
                            <li><a href="javascript:;"target="mainframe" >三角架</a></li>
                            <li><a href="javascript:;" target="mainframe">过滤器</a></li>
                        </ul>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
</div>

<div >
    <iframe  id="frame_main" name="mainframe" frameborder="0"></iframe>
</div>


</body>
</html>
