<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/19
  Time: 23:05
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
<c:if test="${!empty requestScope.onWorks}">
    <p>查看考勤记录</p>
    <table>
        <tr>
            <td>上班时间</td>
            <td>下班时间</td>
            <td>上班状态</td>
            <td>下班状态</td>
        </tr>
        <c:forEach items="${requestScope.onWorks}" var="onWorks">
            <tr>
                <td>${onWorks.startTime}</td>
                <td>${onWorks.endTime}</td>
                <td>${onWorks.onWorkState}</td>
                <td>${onWorks.offWorkState}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${!empty requestScope.onWorkMonth}">
    <p>查看${requestScope.monthWorkTime}考勤记录</p>
    <table>
        <tr>
            <td>上班时间</td>
            <td>下班时间</td>
            <td>上班状态</td>
            <td>下班状态</td>
        </tr>
        <c:forEach items="${requestScope.onWorkMonth}" var="onWorkMonth">
            <tr>
                <td>${onWorkMonth.startTime}</td>
                <td>${onWorkMonth.endTime}</td>
                <td>${onWorkMonth.onWorkState}</td>
                <td>${onWorkMonth.offWorkState}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${!empty requestScope.punishMonies}">
    <table>
        <tr>
            <td>奖惩</td>
            <td>金额</td>
            <td>时间</td>
        </tr>
        <c:forEach items="${requestScope.punishMonies}" var="punishMonies">
            <tr>
                <td>${punishMonies.cause}</td>
                <td>${punishMonies.puMoney}</td>
                <td>${punishMonies.puCreateTime}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
