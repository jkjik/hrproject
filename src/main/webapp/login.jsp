<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/12
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContextrequestcontext}/">
    <title>登录</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {

            $("#form").submit(function () {
                var uName=$("#uName").val()
                var pass=$("#pass").val()
                if(uName==""){
                    $(".verifyUname").css("display","block");
                    return false;
                }
                if(pass==""){
                    $(".varifyPass").css("display","block");
                    return false;
                }
                return true;
            })

            $("#uName").change(function () {
                varifyUname();
            })
        })
        //用户存在验证
        function varifyUname() {
            var uName=$("#uName").val()
            var varifySameUname=$(".verifySameUname")
            var url="/user/varifySameUname";
            var args={"uName":uName}
            $.post(url,args,function (data) {
                if(data=="no"){
                    varifySameUname.css("display","block");
                    $("#form").submit(function () {
                        return false;
                    })
                }else {
                    varifySameUname.css("display","none");
                    $("#form").submit(function () {
                        return true;
                    })
                }
            })
        }
    </script>
</head>
<body>
<form action="/user/login" id="form" method="post">
    <p>登录</p>
    <input type="text" name="uName" id="uName" placeholder="用户名："><br>
    <span style="display:none" class="verifyUname">用户名不能为空</span>
    <span style="display:none" class="verifySameUname">用户名不存在</span>
    <input type="password" name="uPassword" id="pass" placeholder="密码"><br>
    <span style="display:none" class="varifyPass">密码不能为空</span>
    <input type="submit" value="提交">
</form>
</body>
</html>
