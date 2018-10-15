<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/14
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理查看简历</title>
</head>
<body>
<p>简历信息</p>
<c:if test="${empty requestScope.massageResumes}">
    <p>暂无简历</p>
</c:if>
<c:if test="${!empty requestScope.massageResumes}">
    <table>
        <tr>
            <td>序号</td>
            <td>应聘者</td>
            <td>投递时间</td>
            <td>查看状态</td>
            <td>面试状态</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.massageResumes}" var="masResume">
            <td>${masResume.resume.rId}</td>
            <td>${masResume.resume.rName}</td>
            <td>${masResume.mCreateTime}</td>
            <td>${masResume.stateRead}</td>
            <td>${masResume.stateInterview}</td>
            <td><a href="/adm/lookingResume?rId=${masResume.resume.rId}">查看</a></td>
            <td><a href="/adm/deleteMasResume?rId=${masResume.resume.rId}">删除</a></td>
        </c:forEach>
        <tr>

        </tr>
    </table>
</c:if>

</body>
</html>
