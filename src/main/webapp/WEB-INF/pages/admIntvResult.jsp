<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/14
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>面试结果</p>
<c:if test="${!empty requestScope.interviewResult}">
    <p>${requestScope.interviewResult.uName}已经被${requestScope.interviewResult.iResult}了</p>
</c:if>
<c:if test="${!empty requestScope.resume}">
    <form action="/adm/addIntvResult">
    <table>
        <tr>
            <td><input type="text" name="irId" value="0"></td>
            <td><input type="text" name="aName" value="${requestScope.interview.aName}"></td>
            <td><input type="text" name="uName" value="${requestScope.resume.uName}"></td>
            <td><input type="text" name="rId" value="${requestScope.resume.rId}"></td>
            <td><input type="text" name="irCreateTime" value=""></td>
        </tr>
        <tr>
            <!--ajax面试时间与现在时间-->
            <td>面试结果</td>
            <td><input type="text" name="iResult"></td>
        </tr>
    </table>
    </form>
</c:if>
</body>
</html>
