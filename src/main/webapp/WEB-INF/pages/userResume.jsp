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
            //切换目标，得到部门信息
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
            $("form").submit(function () {
                var rName=$(".rName").val();
                var rAge=$(".rAge").val();
                var school=$(".school").val();
                var education=$(".education").val()
                var email=$(".email").val()
                var phone=$(".phone").val()
                var lastWork=$(".lastWork").val()
                var aimPay=$(".aimPay").val()
                var project=$(".project").val()
                var yourself=$(".yourself").val()
                if(""==rName){
                    alert("名字不能为空")
                    return false;
                }
                if(""==rAge){
                    alert("年龄不能为空")
                    return false;
                }
                if(""==school){
                    alert("学校不能为空")
                    return false;
                }
                if(""==education){
                    alert("专业不能为空")
                    return false;
                }
                if(""==email){
                    alert("Email不能为空")
                    return false;
                }
                if(""==phone){
                    alert("电话不能为空")
                    return false;
                }
                if(""==lastWork){
                    alert("工作经历不能为空")
                    return false;
                }
                if(""==aimPay){
                    alert("期待薪资不能为空")
                    return false;
                }
                if(""==project){
                    alert("校园经历不能为空")
                    return false;
                }
                if(""==yourself){
                    alert("自我介绍不能为空")
                    return false;
                }
            })
        })
        //初始得到部门信息
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
            width: 1000px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
        }
    </style>
</head>
<body>
<div id="div">
    <c:if test="${empty requestScope.resume}">
        <P>添加简历</P>
        <form action="/user/commitAddResume" method="post">
            <table>
                <tr>
                    <td style="display: none"><input type="hidden" name="rId" value="0"></td>
                    <td style="display: none"><input type="hidden" name="uId" value="${sessionScope.user.uId}"></td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="rName" class="rName"></td>
                    <td>年龄</td>
                    <td><input type="number" name="rAge" class="rAge"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <input type="radio" checked="checked" name="rSex" value="男"/>男
                        <input type="radio" name="rSex" value="女"/>女
                    </td>
                    <td>学校</td>
                    <td><input type="text" name="school" class="school"></td>
                </tr>
                <tr>
                    <td>专业</td>
                    <td><input type="text" name="education" class="education"></td>
                    <td>Email</td>
                    <td><input type="email" name="email" class="email"></td>
                </tr>
                <tr>
                    <td>联系方式</td>
                    <td><input type="number" name="phone" class="phone"></td>
                    <td>工作经历</td>
                    <td>
                        <textarea name="lastWork" cols="30" rows="4" class="lastWork">

                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>应聘职位</td>
                    <td>
                        <select class="duty">
                            <c:forEach items="${requestScope.departments}" var="dep">
                                <option id="dep" value="${dep.dId}">${dep.dName}</option>
                            </c:forEach>
                        </select>
                        <select name="aimDuty" class="position"></select>
                    </td>
                    <td>期待薪资</td>
                    <td><input type="text" name="aimPay" class="aimPay"></td>
                </tr>
                <tr>
                    <td>校园经历</td>
                    <td>
                        <textarea name="project" cols="30" rows="4" class="project">

                        </textarea>
                    </td>
                    <td>自我介绍</td>
                    <td>
                        <textarea name="yourself" cols="30" rows="4" class="yourself">

                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </c:if>

    <c:if test="${!empty requestScope.resume}">
        <p>修改简历</p>
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
                    <td>
                        <input type="radio" checked="checked" name="rSex" value="男"/>男
                        <input type="radio" name="rSex" value="女"/>女
                    </td>
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
                    <td>
                        <textarea name="lastWork" cols="30" rows="4">
                                ${requestScope.resume.lastWork}
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>应聘职位</td>
                    <td>
                        <select class="duty">
                            <option selected="selected">${requestScope.aimDuty}</option>
                            <c:forEach items="${requestScope.departments}" var="dep">
                                <option value="${dep.dId}">${dep.dName}</option>
                            </c:forEach>
                        </select>
                        <select name="aimDuty" class="position">
                            <option>${requestScope.resume.aimDuty}</option>
                        </select>
                    </td>
                    <td>期待薪资</td>
                    <td><input type="text" name="aimPay" value="${requestScope.resume.aimPay}"></td>
                </tr>
                <tr>
                    <td>校园经历</td>
                    <td>
                        <textarea name="project" cols="30" rows="4">
                                ${requestScope.resume.project}
                        </textarea>
                    </td>
                    <td>自我介绍</td>
                    <td>
                        <textarea name="yourself" cols="30" rows="4">
                                ${requestScope.resume.yourself}
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </c:if>
</div>
</body>
</html>
