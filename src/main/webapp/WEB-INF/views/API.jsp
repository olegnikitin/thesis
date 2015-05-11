<%--
  Created by IntelliJ IDEA.
  User: яна
  Date: 11.05.2015
  Time: 15:44
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
  <title>REST API</title>
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">

  <!-- Bootstrap -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
  <style><%@include file="../../resources/css/styles.css" %></style>
  <style><%@include file="../../resources/css/style.css" %></style>

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
    <center><h1>REST API</h1>
    <h2>Only for projects for now</h2></center>
    <table style="width: 100%" border="1">
      <tr>
        <td>Operation</td>
        <td>Link</td>
        <td>Method</td>
      </tr>

      <tr>
        <td>listOfProjects</td>
        <td>/rest/projects</td>
        <td>GET</td>
      </tr>
      <tr>
        <td>createProject</td>
        <td>/rest/projects/create</td>
        <td>POST</td>
      </tr>
      <tr>
        <td>getProjectById</td>
        <td>/rest/projects/{id}</td>
        <td>GET</td>
      </tr>
      <tr>
        <td>updateProject</td>
        <td>/rest/projects/update</td>
        <td>PUT</td>
      </tr>
      <tr>
        <td>deleteProject</td>
        <td>/rest/projects/{id}/delete</td>
        <td>DELETE</td>
      </tr>
    </table>
  </div>

  <%@ include file="parts/footer.jsp" %>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
