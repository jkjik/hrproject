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
    <title>跳转登录</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <style>
        body{
            background-image: url(/images/pic.jpg);
        }
        div{
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
            height: 240px;
            width: 60%;
        }
    </style>
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
<div>
    <h1>恭喜你,注册成功<a href="/login.jsp">返回登录</a></h1>
    <h1>3秒后自动跳转.........</h1>
</div>

</body>
</html>
