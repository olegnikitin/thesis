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
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<div>
  <h2>Create project</h2>
  <form:form method="post" modelAttribute="project">
    <form:errors path="*" cssClass="errorblock" element="div" />

    Enter the name of project <br/>
    <form:input path="nameOfTheProject"/>
    <form:errors path="nameOfTheProject" cssClass="error" /><br/>
    Select the lead of the project<br/>
    <c:if test="${!empty userList}">
        <form:select path="leadOfTheProject">
            <c:forEach items="${userList}" var="user">
                <form:option value="${user.id}" label="${user.firstName} ${user.lastName}"/>
            </c:forEach>
        </form:select>
    </c:if>
    <form:errors path="leadOfTheProject" cssClass="error" /><br/>
    <c:if test="${empty userList}">
      There is no users <!-- Impossible -->
    </c:if>
    <form:button>Create</form:button>
  </form:form>
</div>
</body>
</html>
