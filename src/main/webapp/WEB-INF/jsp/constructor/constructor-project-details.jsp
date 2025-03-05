<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="u" tagdir="/WEB-INF/tags"%>
<u:page title="Project Details"
    css="${['/css/constructor/constructor-styles.css', '/css/constructor/constructor-extra-styles.css']}">
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
</u:page>

