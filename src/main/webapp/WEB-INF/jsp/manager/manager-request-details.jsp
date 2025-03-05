<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="u" tagdir="/WEB-INF/tags"%>

<u:page title="Детали заявки"
    css="${['/css/manager/manager-styles.css', '/css/manager/manager-extra-styles.css']}">
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

    <script>
        // Находим элементы
        const AcceptBtn = document.getElementById('accept-btn');
        const AcceptFormContainer = document.getElementById('accept-form-container');

        AcceptBtn.addEventListener('click', () => {
          // Переключение видимости формы
            AcceptFormContainer.style.display = 'block';
        });
      </script>
</u:page>
