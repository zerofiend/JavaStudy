<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //获取当前工程的根目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; //项目url根目录
%>
<html>
<head>
    <base href="<%=basePath%>"> <!--这个让此文件下的路径都相对于当前工程开始-->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="renderer" content="webkit">
        <title></title>
        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
    </head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="addUser">
            <div class="form-group">
                <div class="label">
                    <label for="sitename">用户名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" id="uname" name="username" size="50" placeholder="请输入用户名" data-validate="required:请输入用户名" />
                    <span id="uspan"></span>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="sitename">密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" id="pwd" name="password" size="50" placeholder="请输入密码" data-validate="required:请输入密码" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body></html>