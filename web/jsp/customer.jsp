<%@ page import="com.hxb.po.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/7
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户信息</title>
</head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="../js/customer.js"></script>
<%--<script  type="text/css"    src="${pageContext.request.contextPath}/css/customer.css"></script>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer.js"></script>--%>
<style>
    * {
        padding: 0;
        margin: 0;
    }

    .content {
        width: 500px;
        height: 600px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        overflow: hidden;
        margin: 0 auto;
    }

    .content1 {
        width: 500px;
        height: 600px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        overflow: hidden;
        margin: 0 auto;
    }

    .form {
        display: none;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translateX(-50%) translateY(-50%);
        width: 500px;
        height: auto;
        border: 1px solid #333333;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px 20px;
        border-radius: 5px;
    }

    .form1 {
        display: none;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translateX(-50%) translateY(-50%);
        width: 500px;
        height: auto;
        border: 1px solid #333333;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px 20px;
        border-radius: 5px;
    }

    .form h3 {
        font-size: 18px;
    }

    .form .item {
        width: 100%;
        height: 30px;
        line-height: 30px;
        margin: 20px 0;
        font-size: 14px;
        color: #333333;
        font-weight: bold;
    }

    .form .item input, .form .item select {
        width: 380px;
        height: 30px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 0 10px;
        border-radius: 3px;
        border: 1px solid #BBBBBB;
    }

    .form .anniu {
        width: 100%;
        height: 30px;
    }

    .form .anniu button {
        margin-left: 10px;
        height: 30px;
        line-height: 30px;
        padding: 0 10px;
        font-size: 14px;
        background-color: #009688;
        color: #fff;
        white-space: nowrap;
        text-align: center;
        border: none;
        border-radius: 2px;
        cursor: pointer;
        text-decoration: none;
    }

    .form .anniu .guanbi {
        background-color: #FFFFFF;
        color: #BBBBBB;
        border: 1px solid #BBBBBB;
    }

    .form1 h3 {
        font-size: 18px;
    }

    .form1 .item {
        width: 100%;
        height: 30px;
        line-height: 30px;
        margin: 20px 0;
        font-size: 14px;
        color: #333333;
        font-weight: bold;
    }

    .form1 .item input, .form1 .item select {
        width: 380px;
        height: 30px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 0 10px;
        border-radius: 3px;
        border: 1px solid #BBBBBB;
    }

    .form1 .anniu {
        width: 100%;
        height: 30px;
    }

    .form1 .anniu button {
        margin-left: 10px;
        height: 30px;
        line-height: 30px;
        padding: 0 10px;
        font-size: 14px;
        background-color: #009688;
        color: #fff;
        white-space: nowrap;
        text-align: center;
        border: none;
        border-radius: 2px;
        cursor: pointer;
        text-decoration: none;
    }

    .form1 .anniu .guanbi {
        background-color: #FFFFFF;
        color: #BBBBBB;
        border: 1px solid #BBBBBB;
    }

    .fl {
        float: left;
    }

    .fr {
        float: right;
    }
</style>

<body>
<p><a href="${pageContext.request.contextPath}/selectAllCustomer">${msg}</a></p>
<p><a href="${pageContext.request.contextPath}/selectAllCustomer">${msg1}</a></p>
<p>
    <button class="btn2" id="btn2">添加信息</button>
</p>
<br>
<table>
    <form action="${pageContext.request.contextPath}/selectCustomer" class="form3" id="form3">
        名称: <input type="text" id="username2" name="username">
        职业: <input type="text" id="jobs2" name="jobs">
        电话:<input type="text" id="phone2" name="phone">
        <input type="submit" value="查询" >
    </form>
    <br>
</table>
<table border="1">
    <tr>
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


<div class="content">
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
<script>


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

    // //查询
    // function selectCustomer(){
    //     $.post("selectCustomer",$("#form3").serialize(),function (data){
    //         if (data!=null){
    //             alert("客户查询成功");
    //             window.location.reload();
    //         }else{
    //             alert("客户查询为空");
    //             window.location.reload();
    //         }
    //     })
    // }

</script>
</body>
</html>
