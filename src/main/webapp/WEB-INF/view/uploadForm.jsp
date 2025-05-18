<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 18/05/2025
  Time: 11:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Upload Form</h1>
<form:form modelAttribute="userProfile" action="uploadAvatar" method="post" enctype="multipart/form-data">
  <div>Tên người dùng</div>
  <form:input path="username"/>
  <div>Avata</div>
  <form:input path="avatar" type="file" />
  <input type="submit" value="Upload">
</form:form>
</body>
</html>
