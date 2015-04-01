<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 18.01.2015
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new project</title>
    <style>
        <%@include file="../../../resources/error.css" %>
    </style>
</head>
<body>
<div>
  <h2>Create project</h2>
  <form:form method="post" modelAttribute="project">
    <form:errors path="*" cssClass="errorblock" element="div" />

    Enter the name of project <br/>
    <form:input path="nameOfTheProject"/><br/>
    Enter the description of the project<br/>
    <form:input path="descriptionOfTheProject"/><br/>
    Select the lead of the project<br/>
    <c:if test="${!empty userList}">
        <select id="leadOfTheProject" class="leadOfTheProject">
            <c:forEach items="${userList}" var="user">
                <option value="${user.id}">${user.firstName} ${user.lastName}</option>
            </c:forEach>
        </select>
    </c:if>
    <c:if test="${empty userList}">
      There is no users <!-- Impossible -->
    </c:if><br/>
    <form:button>Create</form:button>
  </form:form>
</div>
</body>
</html>
