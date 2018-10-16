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
<a href="/user/lookJob">查看所有的招聘信息</a><br>
<a href="/user/resume">添加简历</a><br><!--简历只有一份，再次点击添加简历，则跳入修改-->
<a href="/user/resume?uId=${sessionScope.user.uId}">修改简历</a><br>
<%--<a href="/user/sendResume">发送简历</a><br><!--发送简历后给出个反应-->--%>
<a href="/user/lookResumeState?uId=${sessionScope.user.uId}">查看简历的状态</a><br>
</body>
</html>
