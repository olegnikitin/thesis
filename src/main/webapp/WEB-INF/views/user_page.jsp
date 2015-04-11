<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 11.04.2015
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Your page</title>
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">

  <!-- Bootstrap -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
  <style><%@include file="../../resources/css/styles.css" %></style>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="main">
  <%@ include file="parts/header.jsp" %>

  <div class="container-fluid">
    <div class="row">
      <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 blockOfItems">
        <h3>Your projects</h3>
        <c:if test="${!empty userProjects}">
          <ul class="nav nav-pills nav-stacked">
            <c:forEach items="${userProjects}" var="project">
              <li role="presentation"><a href="/my/projects/project/${project.id}">${project.nameOfTheProject}</a></li>
            </c:forEach>
          </ul>
        </c:if>
        <c:if test="${empty userProjects}">
          <h3>You don't have projects for now</h3>
        </c:if>
        <a class="btn btn-default" href="/my/projects/create" role="button">Create new project</a>
      </div>
      <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 blockOfItems">
        <h3>Your issues</h3>
        <c:if test="${!empty userIssues}">
          <table class="table">
            <tr class="info">
              <td>nameOfIssue</td>
              <td>description</td>
            </tr>
            <c:forEach items="${userIssues}" var="issue">
              <tr class="info">
                <td>${issue.nameOfIssue}</td>
                <td>${issue.description}</td>
              </tr>
            </c:forEach>
          </table>
        </c:if>
        <c:if test="${!empty userIssues}">
          <h3>You don't have issues for now</h3>
        </c:if>
      </div>
    </div>
  </div>

  <%@ include file="parts/footer.jsp" %>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
