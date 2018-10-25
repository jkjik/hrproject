<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/19
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8" />
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
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
<div id="div">
    <p>发布培训</p>
    <table border="1px" cellpadding="0px" cellspacing="0px">
        <form action="/adm/commitCultivate">
            <input type="hidden" value="0" name="cId">
            <tr>
                <td>
                    <input type="text" name="cName" placeholder="培训名称"><br>
                </td>
            </tr>
            <tr>
                <td>
                    <select name="cDuty">
                        <c:forEach items="${requestScope.departments}" var="departments">
                            <option>${departments.dName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td> <input type="text" name="cCreateTime" placeholder="培训时间"></td>
            </tr>
            <tr>
                <td align="center"><input type="submit" value="提交"></td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
