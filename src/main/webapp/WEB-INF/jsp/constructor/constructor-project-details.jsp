<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project Details</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/constructor/constructor-styles.css">
    <style>
            #update-form-container {
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
    <div class="header constructor-background">
		<h1 class="header__title">Конструкторское бюро "Равшан & Джамшут"</h1>
	</div>
    <header>
        <h1>Project Details</h1>
    </header>
    <main>
        <!-- Проверка на наличие объекта request -->
        <c:choose>
            <c:when test="${not empty project}">
                <table border="1" cellpadding="10" cellspacing="0">
                    <tr>
                        <th>ID</th>
                        <td>${project.id}</td>
                    </tr>
                    <tr>
                        <th>Имя проекта</th>
                        <td>${project.name}</td>
                    </tr>
                    <tr>
                        <th>Статус проекта</th>
                        <td>${project.status}</td>
                    </tr>
                    <tr>
                        <th>ID заявки</th>
                        <td>${project.requestID}</td>
                    </tr>
                    <tr>
                        <th>ID главного конструктора</th>
                        <td>${project.leadID}</td>
                    </tr>
                    <tr>
                        <th>ID команды</th>
                        <td>${project.teamID}</td>
                    </tr>
                </table>

                <button id="status-btn">Обновить статус</button>
                <div id="update-form-container">
                            <form action="${pageContext.request.contextPath}/constructor/details/update" method="get">

                              <label for="status">Статус </label><br>
                              <input type="hidden" id="id" name="id" value = "${project.id}"/>
                              <input type="text" id="status" name="status" required><br><br>
                              <button type="submit">Обновить</button>
                            </form>
                          </div>

                <p><a href="${pageContext.request.contextPath}/constructor/projects.html">Back to projects</a></p>
            </c:when>
            <c:otherwise>
                <p>No project details available.</p>
            </c:otherwise>
        </c:choose>
        <script>
        const StatusBtn = document.getElementById('status-btn');
        const StatusFormContainer = document.getElementById('update-form-container');
        StatusBtn.addEventListener('click', () => {
            StatusFormContainer.style.display = 'block';
            });
        </script>
    </main>
    <footer>
        <p>&copy; 2024 Your Company</p>
    </footer>
</body>
</html>
