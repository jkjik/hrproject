<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/11
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContextrequestcontext}/">
    <title>跳转登录</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function(){
            onload=function(){
                setTimeout(go, 3000);
            };
            function go(){
                location.href="/login.jsp";
            }
        })
    </script>
</head>
<body>
<p>恭喜你,注册成功<a href="/login.jsp">返回登录</a></p>
<p>3秒后自动跳转.........</p>

</body>
</html>
