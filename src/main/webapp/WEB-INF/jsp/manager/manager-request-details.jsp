<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
                <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/manager/manager-styles.css">

    <title>Manager: Details</title>
    <style>
        /* Скрываем форму по умолчанию */
        #accept-form-container {
          display: none;
          margin-top: 20px;
        }
        /* Стили для кнопки и формы */
        button {
          padding: 10px 20px;
          font-size: 16px;
          cursor: pointer;
        }
        form {
          border: 1px solid #ccc;
          padding: 20px;
          border-radius: 5px;
        }
      </style>
</head>
<body>
<div class="header manager-background">
		<h1 class="header__title">Конструкторское бюро "Равшан & Джамшут"</h1>
	</div>
    <header>
        <h1>Детали заявки</h1>
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
                        <th>Название</th>
                        <td>${request.title}</td>
                    </tr>
                    <tr>
                        <th>Описание</th>
                        <td>${request.description}</td>
                    </tr>
                    <tr>
                        <th>Дата создания</th>
                        <td><fmt:formatDate value="${request.creationDate}" pattern="dd.MM.yyyy" /></td>
                    </tr>
                    <tr>
                        <th>Дедлайн</th>
                        <td><fmt:formatDate value="${request.deadline}" pattern="dd.MM.yyyy" /></td>
                    </tr>
                    <tr>
                        <th>Статус заявки</th>
                        <td>${request.status}</td>
                    </tr>
                    <tr>
                        <th>ID клиента</th>
                        <td>${request.clientID}</td>
                    </tr>
                    <tr>
                </table>
                <button id="accept-btn">Accept</button>
                 <a href="${pageContext.request.contextPath}/manager/request/reject.html?id=${request.id}">Reject</a>

                <p><a href="${pageContext.request.contextPath}/manager/requests.html">Back to Requests</a></p>
            </c:when>
            <c:otherwise>
                <p>Нет нерассмотренных заявок.</p>
            </c:otherwise>
        </c:choose>

        <div id="accept-form-container">
            <form action="${pageContext.request.contextPath}/manager/request/accept.html" method="get">

              <label for="email">ID главного конструктора: </label><br>
              <input type="hidden" id="id" name="id" value = "${request.id}"/>
              <input type="text" id="leadid" name="leadid" required><br><br>

              <button type="submit">Accept</button>
            </form>
          </div>
    </main>
    <footer>
        <p>&copy; 2024 Your Company</p>
    </footer>
    <script>
        // Находим элементы
        const AcceptBtn = document.getElementById('accept-btn');
        const AcceptFormContainer = document.getElementById('accept-form-container');

        AcceptBtn.addEventListener('click', () => {
          // Переключение видимости формы
            AcceptFormContainer.style.display = 'block';
        });
      </script>
</body>
</html>
