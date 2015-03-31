<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Projects</title>
    <style><%@include file="../../../resources/style.css" %></style>
</head>
<body>
<h1>List of projects</h1>
<c:if test="${!empty projectsList}">
    <table style="width: 100%" border="1">
        <tr style="background-color: gray">
            <td>nameOfTheProject</td>
            <td>descriptionOfTheProject</td>
            <td>leadOfTheProject</td>
            <td>Modifications</td>
        </tr>
        <c:forEach items="${projectsList}" var="project">
            <tr>
                <td>${project.nameOfTheProject}</td>
                <td>${project.descriptionOfTheProject}</td>
                <td>${project.leadOfTheProject.toString}</td>
                <td>
                    <a href="project_edit=${project.id}">Edit project</a>
                    <a href="project_delete=${project.id}">Delete project</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty projectsList}">
    <h2>There is no projects</h2>
</c:if>
</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              