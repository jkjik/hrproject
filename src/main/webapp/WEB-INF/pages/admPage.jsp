<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/13
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <meta charset="utf-8" />
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
</head>
<body>
<a href="/adm/sendInvite">发布招聘</a>
<a href="/adm/lookResume">查看接受简历</a>
<a href="/adm/lookDuty">查看部门</a>
<a href="/adm/employeeManage">员工管理</a>
<a href="/adm/sendCultivate">培训管理</a>
</body>
</html>
