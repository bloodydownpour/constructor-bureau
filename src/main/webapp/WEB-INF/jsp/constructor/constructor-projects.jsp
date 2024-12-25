<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список проектов</title>
                <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/constructor/constructor-styles.css">


</head>
<body>
    <div class="header constructor-background">
		<h1 class="header__title">Конструкторское бюро "Равшан & Джамшут"</h1>
	</div>
    <h1>Заявка</h1>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Название проекта</th>
            <th>Статус</th>
            <th>ID заявки</th>
            <th>ID главного конструктора</th>
            <th>ID команды</th>
            <th>Детали</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="project" items="${projects}">
            <tr>
                <td>${project.id}</td>
                <td>${project.name}</td>
                <td>${project.status}</td>
                <td>${project.requestID}</td>
                <td>${project.leadID}</td>
                <td>${project.teamID}</td>
                <td><a href="${pageContext.request.contextPath}/constructor/details.html?id=${project.id}">View Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
