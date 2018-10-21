<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/21
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
</head>
<body>
<c:if test="${!empty requestScope.wageAdvises}">
    <p>工资复议</p>
    <form action="/adm/commitWageAdvice" method="post">
    <table>
        <tr>
            <td>员工编号</td>
            <td>复议原因</td>
            <td>复议金额</td>
            <td>创建时间</td>
            <td colspan="2">结果</td>
        </tr>
        <c:forEach items="${requestScope.wageAdvises}" var="wageAdvises">
            <tr>
                <td>${wageAdvises.eId}</td>
                <td>${wageAdvises.waResult}</td>
                <td>${wageAdvises.adMoney}</td>
                <td>${wageAdvises.waCreateTime}</td>
                <td>
                    <input type="hidden" value="${wageAdvises.eId}" name="eId">
                    <input type="radio" checked="checked" name="waResult" value="同意"/>同意
                    <input type="radio" name="waResult" value="驳回"/>驳回
                </td>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
</c:if>

<c:if test="${!empty requestScope.wageAdvises1}">
    <table>
        <tr>
            <td>员工编号</td>
            <td>复议原因</td>
            <td>复议金额</td>
            <td>创建时间</td>
            <td>复议结果</td>
        </tr>
        <c:forEach items="${requestScope.wageAdvises1}" var="wageAdvises1">
            <tr>
                <td>${wageAdvises1.eId}</td>
                <td>${wageAdvises1.waResult}</td>
                <td>${wageAdvises1.adMoney}</td>
                <td>${wageAdvises1.waCreateTime}</td>
                <td>${wageAdvises1.waResult}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="/adm/gotoAdmPage">返回</a>
</body>
</html>
