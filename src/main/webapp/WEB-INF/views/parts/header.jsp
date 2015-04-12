<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 11.04.2015
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>
  <nav class="navbar navbar-static-top top-marg">
    <div class="container">
      <ul class="nav nav-tabs">
        <li role="presentation" class="active"><a href="/">Home</a></li>
        <li role="presentation"><a href="/my/">Profile</a></li>
        <li role="presentation"><a href="/admin/">Admin page</a></li>
        <li role="presentation">
          <form class="navbar-form" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
          </form>
        </li>
        <li role="presentation" class="navbar-right"><a href="/registration">Registration</a></li>
        <li role="presentation" class="navbar-right"><a href="/auth/logout">Logout</a></li>
      </ul>
    </div>
  </nav>
</header>
