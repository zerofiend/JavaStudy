<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //获取当前工程的根目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; //项目url根目录
%>
<html>
<head>
    <base href="<%=basePath%>"> <!--这个让此文件下的路径都相对于当前工程开始-->
    <title>Title</title>
</head>
<body>
<form action="login" id="loginForm">
    用户名：<input type="text" name="uname" id="uname">
    <button type="button" onclick="login()">登录</button>
</form>
<script src="js/user.js" type="text/javascript"></script>
</body>
</html>