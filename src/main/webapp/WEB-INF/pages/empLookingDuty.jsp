<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/18
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看部门</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <jsp:include   page="empBase.jsp" flush="true"/>
    <script>

    </script>
</head>
<body>
<p>查看部门</p>
<table>
    <c:forEach items="${requestScope.departments}" var="dep">
        <tr>
            <td>
                <a href="/emp/getPosition?dId=${dep.dId}">${dep.dName}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${!empty requestScope.positions}">
    <p>查看职位</p>
    <table>
        <c:forEach items="${requestScope.positions}" var="position">
            <tr>
                <td>${position.pName}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${!empty requestScope.employees}">
    <p>查看本部门员工</p>
    <table>
        <tr>
            <td>职位</td>
            <td>员工</td>
        </tr>
        <c:forEach items="${requestScope.employees}" var="employees">
            <tr>
                <td>${employees.duty}</td>
                <td>${employees.eName}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
