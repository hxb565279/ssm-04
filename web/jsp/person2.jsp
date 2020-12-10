<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/10
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息管理</title>
</head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
</script>
<script src="../js/person2.js"></script>
<link rel="stylesheet" href="../css/person2.css">

<body>
<div id="box">
    <div class="header">
        <div class="h_top">
            <div class="topCon mian clearFixed">
                <div class="conLeft fl">
                    <div class="leftTxt1 fl">
                        <a href="" class="logo">个人</a>
                        <a href="" class="city">全国站</a>
                        <a href="" class="city1">[切换城市]</a>
                    </div>
                    <ul class="ulList clearFixed fl">
                        <li><a href="#">页</a></li>
                        <li><a href="#">青岛</a></li>
                        <li><a href="#">校园</a></li>
                        <li><a href="#">言</a></li>
                        <li><a href="#">课程</a></li>
                    </ul>
                </div>
                <div class="conRight fr">
                    <ul class="ulList clearFixed">
                        <li><a href="" class="login btn"><span></span>登录</a></li>
                        <li><a href="" class="login2"><span>|</span>注册</a></li>
                        <li><a href="" class="btn app"><span></span>APP</a></li>
                        <li><a href="#" target="_blank">进入企业</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <button id="add"  class="btn2" >添加 </button>
        <div class="h_bottom">

            <form action="${pageContext.request.contextPath}/selectCustomer2" class="form3" id="form3">
                <label>
                  姓名:  <input type="text" name="username"  class="input22">
                </label>
                &nbsp;    &nbsp;    &nbsp;
                <label>
                    职业可选项:  <select class="option">
                         <c:forEach var="customer" items="${customer}">
                             <option    >${customer.value.jobs}</option>
                        </c:forEach>
                    </select>
                   职业: <input type="text" name="jobs" class="input22">
                </label>
                &nbsp;    &nbsp;    &nbsp;
                <label>
                   电话: <input type="text" name="phone" class="input22">
                </label>
                &nbsp;    &nbsp;    &nbsp;
                    <input type="submit"  class="select-input-1" value="查询">
            </form>
        </div>
    </div>
    <div class="content">
        <table border="1">
            <tr class="head1">
                <td>编号</td>
                <td>名称</td>
                <td>职业</td>
                <td>电话</td>
            </tr>
            <c:forEach items="${customer}" var="customer">
                <tr>
                    <td><input type="text" name="id" value="${customer.value.id}"/></td>
                    <td><input type="text" name="username" value="${customer.value.username}"/></td>
                    <td><input type="text" name="jobs" value="${customer.value.jobs}"/></td>
                    <td><input type="text" name="phone" value="${customer.value.phone}"/></td>
                    <td><a href="#" onclick="deleteCustomerById(${customer.value.id})">删除</a></td>
                    <td><a class="btn1" href="#" onclick="updateCustomer(${customer.value.id})">修改客户信息</a></td>
                </tr>
            </c:forEach>
        </table>

        <div class="content1">
            <!-- 弹出窗口 -->
            <form class="form1" id="form1">
                <h3>添加客户信息</h3>
                <div class="item">
                    <p class="fl">id</p>
                    <input class="fr" type="text" name="id" id="add_id"/>
                </div>
                <div class="item">
                    <p class="fl">姓名</p>
                    <input class="fr" type="text" name="username" id="add_username"/>
                </div>
                <div class="item">
                    <p class="fl">职业</p>
                    <input class="fr" type="text" id="add_jobs" name="jobs"/>
                </div>
                <div class="item">
                    <p class="fl">电话</p>
                    <input class="fr" type="text" id="add_phone" name="phone"/>
                </div>
                <div class="anniu">
                    <button class="fr baocun" type="submit" onclick="createCustomer()">保存添加信息</button>
                    <button class="fr guanbi" id="guanbi1">关闭</button>
                </div>
            </form>


        </div>


        <div class="content2">
            <!-- 弹出窗口 -->
            <form class="form" id="form">
                <h3>修改客户信息</h3>
                <div class="item">
                    <p class="fl">id</p>
                    <input class="fr" type="text" name="id" id="ed_id"/>
                </div>
                <div class="item">
                    <p class="fl">姓名</p>
                    <input class="fr" type="text" name="username" id="ed_username"/>
                </div>
                <div class="item">
                    <p class="fl">职业</p>
                    <input class="fr" type="text" id="ed_jobs" name="jobs"/>
                </div>
                <div class="item">
                    <p class="fl">电话</p>
                    <input class="fr" type="text" id="ed_phone" name="phone"/>
                </div>
                <div class="anniu">
                    <button class="fr baocun" type="submit" onclick="updateCustomer1()">保存修改</button>
                    <button class="fr guanbi" id="guanbi">关闭</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    /**
     * 删除
     */
    function deleteCustomerById(id) {
        $.ajax({
                type: "post",
                url: "deleteCustomer",
                data: {"id": id},
                success(data) {
                    if (data === "OK") {
                        alert("客户删除成功");
                        window.location.reload();
                    } else {
                        alert("客户删除失败");
                        window.location.reload();
                    }
                }

            }
        )
    }
    //根据ID显示数据
    function updateCustomer(id) {
        $.ajax({
            type: "get",
            url: "/getCustomer",
            data: {"id":id},
            success: function (data) {
                $("#ed_id").val(data.id);
                $("#ed_username").val(data.username);
                $("#ed_jobs").val(data.jobs);
                $("#ed_phone").val(data.phone);

            }

        })
    }
    /**
     * 添加
     */
    function createCustomer() {
        $.post("addCustomer", $("#form1").serialize(), function (data) {
            if (data === "OK") {
                alert("客户创建成功");
                window.location.reload();
            } else {
                alert("客户创建失败");
                window.location.reload();
            }
        })
    }
    // 执行修改客户操作
    function updateCustomer1() {
        $.post("updateCustomer1", $("#form").serialize(), function (data) {
            if (data === "OK") {
                alert("客户信息更新成功！");
                window.location.reload();
            } else {
                alert("客户信息更新失败！");
                window.location.reload();
            }
        });
    }


    //btn1点击事件，弹出窗口
    $(".btn1").click(function () {
        $("#form").show();
    });
    //关闭按钮点击事件，隐藏窗口，显示修改客户信息按钮
    $("#guanbi").click(function () {
        $("#form").hidden;
        window.location.reload();

    });

    //btn2点击事件，弹出窗口
    $(".btn2").click(function () {
        // $(".form").style.display = "block"//显示弹窗
        $("#form1").show();
    });
    //关闭按钮点击事件，隐藏窗口，显示修改客户信息按钮
    $("#guanbi1").click(function () {
        // $(".form").style.display = "none"//显示弹窗
        $("#form1").hidden;
    });
</script>
</body>
</html>
