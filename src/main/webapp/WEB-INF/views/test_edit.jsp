<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 12.01.2015
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="test_add">Add</a>
<form:form method="post" modelAttribute="test">
  <h1>Col1</h1><br/>
  <form:input path="col1"/><br/>
  <h1>Co21</h1><br/>
  <form:input path="col2"/>
  <button type="submit">Edit</button>
</form:form>
</body>
</html>
