<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 11.04.2015
  Time: 12:46
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
  <title>Admin page</title>
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

  <div class="container">
    <h2>Try this links:</h2>
    <a href="/my/projects/create">Create project</a><br/>
    <a href="/my/projects/project=1/issues/create">Create issue for first project</a><br/>
    <a href="/admin/projects/">List of all projects</a><br/>
    <a href="/my/projects/project=1/issues">List of issues of first project</a><br/>
    <br/>
    And change this page
  </div>

  <%@ include file="parts/footer.jsp" %>
</div>
</body>
</html>