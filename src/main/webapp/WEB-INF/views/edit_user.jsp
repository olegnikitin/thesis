<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 18.01.2015
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<div>
  <h1>Edit your profile</h1>
  <form:form method="post" modelAttribute="user">
    <h2>Your login is <b><form:label path="login"/></b></h2><br/>
    Your first name is<br/>
    <form:input path="firstName"/><form:errors path="firstName" cssClass="error" /><br/>
    Your last name is<br/>
    <form:input path="lastName"/><form:errors path="lastName" cssClass="error" /><br/>
    Your email is<br/>
    <form:input path="email"/><form:errors path="email" cssClass="error" /><br/>
    Your password is<br/><!-- Bad idea. Delete later -->
    <form:password path="password"/><form:errors path="password" cssClass="error" /><br/>
    <!-- Add a group later -->
    <button type="submit">Edit</button>
  </form:form>
</div>
</body>
</html>