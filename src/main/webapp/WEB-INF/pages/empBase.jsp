<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/18
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>

    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-table-master/dist/bootstrap-table.min.css">

    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="bootstrap/js/Bootstrap/bootstrap.min.js"></script>

    <script src="/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
    <script src="/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.min.js"></script>

    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Layout/css/dmaku.css" />
    <script type="text/javascript" src="Layout/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".div2").click(function(){
                $(this).next("div").slideToggle("slow")
                    .siblings(".div3:visible").slideUp("slow");
            });
        });
    </script>

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
            <a class="navbar-brand">${sessionScope.employee.eName}</a>
        </div>

        <!--收集导航链接，窗体，和其他内容切换-->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/emp/gotoEmpPage">员工主页<span class="sr-only">(主页)</span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/emp/lookingYourself">查看信息</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">部门信息<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/emp/lookDuty">查看部门</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">培训通知<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/emp/lookCultivate">查看通知</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的考勤<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/emp/lookToWork">查看考勤</a></li>
                        <li><a href="/emp/lookMonthWork">本月考勤</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的奖惩<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/emp/lookPunish">查看奖惩</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的工资<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/emp/lookMonthWage">查看工资</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">退出</a></li>
            </ul>

        </div>
    </div>
</nav>

<div class="left">
    <div class="div1">
        <div class="left_top"><img src="Layout/images/bbb_01.jpg"><img src="Layout/images/bbb_02.jpg" id="2"><img src="Layout/images/bbb_02.jpg"><img src="Layout/images/bbb_01.jpg"> </div>

        <div class="div2"><div class="zxcp"> </div><a href="/emp/lookingYourself">个人信息</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/emp/lookDuty">部门信息</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/emp/lookCultivate">培训通知</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/emp/lookToWork">我的考勤</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/emp/lookMonthWork">本月考勤</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/emp/lookPunish">我的奖惩</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/emp/lookMonthWage">我的工资</a></div>

    </div>
</div>


</body>
</html>
