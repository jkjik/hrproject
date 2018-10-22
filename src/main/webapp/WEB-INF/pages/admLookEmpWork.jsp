<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/22
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <jsp:include   page="admBase.jsp" flush="true"/>

 <%--   <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>

    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link href="bootstrap/css/tableexport.css">
    <link rel="stylesheet" href="/bootstrap/dist/bootstrap-table.min.css">
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

    <script src="bootstrap/js/Blob.js/Blob.js"></script>
    <script src="bootstrap/js/FileSaver.js/FileSaver.js"></script>
    <script src="bootstrap/js/js-xlsx/xlsx.core.min.js"></script>

    <script src="bootstrap/js/Bootstrap/bootstrap.min.js"></script>
    <script src="bootstrap/js/TableExport.js/jquery.tableexport.js"></script>
    <script src="/bootstrap/dist/bootstrap-table.min.js"></script>
    <script src="/bootstrap/dist/extensions/export/bootstrap-table-export.min.js"></script>
    <script src="bootstrap/dist/locale/bootstrap-table-zh-CN.js"></script>
</head>
<script>
    $(function(){
        $('#tb_departments').bootstrapTable({
            url: '/adm/lookingEmpWork',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            sortOrder: "asc",                   //排序方式
            //queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pagination: true,
            pageSize: 4,                       //每页的记录行数（*）
            minimumCountColumns: 2,             //最少允许的列数
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            height: 500,
            cardView: false,                    //是否显示详细视图
            detailView: true,                   //是否显示父子表
            showExport: true,                     //是否显示导出
            exportDataType: "basic",              //basic', 'all', 'selected'.
            columns: [{
                field: 'eId',
                title: '员工编号'
            },{
                field: 'startTime',
                title: '上班时间'
            }, {
                field: 'endTime',
                title: '下班时间'
            }, {
                field: 'onWorkState',
                title: '上班状态'
            },{
                field: 'offWorkState',
                title: '下班状态'
            }],
        });
    })
</script>--%>
<body>
    <table id="tb_departments"></table>
</body>
</html>
