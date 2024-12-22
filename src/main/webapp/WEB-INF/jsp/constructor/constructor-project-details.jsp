<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="your.package.Project" %>
<%@ page import="your.package.ProjectTeam" %>

<%
    Long projectId = Long.parseLong(request.getParameter("projectID"));
    ConstructorController constructorController = (ConstructorController) application.getAttribute("constructorController");

    Project project = constructorController.getProjectById(projectID).orElse(null);
    List<ProjectTeam> team = constructorController.getTeamByProjectId(projectID);
%>

<html>
<head>
    <title>Детали проекта</title>
</head>
<body>
    <h1>Детали проекта: <%= project.getName() %></h1>
    <p>ID проекта: <%= project.getId() %></p>

    <h2>Команда проекта</h2>
    <table border="1">
        <tr>
            <th>ID Участника</th>
            <th>Роль</th>
        </tr>
        <%
            for (ProjectTeam member : team) {
        %>
        <tr>
            <td><%= member.getId() %></td>
            <td>Конструктор</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
