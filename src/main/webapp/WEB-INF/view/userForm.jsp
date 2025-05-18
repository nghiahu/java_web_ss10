<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 18/05/2025
  Time: 10:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Nhập thông tin User</h1>
    <form:form modelAttribute="user" action="user-sub" method="post">
        <div>userName</div>
        <form:input path="name"/>
        <div>Age</div>
        <form:input path="age"/>
        <div>Address</div>
        <form:input path="address"/>
        <input type="submit" value="Submit">
    </form:form>
</div>
</body>
</html>
