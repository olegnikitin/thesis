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
</head>
<body>
<div>
  <p align="center"><h2>Create a account</h2></p>
  <sf:form method="POST" modelAttribute="user">
  <fieldset>
    <table cellspacing="0">
      <tr>
        <th><label for="user_first_name">First name:</label></th>
        <td><sf:input path="fullName" size="15" id="user_first_name"/>
          <sf:errors path="fullName" cssClass="error" /></td>
      </tr>
      <tr>
        <th><label for="user_screen_name">Username:</label></th>
        <td><sf:input path="login" size="15" maxlength="15"
                      id="user_screen_name"/> <!-- Поле имени пользователя -->
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
                      id="user_email"/> <!-- Поле электронной почты -->
          <small>In case you forget something</small>
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