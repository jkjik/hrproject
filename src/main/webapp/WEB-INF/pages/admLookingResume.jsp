<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/14
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看所有个人简历</title>
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
</head>
<script>
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
</style>
<body>
<div id="div">
<p>查看所有个人简历</p>
<c:if test="${!empty requestScope.resume}">
        <table  border="1px" cellspacing="0px" cellpadding="0px">
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
                <td>
                        <textarea name="yourself" cols="30" rows="4">
                                ${requestScope.resume.lastWork}
                        </textarea>
                </td>
            </tr>
            <tr>
                <td>应聘职位</td>
                <td><input type="text" name="aimDuty" value="${requestScope.resume.aimDuty}"></td>
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
                <td align="center" colspan="4"><a href="/adm/interview?rId=${requestScope.resume.rId}">面试通知</a></td>
            </tr>
            <tr>
                <!--当前时间与面试时间-->
                <td align="center" colspan="4"><a href="/adm/intvResult?rId=${requestScope.resume.rId}">面试结果</a></td>
            </tr>
            <tr>
                <td align="center" colspan="4"><a href="/adm/gotoLookResume">返回</a></td>
            </tr>
        </table>
    </form>
</c:if>
</div>
</body>
</html>
