<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/12
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContextrequestcontext}/">
    <title>游客页面</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
</head>
<body>
<a href="/user/Resume">添加简历</a>
<a href="/user/Resume?uId=${sessionScope.user.uId}">修改简历</a>
</body>
</html>
