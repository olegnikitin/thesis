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

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Edit project</title>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">

    <!-- Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <style><%@include file="../../../resources/css/styles.css" %></style>
    <style>
        <%@include file="../../../resources/css/error.css" %>
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="main">

    <%@ include file="../parts/header.jsp" %>

    <div class="container-fluid">
        <h2>Edit project</h2>
        <form:form method="post" modelAttribute="dto">
            <form:errors path="*" cssClass="errorblock" element="div" />

            Enter the name of project <br/>
            <form:input path="nameOfTheProject"/><br/>
            Enter the description of the project<br/>
            <form:input path="descriptionOfTheProject"/><br/>
            Select the lead of the project<br/>

            <c:if test="${!empty userList}">
                <form:select path="leadOfTheProject">
                    <c:forEach items="${userList}" var="user">
                        <option value="${user.id}" <c:if test="user.id == project.leadOfTheProject.id">selected</c:if> >${user.firstName} ${user.lastName}</option>
                    </c:forEach>
                </form:select>
            </c:if><br/>

            <c:if test="${!empty issueList}">
                <h3>Edit the project's issues</h3>
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
                            <td><a href="/my/projects/${dto.id}/issues/${issue.id}/update">Update</a>
                                <a href="/my/projects/${dto.id}/issues/${issue.id}/delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty issueList}">
                <h3>There are no issues for now</h3>
            </c:if>

            <form:button>Edit</form:button>
        </form:form>
    </div>

    <%@ include file="../parts/footer.jsp" %>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
