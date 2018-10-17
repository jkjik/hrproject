<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <style>
      /*  body{
            background-color: green;
        }*/
    </style>
    <script>
        $(function () {
            //提交非空验证
            $("#from").submit(function () {
                var uName=$("#uName").val()
                var pass1=$("#pass1").val()
                var pass2=$("#pass2").val()
                if(uName==""){
                    $(".verifyUname").css("display","block");
                    return false;
                }
                if(pass1==""){
                    $(".varifyPass1").css("display","block");
                    return false;
                }
                if(pass2==""){
                    $(".varifyPass2").css("display","block");
                    return false;
                }
                if(pass1!=pass2){
                    $(".varifySamePass").css("display","block");
                    return false;
                }
                return true;
            })

            $("#uName").change(function () {
                varifyUname();
            })
        })
        //用户名重复验证
       function varifyUname() {
           var uName=$("#uName").val()
           var varifySameUname=$(".verifySameUname")
           var url="/user/varifySameUname";
           var args={"uName":uName}
           $.post(url,args,function (data) {
               if(data=="yes"){
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
<table   style="background: green;margin: 70px auto;width: 35%;text-align: center" align="center">
    <form action="/user/register" id="from" method="post">
        <tr>
            <td align="center"><p>注册</p></td>
        </tr>
        <tr>
            <td><input type="text" name="uName" id="uName" placeholder="用户名："><br></td>
        </tr>

        <tr>
            <td>
                <span style="display:none" class="verifySameUname">用户名已经存在</span>
                <span style="display:none" class="verifyUname">用户名不能为空</span>
            </td>
        </tr>
        <tr>
            <td><input type="password" name="uPassword" id="pass1" placeholder="密码"><br></td>
        </tr>
        <tr>
            <td>
                <span style="display:none" class="varifyPass1">密码不能为空</span>
            </td>
        </tr>

        <tr>
            <td><input type="password" id="pass2" placeholder="确认密码"><br></td>
        </tr>
        <tr>
            <td>
                <span style="display:none" class="varifyPass2">确认密码不能为空</span>
                <span style="display:none" class="varifySamePass">确认密码不正确</span>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
        <tr>
            <td><p>已有账户<a href="login.jsp">登录</a></p></td>
        </tr>
    </form>
</table>

</body>
</html>
