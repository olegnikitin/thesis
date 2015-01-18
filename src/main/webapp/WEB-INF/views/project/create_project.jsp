<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 18.01.2015
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new project</title>
</head>
<body>
<div>
  <h2>Create project</h2>
  <form:form>
    Enter the name of project <br/>
    <form:input path="nameOfTheProject"/>
    <form:errors path="nameOfTheProject" cssClass="error" /><br/>
    Select the lead of the project

    <button type="submit">Create</button>
  </form:form>
</div>
</body>
</html>
