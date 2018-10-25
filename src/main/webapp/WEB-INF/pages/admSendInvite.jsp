<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/14
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>管理员发布招聘</title>
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
        .top{
            background-color: yellow;
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
    <c:if test="${!empty requestScope.inviteJobs}">
        <table border="1px" cellspacing="0px" cellpadding="0px">
            <tr class="top">
                <td>招聘公司</td>
                <td>招聘职位</td>
                <td>薪资</td>
                <td>福利</td>
            </tr>
            <c:forEach items="${requestScope.inviteJobs}" var="Jobs">
                <tr>
                    <td><input type="text" value="${Jobs.company}"></td>
                    <td><input type="text" value="${Jobs.job}"></td>
                    <td><input type="text" value="${Jobs.pay}"></td>
                    <td><input type="text" value="${Jobs.welfare}"></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty requestScope.invite}">
        <form action="/adm/commitSendInvite" method="post">
            <table border="1px" cellspacing="0px" cellpadding="0px">
                <tr>
                    <td style="display: none"><input type="hidden" name="ijId" value="0"></td>
                    <td style="display: none"><input type="hidden" name="aId" value="${sessionScope.adm.aId}"></td>
                </tr>
                <tr>
                    <td>公司</td>
                    <td><input type="text" name="company"></td>
                </tr>
                <tr>
                    <!--从数据库获取职位-->
                    <td>职位</td>
                    <td>
                        <select class="duty">
                            <c:forEach items="${requestScope.departments}" var="dep">
                                <option id="dep" value="${dep.dId}">${dep.dName}</option>
                            </c:forEach>
                        </select>
                        <select name="job" class="position">
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>薪水</td>
                    <td><input type="text" name="pay"></td>
                </tr>
                <tr>
                    <td>福利</td>
                    <td><input type="text" name="welfare"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </c:if>

    <c:if test="${!empty requestScope.invite}">
        <form action="/adm/commitSendInvite" method="post">
            <table>
                <tr>
                    <td style="display: none"><input type="hidden" name="ijId" value="0"></td>
                    <td style="display: none"><input type="hidden" name="aId" value="${sessionScope.adm.aId}"></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </c:if>
</div>
</body>
</html>
