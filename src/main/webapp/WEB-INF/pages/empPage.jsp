<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/16
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工页面</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <jsp:include   page="empBase.jsp" flush="true"/>
</head>
<body>
<a href="/emp/lookDuty">查看部门</a><br>
<a href="/emp/lookingYourself">查看个人信息</a>
</body>
</html>
