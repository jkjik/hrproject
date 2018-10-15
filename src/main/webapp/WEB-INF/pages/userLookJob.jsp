<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/14
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>查看招聘信息</p>
<c:if test="${!empty requestScope.inviteJobs}">
    <table>
            <c:forEach items="${requestScope.inviteJobs}" var="Jobs">
                <tr>
                    <td>招聘公司</td>
                    <td><input type="text" value="${Jobs.company}"></td>
                </tr>
                <tr>
                    <td>招聘职位</td>
                    <td><input type="text" value="${Jobs.job}"></td>
                </tr>
                <tr>
                    <td>薪资</td>
                    <td><input type="text" value="${Jobs.pay}"></td>
                </tr>
                <tr>
                    <td>福利</td>
                    <td><input type="text" value="${Jobs.welfare}"></td>
                </tr>
                <tr>
                    <td>操作</td>
                    <td><a href="/user/sendResume">投递</a></td>
                </tr>
            </c:forEach>
    </table>
</c:if>
</body>
</html>
