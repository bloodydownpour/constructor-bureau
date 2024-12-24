<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список заявок</title>
</head>
<body>
    <h1>Заявка</h1>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Заголовок</th>
            <th>Описание</th>
            <th>Статус</th>
            <th>Клиент</th>
            <th>Дедлайн</th>
            <th>Детали</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="request" items="${requests}">
            <tr>
                <td>${request.id}</td>
                <td>${request.title}</td>
                <td>${request.description}</td>
                <td>${request.status}</td>
                <td>${request.clientID}</td>
                <td><fmt:formatDate value="${request.deadline}" pattern="dd.MM.yyyy" /></td>
                <td><a href="${pageContext.request.contextPath}/manager/details.html?id=${request.id}">View Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
