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
<%@page session="true"%>
<html>
<head>
    <title>Login Page</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
  <style>
    .error {
      padding: 15px;
      margin-bottom: 20px;
      border: 1px solid transparent;
      border-radius: 4px;
      color: #a94442;
      background-color: #f2dede;
      border-color: #ebccd1;
    }

    #login-box {
      width: 300px;
      padding: 20px;
      margin: 100px auto;
      background: #fff;
      -webkit-border-radius: 2px;
      -moz-border-radius: 2px;
      border: 1px solid #000;
    }
  </style>
</head>
<body onload='document.loginForm.username.focus();'>

<div id="login-box">

  <h1>${page_title}</h1>
  <c:if test="${not empty error}">
    <div class="error">${login_error}</div>
  </c:if>

  <div class="input-group">
    <form name='loginForm' action="<c:url value='/login' />" method='POST'>

      <table>
        <tr>
          <td>Login:</td>
          <td><input type='text' name='login' value=''
                     class="form-control" placeholder="admin" /></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type='password' name='password'
                     class="form-control" placeholder="password" /></td>
        </tr>
        <tr>
          <td colspan='2'><input name="submit" type="submit"
                                 class="btn btn-default" value="Submit" /></td>
        </tr>
      </table>


    </form>
  </div>
</div>

</body>
</html>