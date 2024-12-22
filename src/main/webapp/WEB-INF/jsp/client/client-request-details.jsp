<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="your.package.Request" %>
<%@ page import="java.util.List" %>
<%@ page import="your.package.Project" %>

<%
    Long requestId = Long.parseLong(request.getParameter("requestID"));
    ClientController clientController = (ClientController) application.getAttribute("clientController");

    Request request = clientController.getRequestById(requestID).orElse(null);
    List<Project> projects = clientController.getProjectsByRequestId(requestID);
%>

<html>
<head>
    <title>Детали заявки</title>
</head>
<body>
    <h1>Детали заявки ID: <%= request.getId() %></h1>
    <p>Статус: <%= request.getStatus() %></p>

    <h2>Связанные проекты</h2>
    <ul>
        <%
            for (Project project : projects) {
        %>
        <li><%= project.getName() %></li>
        <%
            }
        %>
    </ul>
</body>
</html>
