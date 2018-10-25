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
        #mainTable{
            width: 900px;
            height: auto;
        }
    </style>
</head>
<body>
<div id="div">
    <p>员工管理</p>
    <c:if test="${!empty requestScope.leaveEmployees}">
        <p>离职员工</p>
        <table border="1px" cellspacing="0px" cellpadding="0px">
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
        <table border="1px" cellspacing="0px" cellpadding="0px" id="mainTable">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>部门ID</td>
                <td>职位</td>
                <td>员工的状态</td>
                <td colspan="9">操作</td>
            </tr>
            <c:forEach items="${requestScope.employees}" var="employees">
                <tr>
                    <td>${employees.eId}</td>
                    <td>${employees.eName}</td>
                    <td>${employees.dId}</td>
                    <td>${employees.duty}</td>
                    <td>${employees.eState}</td>
                    <td><a href="/adm/lookEmpAll?eId=${employees.eId}">详细信息</a></td>
                    <td><a href="/adm/dutyManage?eId=${employees.eId}">人事调动</a></td>
                    <td><a href="/adm/lookEmpOnWork?eId=${employees.eId}">考勤</a></td>
                    <td><a href="/adm/lookEmpPunish?eId=${employees.eId}">奖惩记录</a></td>
                    <td><a href="/adm/addSocialMoney?eId=${employees.eId}">添加社保</a></td>
                    <td><a href="/adm/addBasicMoney?eId=${employees.eId}">添加基本工资</a></td>
                    <td><a href="/adm/awardEmployee?eId=${employees.eId}">奖赏员工</a></td>

                    <td><a href="/adm/sendWage?eId=${employees.eId}" id="sendWage">发放工资</a></td>
                    <td><a href="/adm/deleteEmployee?eId=${employees.eId}">开除</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${requestScope.eId!=0}">
        <c:if test="${!empty requestScope.award}">
            <p>奖赏员工:编号${requestScope.eId}</p>
            <form action="/adm/commitAward" method="post">
                <input type="hidden" name="eId" value="${requestScope.eId}">
                <input type="text" name="cause" placeholder="奖赏原因">
                <input type="number" name="puMoney" placeholder="奖赏金额">
                <input type="submit" value="提交">
            </form>
        </c:if>
    </c:if>

    <c:if test="${!empty requestScope.departments}">
        <p>人事调度:编号${requestScope.eId}</p>
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
            <p>添加社保:编号${requestScope.eId}</p>
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
            <p>添加基本工资:编号${requestScope.eId}</p>
            <form action="/adm/commitBasicMoney">
                <input type="hidden" name="bm_id" value="0">
                <input type="hidden" name="eId" value="${requestScope.eId}">
                <input type="text" placeholder="添加基本工资" name="bMoney">
                <input type="submit" value="提交">
            </form>
        </c:if>
    </c:if>

    <c:if test="${!empty requestScope.employee}">
        <p>员工详情</p>
        <table border="1px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td>编号</td>
                <td>${requestScope.employee.eId}</td>
                <td>姓名</td>
                <td>${requestScope.employee.eName}</td>
            </tr>
            <tr>
                <td>部门编号</td>
                <td>${requestScope.employee.dId}</td>
                <td>职位</td>
                <td>${requestScope.employee.duty}</td>
            </tr>
            <tr>
                <td>电话</td>
                <td>${requestScope.employee.ePhone}</td>
                <td>Email</td>
                <td>${requestScope.employee.eEmail}</td>
            </tr>
            <tr>
                <td>入职时间</td>
                <td>${requestScope.employee.eCreateTime}</td>
                <td>状态</td>
                <td>${requestScope.employee.eState}</td>
            </tr>
            <tr>
                <td>基本工资</td>
                <td>
                    <c:if test="${empty requestScope.basicMoney.bMoney}">
                        <span>未添加</span>
                    </c:if>
                    <c:if test="${!empty requestScope.basicMoney.bMoney}">
                        ${requestScope.basicMoney.bMoney}
                    </c:if>
                </td>
                <td>社保</td>
                <td>
                    <c:if test="${empty requestScope.socialMoney.sMoney}">
                        <span>未添加</span>
                    </c:if>
                    <c:if test="${!empty requestScope.socialMoney.sMoney}">
                        ${requestScope.socialMoney.sMoney}
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="4"><a href="/adm/employeeManage">返回</a></td>
            </tr>
        </table>
    </c:if>

    <c:if test="${!empty requestScope.onWorks}">
        <p>查看考勤记录</p>
        <table border="1px" cellpadding="0px" cellspacing="0px">
            <tr>
                <td>上班时间</td>
                <td>下班时间</td>
                <td>上班状态</td>
                <td>下班状态</td>
            </tr>
            <c:forEach items="${requestScope.onWorks}" var="onWorks">
                <tr>
                    <td>${onWorks.startTime}</td>
                    <td>${onWorks.endTime}</td>
                    <td>${onWorks.onWorkState}</td>
                    <td>${onWorks.offWorkState}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${!empty requestScope.punishMonies}">
        <table border="1px" cellpadding="0px" cellspacing="0px">
            <tr>
                <td>奖惩</td>
                <td>金额</td>
                <td>时间</td>
            </tr>
            <c:forEach items="${requestScope.punishMonies}" var="punishMonies">
                <tr>
                    <td>${punishMonies.cause}</td>
                    <td>${punishMonies.puMoney}</td>
                    <td>${punishMonies.puCreateTime}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
