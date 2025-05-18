<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 18/05/2025
  Time: 11:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Đăng ký</h1>
<form:form modelAttribute="account" action="register" method="post">
    <div>Tên đằng nhập</div>
    <form:input path="username"/>
    <div>Mật khẩu</div>
    <fomr:input path="password"/>
    <div>Email</div>
    <form:input path="email"/>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
