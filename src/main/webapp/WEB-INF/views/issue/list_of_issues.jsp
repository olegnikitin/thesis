<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 16.01.2015
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <style><%@include file="../../../resources/css/style.css" %></style>
  <title>List of issues</title>
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
</head>
<body>
<h1>List of issues</h1>
<c:if test="${!empty issueList}">
  <table style="width: 100%" border="1">
    <tr>
      <td>nameOfIssue</td>
      <td>description</td>
      <td>priority</td>
      <td>type</td>
      <td>dateOfCreation</td>
      <td>dateOfModification</td>
      <td>statusOfTheTask</td>
      <td>modifications</td>
    </tr>

    <tr>
      <c:forEach items="${issuesList}" var="issue">
        <td>${issue.nameOfIssue}</td>
        <td>${issue.description}</td>
        <td>${issue.priority}</td>
        <td>${issue.type}</td>
        <td>${issue.dateOfCreation}</td>
        <td>${issue.dateOfModification}</td>
        <td>${issue.statusOfTheTask}</td>
        <td>
          <a href="/my/projects/${project_id}/issues/${issue.id}/edit">Edit issue</a>
          <a href="/my/projects/${project_id}/issues/${issue.id}/delete">Delete issue</a>
        </td>
      </c:forEach>
    </tr>
  </table>
</c:if>
<c:if test="${empty issueList}">
  <h2>There is no issues in the project</h2>
</c:if>
</body>
</html>
