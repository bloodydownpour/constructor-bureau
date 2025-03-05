<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="u" tagdir="/WEB-INF/tags"%>

<u:page title="Список проектов"
    css="${['/css/constructor/constructor-styles.css']}">
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
</u:page>
