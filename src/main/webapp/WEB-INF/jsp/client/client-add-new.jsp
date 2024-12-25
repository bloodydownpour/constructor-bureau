<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/client/client-styles.css">

    <title>Добавить заявку</title>
</head>
<body>
    <div class="header client-background">
		<h1 class="header__title">Конструкторское бюро "Равшан & Джамшут"</h1>
	</div>
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
</body>
</html>
