<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 07.02.2015
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new issue</title>
    <style>
        <%@include file="../../../resources/css/error.css" %>
    </style>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
<h2>Create new issue</h2>
<form:form method="post" modelAttribute="issue">
    <form:errors path="*" cssClass="errorblock" element="div" />

    Enter the name of issue<br/>
    <form:input path="nameOfIssue"/><br/>
    Enter the description<br/>
    <form:textarea path="description"/><br/>
    Select the priority<br/>
    <form:select path="priority" items="${listOfPriorities}" size="1"/><br/>
    Select the type of the task<br/>
    <form:select path="type" items="${listOfTypes}" size="1"/><br/>
    Select the status of the task<br/>
    <form:select path="statusOfTheTask" items="${listOfStatuses}" size="1"/><br/>
    <!-- Add a screenshots -->
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
