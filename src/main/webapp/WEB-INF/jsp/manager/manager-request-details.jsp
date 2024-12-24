<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Request Details</title>
    <link rel="stylesheet" href="/styles/main.css">
</head>
<body>
    <header>
        <h1>Request Details</h1>
    </header>
    <main>
        <!-- Проверка на наличие объекта request -->
        <c:choose>
            <c:when test="${not empty request}">
                <table border="1" cellpadding="10" cellspacing="0">
                    <tr>
                        <th>Request ID</th>
                        <td>${request.id}</td>
                    </tr>
                    <tr>
                        <th>Title</th>
                        <td>${request.title}</td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>${request.description}</td>
                    </tr>
                    <tr>
                        <th>Creation Date</th>
                        <td><fmt:formatDate value="${request.creationDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    <tr>
                        <th>Deadline</th>
                        <td><fmt:formatDate value="${request.deadline}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                    <tr>
                        <th>Status</th>
                        <td>${request.status}</td>
                    </tr>
                    <tr>
                        <th>Client ID</th>
                        <td>${request.clientID}</td>
                    </tr>
                    <tr>
                        <th>Manager ID</th>
                        <td>${request.managerID}</td>
                    </tr>
                    <tr>
                        <th>Lead ID</th>
                        <td>${request.leadID}</td>
                    </tr>
                    <tr>
                        <th>Project Team ID</th>
                        <td>${request.projectTeamID}</td>
                    </tr>
                </table>

                 <a href="${pageContext.request.contextPath}/manager/request/accept.html?id=${request.id}">Accept</a>
                 <a href="${pageContext.request.contextPath}/manager/request/reject.html?id=${request.id}">Reject</a>

                <p><a href="${pageContext.request.contextPath}/manager/requests.html">Back to Requests</a></p>
            </c:when>
            <c:otherwise>
                <p>No request details available.</p>
            </c:otherwise>
        </c:choose>
    </main>
    <footer>
        <p>&copy; 2024 Your Company</p>
    </footer>
</body>
</html>
