<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <base href="<%=request.getContextPath()%>/">
</head>
<body>
<form action="/user/register" method="post">
    <input type="hidden" value="-1" name="uId">
    <input type="text" name="uName">
    <input type="text" name="uPassword">
    <input type="hidden" value="null" name="uCreatetime">
    <input type="hidden" value="0" name="status">
    <input type="submit" value="提交">
</form>

<form action="/user/test" method="post">
    <input type="text" name="id">
    <input type="submit" value="提交">
</form>
</body>
</html>
