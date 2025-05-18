<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 18/05/2025
  Time: 7:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>Form document</h2>
    <form:form modelAttribute="document" action="saveDocument" method="post" enctype="multipart/form-data">
        <div>Title</div>
        <form:input path="title"/>
        <div>Description</div>
        <form:input path="description"/>
        <div>File</div>
        <form:input path="file" type="file"/>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
