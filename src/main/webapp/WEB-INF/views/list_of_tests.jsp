<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 13.01.2015
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of tests</title>
</head>
<body>
<h2>List of goods</h2>
<c:if test="${!empty testList}">
  <table style="width: 100%" border="1">
    <tr style="background-color: gray">
      <td>Col1</td>
      <td>Col2</td>
      <td>Operations</td>
    </tr>
    <c:forEach items="${testList}" var="test">
      <tr>
        <td>${test.col1}</td>
        <td>${test.col2}</td>
        <td>
          <a href="test_edit=${goods.id}">Edit</a>
          <a href="delete_test=${goods.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
