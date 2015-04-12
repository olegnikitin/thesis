<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 15.01.2015
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Registration</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
<div>
  <p align="center"><h2>Create a account</h2></p>
  <sf:form method="POST" modelAttribute="user">
  <fieldset>
    <table cellspacing="0">
      <tr>
        <th><label for="user_first_name">First name:</label></th>
        <td><sf:input path="firstName" size="15" id="user_first_name"/>
          <sf:errors path="firstName" cssClass="error" /></td>
      </tr>
      <tr>
        <th><label for="user_last_name">Last name:</label></th>
        <td><sf:input path="lastName" size="15" id="user_last_name"/>
          <sf:errors path="lastName" cssClass="error" /></td>
      </tr>
      <tr>
        <th><label for="user_screen_name">Login:</label></th>
        <td><sf:input path="login" size="15" maxlength="15"
                      id="user_screen_name"/>
          <small id="username_msg">No spaces, please.</small>
          <sf:errors path="login" cssClass="error" />
        </td>
      </tr>
      <tr>
        <th><label for="user_password">Password:</label></th>
        <td><sf:password path="password" size="30"
                         showPassword="false"
                         id="user_password"/>
          <small>6 characters or more (be tricky!)</small>
          <sf:errors path="password" cssClass="error" />
        </td>
      </tr>
      <tr>
        <th><label for="user_email">Email Address:</label></th>
        <td><sf:input path="email" size="30"
                      id="user_email"/>
          <sf:errors path="email" cssClass="error" />
        </td>
      </tr>
    </table>
    <button type="submit">Submit</button>
  </fieldset>
  </sf:form>
</div>
</body>
</html>