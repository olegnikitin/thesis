<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 15.01.2015
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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
  <style><%@include file="../../../resources/css/styles.css" %></style>

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

  <div class="container-fluid" style="align-content: center">
    <h2>Create a account</h2>
    <sf:form method="POST" modelAttribute="user">
      <sf:errors path="*" cssClass="errorblock" element="div" />
      <table>
        <tr>
          <td>First name:</td>
          <td><input name="firstName"></td>
        </tr>
        <tr>
          <td>Last name:</td>
          <td><input name="lastName"></td>
        </tr>
        <tr>
          <td>Login:</td>
          <td><input name="login"></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input name="password"></td>
        </tr>
        <tr>
          <td>Email:</td>
          <td><input name="email"></td>
        </tr>
      </table>
      <button type="submit">Submit</button>
    </sf:form>
  </div>

  <%@ include file="../parts/footer.jsp" %>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>