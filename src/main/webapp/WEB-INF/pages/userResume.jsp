<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/12
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <base href="${pageContext.request.contextPath}/">
    <title>添加修改简历</title>
    <jsp:include   page="userBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $("#duty").change(function () {
                $("#position").empty();
                var dep=$(this).children('option:selected').val();
                $.ajax({
                    url:"/user/getPosition",
                    type:"post",
                    dataType:"json",
                    data:{"dep":dep},
                    success:function (data) {
                        $.each(data,function (idx,item) {
                            $("#position").append(" <option>" + item.pName + "</option>")
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
                        $("#position").append(" <option>" + item.pName + "</option>")
                    })
                },
                error:function(error) {
                    alert("error=" + error);
                }
            })
        }
    </script>
</head>
<body>
<c:if test="${empty requestScope.resume}">
    <form action="/user/commitAddResume" method="post">
        <table>
            <tr>
                <td style="display: none"><input type="hidden" name="rId" value="0"></td>
                <td style="display: none"><input type="hidden" name="uId" value="${sessionScope.user.uId}"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="rName"></td>
                <td>年龄</td>
                <td><input type="number" name="rAge"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input name="sex" type="radio" checked="checked" name="rSex"/>男
                    <input name="sex" type="radio" name="rSex"/>女
                </td>
                <td>学校</td>
                <td><input type="text" name="school"></td>
            </tr>
            <tr>
                <td>专业</td>
                <td><input type="text" name="education"></td>
                <td>Email</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td><input type="number" name="phone"></td>
                <td>工作经历</td>
                <td><input type="text" name="lastWork"></td>
            </tr>
            <tr>
                <td>应聘职位</td>
                <td>
                    <select id="duty">
                        <c:forEach items="${requestScope.departments}" var="dep">
                            <option id="dep" value="${dep.dId}" selected="selected">${dep.dName}</option>
                        </c:forEach>
                    </select>
                    <select name="aimDuty" id="position">
                    </select>
                </td>
                <td>期待薪资</td>
                <td><input type="text" name="aimPay"></td>
            </tr>
            <tr>
                <td>校园经历</td>
                <td><input type="text" name="project"></td>
                <td>自我介绍</td>
                <td><input type="text" name="yourself"></td>
            </tr>
            <tr>
                <td colspan="4"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</c:if>

<c:if test="${!empty requestScope.resume}">
    <form action="/user/commitSetResume" method="post">
        <table>
            <tr>
                <td style="display: none"><input type="hidden" name="rId" value="0"></td>
                <td style="display: none"><input type="hidden" name="uId" value="${sessionScope.user.uId}"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="rName" value="${requestScope.resume.rName}"></td>
                <td>年龄</td>
                <td><input type="text" name="rAge" value="${requestScope.resume.rAge}"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="rSex" value="${requestScope.resume.rSex}"></td>
                <td>学校</td>
                <td><input type="text" name="school" value="${requestScope.resume.school}"></td>
            </tr>
            <tr>
                <td>专业</td>
                <td><input type="text" name="education" value="${requestScope.resume.education}"></td>
                <td>Email</td>
                <td><input type="text" name="email" value="${requestScope.resume.email}"></td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td><input type="text" name="phone" value="${requestScope.resume.phone}"></td>
                <td>工作经历</td>
                <td><input type="text" name="lastWork" value="${requestScope.resume.lastWork}"></td>
            </tr>
            <tr>
                <td>应聘职位</td>
                <td>
                    <select>
                        <option selected="selected">${requestScope.aimDuty}</option>
                        <c:forEach items="${requestScope.departments}" var="dep">
                            <option id="dep" value="${dep.dId}">${dep.dName}</option>
                        </c:forEach>
                    </select>
                    <select name="aimDuty">
                        <option>${requestScope.resume.aimDuty}</option>
                    </select>
                </td>
                <td>期待薪资</td>
                <td><input type="text" name="aimPay" value="${requestScope.resume.aimPay}"></td>
            </tr>
            <tr>
                <td>校园经历</td>
                <td><input type="text" name="project" value="${requestScope.resume.project}"></td>
                <td>自我介绍</td>
                <td><input type="text" name="yourself" value="${requestScope.resume.yourself}"></td>
            </tr>
            <tr>
                <td colspan="4"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>
