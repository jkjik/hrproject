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
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <jsp:include   page="userBase.jsp" flush="true"/>
    <style>
        body{
            background-color: #9acfea;
            position: relative;
        }
        .top{
            background-color: yellow;
        }
        #div{
            width: 50%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
        }
        table{
            width: 600px;
            height: 240px;
        }
    </style>
</head>
<body>

    <div id="div" style="width: 50%;align:center;">
        <p>查看招聘信息</p>
            <c:if test="${!empty requestScope.inviteJobs}">
                <table border="1px" cellspacing="0px" cellpadding="0px">
                    <tr class="top">
                        <td>招聘公司</td>
                        <td>招聘职位</td>
                        <td>薪资</td>
                        <td>福利</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach items="${requestScope.inviteJobs}" var="Jobs">
                        <tr>
                            <td><input type="text" value="${Jobs.company}"></td>
                            <td><input type="text" value="${Jobs.job}"></td>
                            <td><input type="text" value="${Jobs.pay}"></td>
                            <td><input type="text" value="${Jobs.welfare}"></td>
                            <td><a href="/user/sendResume">投递</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
    </div>
</body>
</html>
