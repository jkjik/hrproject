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
    </style>
</head>
<body>
<div  id="div">
    <p>查看培训通知</p>
    <c:if test="${empty requestScope.createCultivate}">
        <span>暂无培训信息</span>
    </c:if>
    <c:if test="${!empty requestScope.createCultivate}">
        <table border="1px" cellpadding="0px" cellspacing="0px">
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
            <tr><td colspan="3"><a href="/adm/gotoAdmPage">返回</a></td></tr>
        </table>
    </c:if>
</div>
</body>
</html>
