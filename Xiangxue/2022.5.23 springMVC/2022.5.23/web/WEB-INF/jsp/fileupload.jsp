<%--
  Created by IntelliJ IDEA.
  User: ZFiend
  Date: 2022/7/11
  Time: 15:59
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
<%--multipart/form-data表示当前提交的是多媒体的数据--%>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="files">
    <input type="submit" name="上传">
</form>
<br>
<a href="download">下载</a>
</body>
</html>

