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
    <title>面试结果</title>
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
</head>
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
<script>
 /*   $(function () {
        $("form").submit(function () {
            var rId=$("#rId").val()
            alert(rId)
            $.ajax({
                url:"/adm/resultTime",
                typa:"post",
                dataType:"text",
                data:{"rId":rId},
                succeaa:function (data) {

                }
            })
        })
    })*/
</script>
<body>
<div id="div">
    <p>面试结果</p>
    <c:if test="${!empty requestScope.interviewResult}">
        <p>${requestScope.interviewResult.uName}已经被${requestScope.interviewResult.iResult}了</p>
    </c:if>

    <c:if test="${!empty requestScope.resume}">
        <form action="/adm/addIntvResult">
        <table border="1px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td><input type="hidden" name="irId" value="0"></td>
                <td><input type="hidden" name="aName" value="${requestScope.interview.intvPeople}"></td>
                <td><input type="hidden" name="uName" value="${requestScope.resume.rName}"></td>
                <td><input type="hidden" name="rId" value="${requestScope.resume.rId}" id="rId"></td>
                <td><input type="hidden" name="irCreateTime" value="null"></td>
            </tr>
            <tr>
                <td>面试结果</td>
            <tr>
                <td>
                    <input type="radio" name="iResult" value="录用" checked="checked">录用
                    <input type="radio" name="iResult" value="拒绝">拒绝
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
        </form>
    </c:if>
</div>
</body>
</html>
