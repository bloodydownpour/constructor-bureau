<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Client Requests</title>
    <link rel="stylesheet" href="/styles/main.css"> <!-- Добавьте свой файл стилей -->
</head>
<body>
    <header>
        <h1>Your Requests</h1>
    </header>
    <main>
        <!-- Проверка на наличие заявок -->
        <c:choose>
            <c:when test="${not empty requests}">
                <table border="1" cellpadding="10" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Request ID</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Creation Date</th>
                            <th>Deadline</th>
                            <th>Status</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="request" items="${requests}">
                            <tr>
                                <td>${request.id}</a></td>
                                <td>${request.title}</td>
                                <td>${request.description}</td>
                                <td><fmt:formatDate value="${request.creationDate}" pattern="dd.MM.yyyy" /></td>
                                <td><fmt:formatDate value="${request.deadline}" pattern="dd.MM.yyyy" /></td>
                                <td>${request.status}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/client/details.html?id=${request.id}">View Details</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <p><a href="${pageContext.request.contextPath}/client/request/new.html">Create a new request</a>.</p>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>No requests found. <a href="${pageContext.request.contextPath}/client/request/new.html">Create a new request</a>.</p>
            </c:otherwise>
        </c:choose>


    </main>
    <footer>
        <p>&copy; 2024 Your Company</p>
    </footer>
</body>
</html>
