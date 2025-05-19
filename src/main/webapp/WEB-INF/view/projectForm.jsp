<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 18/05/2025
  Time: 9:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Create Project</title>
</head>
<body>
<h2>Create New Project</h2>

<form:form method="post" action="create" modelAttribute="project" enctype="multipart/form-data">
  <table>
    <tr>
      <td>Name:</td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td>Description:</td>
      <td><form:textarea path="description"/></td>
    </tr>
    <tr>
      <td>Documents:</td>
      <td><input type="file" name="documentFile"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Create Project"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>

