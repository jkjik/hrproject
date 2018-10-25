<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/10/16
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工页面</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <jsp:include   page="empBase.jsp" flush="true"/>
    <style>
        #onWork{
            position: absolute;
            left: 600px;
            top: 120px;
            width: 80px;
            height: 40px;
            border: 2px solid red;
            background-color: yellow;
            text-align: center;
            line-height:40px;
        }
        #offWork{
            position: absolute;
            right: 500px;
            top: 120px;
            width: 80px;
            height: 40px;
            border: 2px solid red;
            background-color: yellow;
            text-align: center;
            line-height:40px;
        }
    </style>
    <script>
        $(function () {
            $("#yesWork").click(function () {
                $.ajax({
                    url:"/emp/onWorkCard",
                    type:"post",
                    dataType:"text",
                    async:false,
                    data:{},
                    success:function (data) {
                        if(data=="ok"){
                            alert("打卡成功")
                        }else if(data=="fail"){
                            alert("重复打卡")
                        }else {
                            alert("打卡失败")
                        }
                    }
                })
            })
        })

        $(function () {
            $("#noWork").click(function () {
                $.ajax({
                    url:"/emp/offWorkCard",
                    type:"post",
                    dataType:"text",
                    data:{},
                    success:function (data) {
                        if(data=="ok"){
                            alert("打卡成功")
                        }else if(data=="fail"){
                            alert("重复打卡")
                        }else {
                            alert("打卡失败")
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>

<div id="onWork">
    <a id="yesWork">上班打卡</a>
</div>

<div id="offWork">
    <a id="noWork">下班打卡</a>
</div>

</body>
</html>
