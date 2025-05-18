<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 16/05/2025
  Time: 4:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Book Form</h4>
<form:form modelAttribute="book" action="${pageContext.request.contextPath}/book-save" method="post">
    <div>Title</div>
    <form:input path="title"/>

    <div>ISBN</div>
    <form:input path="ISBN"/>
    
    <div>Price</div>
    <form:input path="price"/>

<%--    <div>Image</div>--%>
<%--    <form:input path="fileImage" type="file"/>--%>

    <div>PublishedDate</div>
    <form:input path="publishedDate" type="date"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
