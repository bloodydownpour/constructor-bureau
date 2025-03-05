<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="u" tagdir="/WEB-INF/tags"%>

<u:page title="Добавить заявку"
    css="${['/css/client/client-styles.css']}">
    <h1>Добавить заявку</h1>
    <form action="${pageContext.request.contextPath}/client/request/new.html" method="post">
        <label for="title">Название</label>
        <input type="text" id="title" name="title" required>
        <br><br>
        <label for="description">Описание</label>
        <textarea id="description" name="description" required></textarea>
        <br><br>
        <label for="deadline">Крайний срок</label>
        <input type="date" id="deadline" name="deadline">
        <br><br>
        <button type="submit">Сохранить</button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/client/requests.html">Назад к списку заявок</a>
</u:page>
