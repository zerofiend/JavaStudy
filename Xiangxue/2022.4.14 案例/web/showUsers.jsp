<%--
  Created by IntelliJ IDEA.
  User: ZFiend
  Date: 2022/7/4
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath(); //  获取当前工程根目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; //项目url根目录
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>网站信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 所有用户信息</strong></div>
    <table class="table table-hover text-center">
        <tr>
            <th width="5%">ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th width="250">操作</th>
        </tr>

        <c:forEach items="${t_users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.uname}</td>
                <td>${u.pwd}</td>
                <td>
                    <div class="button-group">
                        <a type="button" class="button border-main" href="#"><span class="icon-edit"></span>修改</a>
                        <a class="button border-red" onclick="del(${u.id})"><span
                                class="icon-trash-o"></span> 删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<script>
    function del(id) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = 'deleteUser?id=' + id;
        } else {
            window.location.href = 'ShowUsers';
        }
    }
</script>
</body>
</html>