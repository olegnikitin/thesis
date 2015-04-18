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

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Create new issue</title>
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
        <h2>Create new issue</h2>
        <form:form method="post" modelAttribute="issue">
            <form:errors path="*" cssClass="errorblock" element="div" />

            <table>
                <tr>
                    <td>Enter the name of issue</td>
                    <td><input name="nameOfIssue"/></td>
                </tr>
                <tr>
                    <td>Enter the description</td>
                    <td><form:textarea path="description"/></td>
                </tr>
                <tr>
                    <td>Select the priority</td>
                    <td><form:select path="priority" items="${listOfPriorities}" size="1"/></td>
                </tr>
                <tr>
                    <td>Select the type of the task</td>
                    <td><form:select path="type" items="${listOfTypes}" size="1"/></td>
                </tr>
                <tr>
                    <td>Select the status of the task</td>
                    <td><form:select path="statusOfTheTask" items="${listOfStatuses}" size="1"/></td>
                </tr>
                <!-- Add a screenshots -->
            </table>
            <form:button>Submit</form:button>
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
