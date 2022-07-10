<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>$Title$</title>
    <script src="js/jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $("#but").click(function () {
                $.get(
                    "login6",
                    {
                        "name": "赵云",
                        "age": "20"
                    },
                    function (data) {
                        eval("var json=" + data);
                        alert(json.name + "-" + json.age);
                    }
                )
            })
        })
    </script>
</head>
<body>
<H3>用户提交数据</H3>
<form action="login2" method="post">
    用户名:<input type="text" name="uname"/><br/>
    密码:<input type="password" name="pwd"/><br/>
    性别:
    男<input type="radio" name="sex" value="男">
    女<input type="radio" name="sex" value="女"><br/>
    爱好:<br/>
    看书<input type="checkbox" value="1" name="favor"/>
    画画<input type="checkbox" value="2" name="favor"/>
    写字<input type="checkbox" value="3" name="favor"/>
    <br/>
    生日:<input type="date" name="birthday"/>
    <input type="submit" value="提交"/>
</form>
<a href="login5/zhangsan/123">超链接restful风格携带数据请求</a>
<button type="submit" id="but">ajax请求</button>
</body>
</html>
