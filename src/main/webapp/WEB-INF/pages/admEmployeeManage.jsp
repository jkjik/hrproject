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
            //发送工资时间判断
            $("#sendWage").click(function () {
                var eId=$(this).parent().parent().children()[0].innerHTML;
                alert(eId)
                $.ajax({
                    url:"/adm/sendWageTime",
                    type:"post",
                    dateType:"int",
                    date:{"eId":eId},
                    success:function (date) {
                        alert(date)
                        if(date=="noTime"){
                            alert("每月15日发放工资")
                            return false;
                        }
                        if(date=="noClose"){
                            alert("工资还未结算")
                            return false;
                        }
                        if(date=="ok"){
                            return true;
                        }
                    }
                })
            })
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
<c:if test="${!empty requestScope.leaveEmployees}">
    <p>离职员工</p>
    <table>
        <tr>
            <td>员工编号</td>
            <td>离职时间</td>
        </tr>
        <c:forEach items="${requestScope.leaveEmployees}" var="leaveEmployees">
            <tr>
                <td>${leaveEmployees.eId}</td>
                <td>${leaveEmployees.leCreateTime}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
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
            <tr>
                <td>${employees.eId}</td>
                <td>${employees.eName}</td>
                <td>${employees.dId}</td>
                <td>${employees.duty}</td>
                <td>${employees.eState}</td>
                <td><a href="/adm/dutyManage?eId=${employees.eId}">人事调动</a></td>
                <td><a href="/adm/lookEmpWork?eId=${employees.eId}">考勤</a></td>
                <td><a href="/adm/addSocialMoney?eId=${employees.eId}">添加社保</a></td>
                <td><a href="/adm/addBasicMoney?eId=${employees.eId}">添加基本工资</a></td>
                <td><a href="/adm/awardEmployee?eId=${employees.eId}">奖赏员工</a></td>
                <!--发工资的时间，是否存在结算工资-->
                <td><a href="/adm/sendWage?eId=${employees.eId}" id="sendWage">发放工资</a></td>
                <td><a href="/adm/deleteEmployee?eId=${employees.eId}">开除</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${requestScope.eId!=0}">
    <c:if test="${!empty requestScope.award}">
        <p>奖赏员工</p>
        <form action="/adm/commitAward" method="post">
            <input type="hidden" name="eId" value="${requestScope.eId}">
            <input type="text" name="cause" placeholder="奖赏原因">
            <input type="number" name="puMoney" placeholder="奖赏金额">
            <input type="submit" value="提交">
        </form>
    </c:if>
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

<c:if test="${requestScope.eId!=0}">
    <c:if test="${!empty requestScope.social}">
        <p>添加社保</p>
        <form action="/adm/commitSocialMoney">
            <input type="hidden" name="sm_id" value="0">
            <input type="hidden" name="eId" value="${requestScope.eId}">
            <input type="text" placeholder="添加社保" name="sMoney">
            <input type="submit" value="提交">
        </form>
    </c:if>
</c:if>

<c:if test="${requestScope.eId!=0}">
    <c:if test="${!empty requestScope.basic}">
        <p>添加基本工资</p>
        <form action="/adm/commitBasicMoney">
            <input type="hidden" name="bm_id" value="0">
            <input type="hidden" name="eId" value="${requestScope.eId}">
            <input type="text" placeholder="添加基本工资" name="bMoney">
            <input type="submit" value="提交">
        </form>
    </c:if>
</c:if>
</body>
</html>
