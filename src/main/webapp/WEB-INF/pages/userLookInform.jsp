<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/15
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <jsp:include   page="userBase.jsp" flush="true"/>
    <script>
        $(function () {
            $("table td:odd").css("background","yellow")
        })
    </script>
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
            align-text:center;
        }
    </style>
</head>
<body>
<div id="div" style="width: 50%;align:center;">
    <p>面试通知</p>
    <c:if test="${empty requestScope.interview}">
        <p>暂无面试信息</p>
    </c:if>
    <c:if test="${!empty requestScope.interview}">
        <table border="1px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td>面试时间</td>
                <td>${requestScope.interview.intvTime}</td>
            </tr>
            <tr>
                <td>面试地点</td>
                <td>${requestScope.interview.intvSite}</td>
            </tr>
            <tr>
                <td>负责人员</td>
                <td>${requestScope.interview.intvPeople}</td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td>${requestScope.interview.intvPhone}</td>
            </tr>
            <tr align="center">
                <td colspan="2"><a href="/user/gotoUserPage">返回</a></td>
            </tr>
        </table>
    </c:if>
</div>
</body>
</html>
