<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/19
  Time: 14:33
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
<p>查看培训通知</p>
<c:if test="${empty requestScope.createCultivate}">
    <span>暂无培训信息</span>
</c:if>
<c:if test="${!empty requestScope.createCultivate}">
    <table>
        <tr>
            <td>培训名称</td>
            <td>培训部门</td>
            <td>培训时间</td>
        </tr>
        <c:forEach items="${requestScope.createCultivate}" var="createCultivate">
            <tr>
                <td>${createCultivate.cName}</td>
                <td>${createCultivate.cDuty}</td>
                <td>${createCultivate.cCreateTime}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
