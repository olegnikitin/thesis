<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 18.01.2015
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
    <style>
        <%@include file="../../../resources/error.css" %>
    </style>
</head>
<body>
<h2>Edit project</h2>
<form:form method="post" modelAttribute="project">
    <form:errors path="*" cssClass="errorblock" element="div" />

    Enter the name of project <br/>
    <form:input path="nameOfTheProject"/><br/>
    Enter the description of the project<br/>
    <form:input path="descriptionOfTheProject"/><br/>
    Select the lead of the project<br/>

    <c:if test="${!empty userList}">
        <select id="lead" name="lead">
            <c:forEach items="${userList}" var="user">
                <option name="${user.login}">${user.firstName} ${user.lastName}</option>
            </c:forEach>
        </select>

    </c:if><br/>

    <c:if test="${!empty issueList}">
        <h3>Edit your issues</h3>
        <table>
            <tr>
                <td>Name of issue</td>
                <td>Description</td>
                <td>Operations</td>
            </tr>
            <c:forEach items="${issueList}" var="issue">
                <tr>
                    <td>${issue.nameOfIssue}</td>
                    <td>${issue.description}</td>
                    <td><a href="issues/update=${issue.id}">Update</a>
                    <a href="issues/delete=${issue.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty issueList}">
        <h2>There are no issues for now</h2>
    </c:if>

    <form:button>Edit</form:button>
</form:form>
</body>
</html>
