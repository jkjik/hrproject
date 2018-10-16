<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/15
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>面试通知</p>
<table>
    <tr>
        <td>面试时间</td>
        <td>${requestScope.interview.intvTime}</td>
    </tr>
    <tr>
        <td>面试地点</td>
        <td>${requestScope.interview.intvSite}</td>
    </tr>
    <tr>
        <td>负责人员</td>
        <td>${requestScope.interview.intvPeople}</td>
    </tr>
    <tr>
        <td>联系方式</td>
        <td>${requestScope.interview.intvPhone}</td>
    </tr>
    <tr>
        <td colspan="2"><a href="/user/gotoUserPage">返回</a></td>
    </tr>
</table>
</body>
</html>
