<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 15.01.2015
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Login Page</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

  <style><%@include file="../../../resources/css/login.css" %></style>
  <script type="text/javascript"><%@include file="../../../resources/js/loginPageJS.js" %></script>

</head>

<body onload='document.form-group.login.focus();'>
<c:if test="${not empty error}">
  <div class="error">${login_error}</div>
</c:if>

<section id="login">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <div class="form-wrap">
          <h1>Log in</h1>
          <form method="post" id="login-form" action="<c:url value='/login' />">
            <div class="form-group">
              <input type="login" id="email" class="form-control" placeholder="Login" name="login">
            </div>
            <div class="form-group">
              <input type="password" id="key" class="form-control" placeholder="Password" name="password">
            </div>
            <div class="checkbox">
              <span class="character-checkbox" onclick="showPassword()"></span>
              <span class="label">Show password</span>
            </div>
            <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Log in">
          </form>
          <hr>
        </div>
      </div> <!-- /.col-xs-12 -->
    </div> <!-- /.row -->
  </div> <!-- /.container -->
</section>

<footer id="footer">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <p>Oleg Nikitin - 2015</p>
      </div>
    </div>
  </div>
</footer>


</body>
</html>