<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/19
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8" />
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
</head>
<body>
<p>发布培训</p>
<form action="/adm/commitCultivate">
    <input type="hidden" value="0" name="cId">
    <input type="text" name="cName" placeholder="培训名称"><br>
    <select name="cDuty">
        <c:forEach items="${requestScope.departments}" var="departments">
            <option>${departments.dName}</option>
        </c:forEach>
    </select><br>
    <input type="text" name="cCreateTime" placeholder="培训时间"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
