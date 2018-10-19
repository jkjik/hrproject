<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-table-master/dist/bootstrap-table.min.css">

    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="bootstrap-table-master/dist/bootstrap-table.min.js"></script>
    <script src="bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.min.js"></script>
    <script></script>

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- 品牌和切换分组，以更好的移动显示 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">${sessionScope.user.uName}</a>
        </div>

        <!--收集导航链接，窗体，和其他内容切换-->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/user/gotoUserPage">游客主页<span class="sr-only">(主页)</span></a></li>
                <li><a href="/user/lookJob">查看招聘信息</a></li>
                <li><a href="/user/resume">添加简历</a><br></li>
                <li><a href="/user/resume?uId=${sessionScope.user.uId}">修改简历</a></li>
                <li><a href="/user/lookResumeState?uId=${sessionScope.user.uId}">查看简历的状态</a></li>
                <%--             <li class="dropdown">
                                 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                 <ul class="dropdown-menu">
                                     <li><a href="#">Action</a></li>
                                     <li><a href="#">Another action</a></li>
                                     <li><a href="#">Something else here</a></li>
                                     <li role="separator" class="divider"></li>
                                     <li><a href="#">Separated link</a></li>
                                     <li role="separator" class="divider"></li>
                                     <li><a href="#">One more separated link</a></li>
                                 </ul>
                             </li>--%>
            </ul>
            <%--   <form class="navbar-form navbar-left">
                   <div class="form-group">
                       <input type="text" class="form-control" placeholder="Search">
                   </div>
                   <button type="submit" class="btn btn-default">Submit</button>
               </form>--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">退出</a></li>
                <%--  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <li><a href="#">Action</a></li>
                          <li><a href="#">Another action</a></li>
                          <li><a href="#">Something else here</a></li>
                          <li role="separator" class="divider"></li>
                          <li><a href="#">Separated link</a></li>
                      </ul>
                  </li>--%>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div>

</div>
</body>
</html>
