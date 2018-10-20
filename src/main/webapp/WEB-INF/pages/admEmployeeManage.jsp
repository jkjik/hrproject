<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/19
  Time: 13:22
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
    <script>
        $(function () {
            $(".duty").change(function () {
                $(".position").empty();
                var dep=$(this).children('option:selected').val();
                $.ajax({
                    url:"/user/getPosition",
                    type:"post",
                    dataType:"json",
                    data:{"dep":dep},
                    success:function (data) {
                        $.each(data,function (idx,item) {
                            $(".position").append(" <option>" + item.pName + "</option>")
                        })
                    },
                    error:function(error) {
                        alert("error=" + error);
                    }
                })
            })
            getPosition();
        })
        function getPosition() {
            var dep=$("#dep").val()
            $.ajax({
                url:"/user/getPosition",
                type:"post",
                dataType:"json",
                data:{"dep":dep},
                success:function (data) {
                    $.each(data,function (idx,item) {
                        $(".position").append(" <option>" + item.pName + "</option>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<p>员工管理</p>
<c:if test="${!empty requestScope.employees}">
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>部门ID</td>
            <td>职位</td>
            <td>员工的状态</td>
            <td colspan="4">操作</td>
        </tr>
        <c:forEach items="${requestScope.employees}" var="employees">
            <td>${employees.eId}</td>
            <td>${employees.eName}</td>
            <td>${employees.dId}</td>
            <td>${employees.duty}</td>
            <td><a href="/adm/dutyManage?eId=${employees.eId}">人事调动</a></td>
            <td><a href="/adm/">考勤</a></td>
            <td><a href="/adm/addSocialMoney">社保</a></td>
            <td><a href="/adm/">基本工资</a> </td>
            <td><a href="/adm/deleteEmployee?eId=${employees.eId}">开除</a></td>
        </c:forEach>
    </table>
</c:if>
<c:if test="${!empty requestScope.departments}">
    <p>人事调度</p>
    <c:if test="${requestScope.employee.eState==1}">
        <span>在职员工</span>
    </c:if>
    <form action="/adm/commitDuty">
        <select class="duty">
            <c:forEach items="${requestScope.departments}" var="dep">
                <option id="dep" value="${dep.dId}">${dep.dName}</option>
            </c:forEach>
        </select>
        <select name="duty" class="position"></select>
        <input type="hidden" value="${requestScope.employee.eId}" name="eId">
        <input type="hidden" value="${requestScope.employee.dId}" name="dId">
        <input type="submit" value="提交">
    </form>
</c:if>
</body>
</html>
