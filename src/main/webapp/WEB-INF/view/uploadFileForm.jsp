<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 18/05/2025
  Time: 8:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Upload Form</h1>
<form:form modelAttribute="uplaodFile" action="uploadFile" method="post" enctype="multipart/form-data">
    <div>File</div>
    <form:input path="file" type="file"/>
    <div>Mô tả</div>
    <form:input path="description"/>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
