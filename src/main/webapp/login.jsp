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
    <base href="${pageContext.request.contextPath}/">
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
            $("#pass").change(function () {
                varifyError();
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
    <table style="background: green;margin: 70px auto;width: 35%; height:200px;text-align: center" align="center">
        <tr>
            <td><p>登录</p></td>
        </tr>

        <tr>
            <td><input type="text" name="uName" id="uName" placeholder="用户名："></td>
        </tr>

        <tr>
            <td>
                <span style="display:none" class="verifyUname">用户名不能为空</span>
                <span style="display:none" class="verifySameUname">用户名不存在</span>
            </td>
        </tr>

        <tr>
            <td>
                <input type="password" name="uPassword" id="pass" placeholder="密码">
            </td>
        </tr>

        <tr>
            <td>
                <span style="display:none" class="varifyPass">密码不能为空</span>
                <span style="display:none" class="varifyError">密码不正确</span>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
