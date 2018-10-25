<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/15
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <jsp:include   page="userBase.jsp" flush="true"/>
    <style>
        body{
            background-color: #9acfea;
            position: relative;
        }
        #div{
            width: 50%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
        }
        table{
            width: 600px;
            height: 40px;
        }
        #tr{
            background-color: yellow;
        }
    </style>
</head>
<body>
<div id="div">
    <p>查看简历状态</p>
    <c:if test="${empty requestScope.sendResumes}">
        <p>暂无信息</p>
    </c:if>
    <c:if test="${!empty requestScope.sendResumes}">
        <table border="1px" cellspacing="0px" cellpadding="0px">
            <tr id="tr">
                <td>应聘职位</td>
                <td>投递时间</td>
                <td>是否查看</td>
                <td>是否面试</td>
                <td>查看通知</td>
            </tr>
            <c:forEach items="${requestScope.sendResumes}" var="result">
                <tr>
                    <td>${result.resume.aimDuty}</td>
                    <td>${result.sCreateTime}</td>
                    <td>${result.sStateRead}</td>
                    <td>${result.intvInform}</td>
                    <td><a href="/user/lookInform?rId=${result.resume.rId}">查看通知</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
