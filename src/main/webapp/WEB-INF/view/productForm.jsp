<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 18/05/2025
  Time: 10:45 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h2>Nhập Thông Tin Sản Phẩm</h2>
  <form:form modelAttribute="product" action="addProduct" method="post">
    <p>Tên sản phẩm:</p>
    <form:input path="name"/>

    <p>Giá:</p>
    <form:input path="price"/>

    <p>Mô tả:</p>
    <form:textarea path="description"/>

    <br><br>
    <input type="submit" value="Thêm sản phẩm"/>
  </form:form>
  </body>
</html>
