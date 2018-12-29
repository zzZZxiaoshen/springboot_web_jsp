<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/22
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>静态页面</h4>
<form action="/springboot_web_jsp/hello">
    <input type="text" name="username">
    <input type="password" name="password"></input>
    <input type="submit" value="sub">
</form>


<form action="/springboot_web_jsp/api/upload/route" method="post"  enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="sub">
</form>
</body>
</html>
