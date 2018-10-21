<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/21
  Time: 12:24
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
<c:if test="${!empty requestScope.wage}">
    <p>上个月工资</p>
    <table>
        <tr>
            <td>员工编号</td>
            <td>基本工资</td>
            <td>效绩工资</td>
            <td>加班工资</td>
            <td>奖惩工资</td>
            <td>社保</td>
            <td>时间</td>
            <td>总计</td>
            <td>复议工资</td>
        </tr>
            <tr>
                <td>${requestScope.wage.eId}</td>
                <td>${requestScope.wage.basic}</td>
                <td>${requestScope.wage.bonus}</td>
                <td>${requestScope.wage.overTime}</td>
                <td>${requestScope.wage.punish}</td>
                <td>${requestScope.wage.social}</td>
                <td>${requestScope.wage.wCreateTime}</td>
                <td>${requestScope.wage.total}</td>
                <td>${requestScope.wage.advice}</td>
            </tr>
    </table>
    <p>工资异议</p>
    <form action="/emp/wageAdvice" method="post">
        <input type="text" placeholder="异议原因" name="waCause">
        <input type="number" placeholder="异议金额" name="adMoney">
        <input type="submit" value="提交">
    </form>
</c:if>
<a href="/emp/gotoEmpPage">返回</a>
</body>
</html>
