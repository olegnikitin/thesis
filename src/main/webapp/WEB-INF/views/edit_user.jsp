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
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Edit user</title>
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
    <h1>Edit your profile</h1><br/>
    <h2>Your login is <b><sec:authentication property="principal.username" /></b></h2><br/>
    <form:form method="post" modelAttribute="user">
      <form:errors path="*" cssClass="errorblock" element="div" />
      <table>
        <tr>
          <td>Your first name is</td>
          <td><input name="firstName"/></td>
        </tr>
        <tr>
          <td>Your middle name is</td>
          <td><input name="middleName" /></td>
        </tr>
        <tr>
          <td>Your last name is</td>
          <td><input name="lastName" /></td>
        </tr>
        <tr>
          <td>Your email is</td>
          <td><input name="email" /></td>
        </tr>
        <tr>
          <td>Your password is</td>
          <td><input name="password" type="password" /></td>
        </tr>
      </table>
      <button type="submit">Edit</button>
    </form:form>
  </div>

  <%@ include file="parts/footer.jsp" %>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
