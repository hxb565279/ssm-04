<%--
  Created by IntelliJ IDEA.
  User: 和学博
  Date: 2020/12/12
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加管理</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/vue/2.2.2/vue.min.js"></script>
    <link rel="stylesheet" href="../css/addManager.css">
    <style>
        input{
            height: 35px;
            outline: none;
        }
        input:focus{
            outline: none;
        }
        .main4{
            position: absolute;
            left: 3%;
            outline: none;
        }
        .main4-td{
            background-color: #017ebc;
        }
    </style>

</head>
<body>
<div>
    <table>
        <form action="/selectManager">
            用户: <input type="text" id="username" name="username">
            身份证: <input type="text" id="id_card" name="id_card">
            <label ><input type="radio" name="status" id="radio1" value="0">管理员</label>
            <label ><input type="radio" name="status" id="radio2" value="1">普通用户</label>
            <input type="submit" value="查询">
        </form>
        <br>
    </table>
    <br>
    <table  class="main4">
        <tr >
            <td class="main4-td">id</td>
            <td class="main4-td">用户名</td>
            <td class="main4-td">管理</td>
        </tr>
        <c:forEach items="${user}" var="user">
            <tr>
                <td><input type="text" name="id" value="${user.value.id}"/></td>
                <td><input type="text" name="username" value="${user.value.username}"/></td>
                <td><input type="text" name="status" value=" ${user.value.status}"></td>
                    <td><a href="#"  onclick="addManager('${user.value.id}','${user.value.status}')">
                        <c:set var="status" value="${user.value.status}"/>
                        <c:if test="${status== '管理员'}" >
                            取消管理权限
                        </c:if>
                         <c:if test="${status=='普通用户'}">
                             设为管理权限
                         </c:if>
                </a>
                    </td>
            </tr>
        </c:forEach>

    </table>
</div>
<script>
    new Vue(
        {
            el:'#app',
            data:{

            }
        }

    )
    function check(status) {
        if (status == 1) {
            return "设为管理员";
        } else if (status == 0) {
            return "已经是管理";
        } else {
  return "";
        }
    }
    //
    function addManager(id,status){
              $.ajax(
                  {
                      type: "post",
                      url:  "/manager1",
                      data: {"id": id,"status":status},
                      success(data) {
                          if (data === "OK") {
                              alert("管理修改成功");
                              window.location.reload();
                          }else{
                              alert("管理修改失败");
                              window.location.reload();
                          }
                      }
                  }
              )
    }
</script>
</body>
</html>
