<%--
  Created by IntelliJ IDEA.
  User: ZFiend
  Date: 2022/7/10
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //  获取当前工程根目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; //项目url根目录
%>
<html>
<head>
    <base href="<%=basePath%>">
    <%--这个让此工程文件下的路径全都相对于当前工程开始--%>
    <title>$</title>
</head>
<body>
<h3>我的第一个SpringMVC程序</h3>
${uname} <br>
<%--suppress CheckImageSize --%>
<img src="images/01.jpeg" width="780" alt="">
</body>
</html>

