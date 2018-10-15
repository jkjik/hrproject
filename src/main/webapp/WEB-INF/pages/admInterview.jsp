<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>面试通知</p>
<c:if test="${!empty requestScope.resume}">
    <form action="/adm/interviewInform" method="post">
        <table>
            <tr>
                <td><input type="hidden" name="iId" value="0"></td>
                <td><input type="hidden" name="rId" value="${requestScope.resume.rId}"></td>
                <td><input type="hidden" name="rId" value="${requestScope.resume.uId}"></td>
            </tr>
            <tr>
                <td>面试时间</td>
                <td><input type="text" name="intvTime"></td>
            </tr>
            <tr>
                <td>面试地点</td>
                <td><input type="text" name="intvSite"></td>
            </tr>
            <tr>
                <td>负责人员</td>
                <!--ajax判断是不是公司人员-->
                <td><input type="text" name="intvPeople"></td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td><input type="text" name="intvPhone"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>
