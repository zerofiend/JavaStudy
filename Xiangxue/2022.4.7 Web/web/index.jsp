<%--
  Created by IntelliJ IDEA.
  User: ZFiend
  Date: 2022/7/3
  Time: 14:17
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
    <title>$Title$</title>
</head>
<body>
这是一个jsp页面
<%
    int a = 30, b = 30;
    int result = a + b;
%>
<br>
a + b = <%=result%>
<%!
    public int add(int a, int b) {
        return a + b;
    }
%>
计算结果：
<%= add(3, 4) %>
</body>
</html>

