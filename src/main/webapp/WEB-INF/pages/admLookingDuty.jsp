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
                var td=$(this).parent().parent().children()
                var name=td[0].children.innerHTML;
                var flag=confirm("你确定删除?)
                if(!flag){
                    return false;
                }
            })
            dep()
            $(".delete2").click(function () {
                $td=$(this).parent().parent().children()
                var name2=$td[0].innerHTML;
                var flag=confirm("你确定删除?")
                if(!flag){
                    return false;
                }
            })
            pos()
        })
        function dep() {
            var dName=$("delete1").parent().parent().children()[0].innerHTML;
            $.ajax({
                url:"/adm/deleteDep",
                tape:"post",
                dateType:"String",
                data:{"dName":dName},
                success:function (data) {
                    if(data!="ok"){
                        alert("该部门还有员工")
                    }
                    return false;
                }
            })
        }
        function pos() {
            var pName=$("delete2").parent().parent().children()[0].innerHTML;
            $.ajax({
                url:"/adm/deletePos",
                tape:"post",
                dataType:"String",
                data:{"pName":pName},
                success:function (data) {
                    if(data!="ok"){
                        alert("该职位还有员工")
                    }
                    return false;
                }
            })
        }
    </script>
</head>
<body>

<p>查看部门</p>
<table>
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
                <a href="/adm/deleteDepAndPos?dId=${dep.dId}" class="delete1">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a href="/adm/addDepAndPos?dep=1">添加</a>
        </td>
    </tr>
</table>

<c:if test="${!empty requestScope.dep}">
    <p>添加部门</p>
    <form>
        <span>请输入部门名称</span>
        <input type="text" name="dName">
        <input type="submit" value="提交">
    </form>
</c:if>


<c:if test="${!empty requestScope.positions}">
    <p>查看职位</p>
    <table>
        <tr>
            <td>职位</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${requestScope.positions}" var="position">
            <tr>
                <td>${positions.pName}</td>
                <td>
                    <a href="/adm/deleteDepAndPos?pId=${position.pId}"  class="delete">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">
                <a href="/adm/addDepAndPos?pos=1">添加</a>
            </td>
        </tr>
    </table>
</c:if>

<c:if test="${!empty requestScope.pos}">
    <!--部门信息-->
    <c:forEach items="${requestScope.depre}" var="depre">
        <table>
            <tr>
                <td>部门</td>
                <td>部门ID</td>
            </tr>
            <tr>
                <td>${depre.dName}</td>
                <td>${depre.dId}</td>
            </tr>
        </table>
    </c:forEach>
</c:if>


<c:if test="${!empty requestScope.pos}">
    <p>添加职位</p>
    <form>
        <span>请输入职业</span>
        <input type="text" name="pName">
        <span>请输入部门ID</span>
        <input type="text" name="dId">
        <input type="submit" value="提交">
    </form>
</c:if>

</body>
</html>
