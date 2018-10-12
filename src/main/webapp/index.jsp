<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <base href="${pageContextrequestcontext}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            var uName=$("#uName").val()
            var varifySameUname=$(".verifySameUname")
                var url="/user/varifySameUname";
                alert(uName)
                var args={"uName":uName}
                $.post(url,args,function (data) {
                    if(data=="yes"){
                        varifySameUname.css("display","block");
                        $("form").submit(function () {
                            return false;
                        })
                    }else {
                        varifySameUname.css("display","none");
                        $("form").submit(function () {
                            return true;
                        })
                    }
                })
        })
    /*    $(function () {
            var uName=$("#uName").val()
            var pass1=$("#pass1").val()
            var pass2=$("#pass2").val()
            var varifySameUname=$(".verifySameUname")
            var verifyUname=$(".verifyUname").val()
            var verifyPass1=$(".varifyPass1").val()
            var varifyPass2=$(".varifyPass2").val()
            var varifySame=$(".varifySamePass").val()
            //用户名重复验证
            $("#uName").change(function () {
                        var url="/user/varifySameUname";
                        var args={"uName":uName}
                        $.post(url,args,function (data) {
                            if(data=="yes"){
                                varifySameUname.css("display","block");
                                $("form").submit(function () {
                                    return false;
                                })
                            }else {
                                varifySameUname.css("display","none");
                                $("form").submit(function () {
                                    return true;
                                })
                            }
                })
            })
            $("form").submit(function () {
                if(""==uName){
                    verifyUname.css("display","block");
                    return false;
                }
                if(""==pass1){
                    verifyPass1.css("display","block");
                    return false;
                }
                if(""==pass2){
                    varifyPass2.css("display","block");
                    return false;
                }
                if(pass1==pass2){
                    return true;
                    varifySamePass.css("display","block")
                }else {
                    return false;
                }
            })
        })*/
    $(function () {
        $("#uName").blur(function () {
            var uName=$("#uName").val()
            alert(uName)
        })
        $("#pass1").change(function () {
            var pass1=$("#pass1").val()
            alert(pass1)
        })
        $("#pass2").change(function () {
            var pass2=$("#pass2").val()
            alert(pass2)
        })
    })
    </script>
</head>
<body>
<form action="/user/register" method="post">
    <p>注册</p>
    <input type="text" name="uName" id="uName" placeholder="用户名："><br>
    <span style="display:none" class="verifySameUname">用户名已经存在</span>
    <span style="display:none" class="verifyUname">用户名不能为空</span>
    <input type="password" name="uPassword" id="pass1" placeholder="密码"><br>
    <span style="display:none" class="varifyPass1">密码不能为空</span>
    <input type="password" id="pass2" placeholder="确认密码"><br>
    <span style="display:none" class="varifyPass2">确认密码不能为空</span>
    <span style="display:none" class="varifySamePass">确认密码不正确</span>
    <input type="submit" value="提交">
    <p>已有账户<a href="login.jsp">登录</a></p>
</form>
</body>
</html>
