<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 16.01.2015
  Time: 12:36
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
  <title>List of issues</title>
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">

  <!-- Bootstrap -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
  <style><%@include file="../../../resources/css/styles.css" %></style>
  <style><%@include file="../../../resources/css/style.css" %></style>

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
    <h1>List of issues</h1>
    <c:if test="${!empty issueList}">
      <table style="width: 100%" border="1">
        <tr>
          <td>nameOfIssue</td>
          <td>description</td>
          <td>priority</td>
          <td>type</td>
          <td>dateOfCreation</td>
          <td>dateOfModification</td>
          <td>statusOfTheTask</td>
          <td>modifications</td>
        </tr>

        <tr>
          <c:forEach items="${issuesList}" var="issue">
            <td>${issue.nameOfIssue}</td>
            <td>${issue.description}</td>
            <td>${issue.priority}</td>
            <td>${issue.type}</td>
            <td>${issue.dateOfCreation}</td>
            <td>${issue.dateOfModification}</td>
            <td>${issue.statusOfTheTask}</td>
            <td>
              <a href="/my/projects/${project_id}/issues/${issue.id}/edit">Edit issue</a>
              <a href="/my/projects/${project_id}/issues/${issue.id}/delete">Delete issue</a>
            </td>
          </c:forEach>
        </tr>
      </table>
    </c:if>
    <c:if test="${empty issueList}">
      <h2>There is no issues in the project</h2>
    </c:if>

  </div>

  <%@ include file="../parts/footer.jsp" %>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
