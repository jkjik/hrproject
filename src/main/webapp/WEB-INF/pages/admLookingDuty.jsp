<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/18
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $(".delete1").click(function () {
                var flag=confirm("你确定删除?")
                if(!flag){
                    return false;
                }else{
                    var click1=true;
                    var dName=$(this).parent().parent().children().children()[0].text()
                    $.ajax({
                        url:"/adm/deleteDep",
                        tape:"post",
                        async:false,
                        dateType:"text",
                        data:{"dName":dName},
                        success:function (data) {
                            if(data=="no"){
                                alert("该部门还有员工")
                                click1=false;
                            }
                        }
                    })
                    return click1;
                }
                dep()
            })
            $(".delete2").click(function () {
                var flag=confirm("你确定删除?")
                if(!flag){
                    return false;
                }else {
                    var click=true;
                    var pName=$(this).parent().parent().children()[0].innerHTML;
                    $.ajax({
                        url:"/adm/deletePos",
                        tape:"post",
                        async:false,
                        dataType:"text",
                        data:{"pName":pName},
                        success:function (data) {
                            if(data=="no"){
                                alert("该职位还有员工")
                                click=false;
                            }
                        }
                    })
                    return click;
                }
            })
        })
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
</head>
<body>
<div id="div">
<p>查看部门</p>
<table  border="1px" cellspacing="0px" cellpadding="0px">
    <tr>
        <td>部门</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${requestScope.departments}" var="dep">
        <tr>
            <td>
                <a href="/adm/getPosition?dId=${dep.dId}">${dep.dName}</a>
            </td>
            <td>
                <input type="hidden" value="${dep.dName}">
                <a href="/adm/deleteDepartment?dId=${dep.dId}" class="delete1">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a href="/adm/addDep?dep=1">添加</a>
        </td>
    </tr>
</table>

<c:if test="${!empty requestScope.dep}">
    <p>添加部门</p>
    <form action="/adm/commitAddDep" method="post">
        <input type="text" name="dName" placeholder="请输入部门名称">
        <input type="submit" value="提交">
    </form>
</c:if>


<c:if test="${!empty requestScope.positions}">
    <p>查看职位</p>
    <table  border="1px" cellspacing="0px" cellpadding="0px">
        <tr>
            <td>职位</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${requestScope.positions}" var="position">
            <tr>
                <td>${position.pName}</td>
                <td>
                    <a href="/adm/deletePosition?pId=${position.pId}"  class="delete2">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">
                <a href="/adm/addPos?pos=1">添加</a>
            </td>
        </tr>
    </table>
</c:if>

<c:if test="${!empty requestScope.addPost}">
    <!--部门中无职位信息-->
    <table  border="1px" cellspacing="0px" cellpadding="0px">
        <tr>
            <td>部门</td>
            <td>部门ID</td>
        </tr>
        <c:forEach items="${requestScope.department}" var="depre">
            <tr>
                <td>${depre.dName}</td>
                <td>${depre.dId}</td>
            </tr>
        </c:forEach>
    </table>

    <p>添加职位</p>
    <form action="/adm/commitAddPos" method="post">
        <input type="text" name="dId" placeholder="请输入部门ID"><br>
        <input type="text" name="pName" placeholder="请输入职位"><br>
        <input type="submit" value="提交">
    </form>
</c:if>

<c:if test="${!empty requestScope.depre}">
    <!--部门信息-->
        <table  border="1px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td>部门</td>
                <td>部门ID</td>
            </tr>
    <c:forEach items="${requestScope.depre}" var="depre">
            <tr>
                <td>${depre.dName}</td>
                <td>${depre.dId}</td>
            </tr>
    </c:forEach>
        </table>
</c:if>


<c:if test="${!empty requestScope.pos}">
    <p>添加职位</p>
    <form action="/adm/commitAddPos" method="post">
        <input type="text" name="dId" placeholder="请输入部门ID"><br>
        <input type="text" name="pName" placeholder="请输入职位"><br>
        <input type="submit" value="提交">
    </form>
</c:if>
</div>
</body>
</html>
