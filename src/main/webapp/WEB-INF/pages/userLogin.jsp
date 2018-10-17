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
            background-image: url(${pageContext.request.contextPath}/images/pic.jpg);
        }
        h2{
            align-content: center;
            
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
<h2>恭喜你,注册成功<a href="/login.jsp">返回登录</a></h2>
<h2>3秒后自动跳转.........</h2>
</body>
</html>
