<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/20
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<body>
<div id="div">
    <c:if test="${empty requestScope.resWages}">
        <span>员工信息不全</span>
    </c:if>
    <c:if test="${!empty requestScope.resWages}">
        <p>员工薪资管理</p>
        <table border="1px" cellpadding="0px" cellspacing="0px">
            <tr>
                <td>员工编号</td>
                <td>员工名称</td>
                <td>基本工资</td>
                <td>社保</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${requestScope.resWages}" var="resWages">
                <tr>
                    <td>${resWages.eId}</td>
                    <td>${resWages.eName}</td>
                    <td>${resWages.basicMoney}</td>
                    <td>${resWages.socialMoney}</td>
                    <td><a href="/adm/lookOldWage?eId=${resWages.eId}">查看已发工资</a></td>
                    <td><a href="/adm/closeWage?eId=${resWages.eId}">结算工资</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p>绩效奖金</p>
    <form action="/adm/addBonusMoney">
        <input type="number" name="eId" placeholder="员工编号">
        <input type="number" name="boMoney" placeholder="奖金金额">
        <input type="submit" value="提交">
    </form>


    <c:if test="${!empty requestScope.wages}">
        <p>已发员工工资条</p>
        <table border="1px" cellpadding="0px" cellspacing="0px">
            <tr>
                <td>员工编号</td>
                <td>基本工资</td>
                <td>效绩工资</td>
                <td>加班工资</td>
                <td>奖惩工资</td>
                <td>社保</td>
                <td>时间</td>
                <td>总计</td>
                <td>复议工资</td>
            </tr>
            <c:forEach items="${requestScope.wages}" var="wages">
                <tr>
                    <td>${wages.eId}</td>
                    <td>${wages.basic}</td>
                    <td>${wages.bonus}</td>
                    <td>${wages.overTime}</td>
                    <td>${wages.punish}</td>
                    <td>${wages.social}</td>
                    <td>${wages.wCreateTime}</td>
                    <td>${wages.total}</td>
                    <td>${wages.advice}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${!empty requestScope.resCloseWage}">
        <p>结算工资</p>
        <table border="1px" cellpadding="0px" cellspacing="0px">
            <tr>
                <td>员工编号</td>
                <td>月份天数</td>
                <td>工作天数</td>
                <td>基本工资</td>
                <td>社保</td>
                <td>加班工资</td>
                <td>奖惩工资</td>
                <td>效绩工资</td>
                <td>总计</td>
                <td>复议工资</td>
            </tr>
                <tr>
                    <td>${requestScope.resCloseWage.eId}</td>
                    <td>${requestScope.resCloseWage.monthDay}</td>
                    <td>${requestScope.resCloseWage.omWorkDay}</td>
                    <td>${requestScope.resCloseWage.basicMoney}</td>
                    <td>${resCloseWage.socialMoney}</td>
                    <td>${requestScope.resCloseWage.overTimeMoney}</td>
                    <td>${requestScope.resCloseWage.punishMoney}</td>
                    <td>${requestScope.resCloseWage.bonusMoney}</td>
                    <td>${requestScope.resCloseWage.total}</td>
                    <td>
                        <c:if test="${requestScope.wageAdvise==null}">
                            <span>无</span>
                        </c:if>
                        <c:if test="${requestScope.wageAdvise!=null}">
                            ${requestScope.wageAdvise.adMoney}
                        </c:if>
                    </td>
                </tr>
        </table>
    </c:if>
</div>
</body>
</html>
