<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/18
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <jsp:include   page="empBase.jsp" flush="true"/>
</head>
<body>
<p>查看个人信息</p>
<table>
    <tr>
        <td>姓名</td>
        <td>${requestScope.employee.eName}</td>
        <td>年龄</td>
        <td>${requestScope.employee.eAge}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td>${requestScope.employee.eSex}</td>
        <td>职位</td>
        <td>${requestScope.employee.duty}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${requestScope.employee.eEmail}</td>
        <td>联系方式</td>
        <td>${requestScope.employee.ePhone}</td>
    </tr>
    <tr>
        <td>入职时间</td>
        <td>${requestScope.employee.eCreateTime}</td>
        <td>状态</td>
        <td>${requestScope.employee.eState}</td>
    </tr>
    <tr>
        <td colspan="4"><a href="/emp/gotoEmpPage">返回</a></td>
    </tr>
</table>
</body>
</html>
