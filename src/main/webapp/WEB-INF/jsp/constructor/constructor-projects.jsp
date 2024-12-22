<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="your.package.Project" %>

<%
    ConstructorController constructorController = (ConstructorController) application.getAttribute("constructorController");
    List<Project> projects = constructorController.getAllProjects();
%>

<html>
<head>
    <title>Проекты Конструктора</title>
</head>
<body>
    <h1>Список проектов</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Действия</th>
        </tr>
        <%
            for (Project project : projects) {
        %>
        <tr>
            <td><%= project.getId() %></td>
            <td><%= project.getName() %></td>
            <td>
                <a href="constructor-project-details.jsp?projectId=<%= project.getId() %>">Детали</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
