<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="u" tagdir="/WEB-INF/tags"%>

<u:page title="Добавить заявку"
    css="${['/css/client/client-styles.css']}">
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
                        <td><fmt:formatDate value="${request.creationDate}" pattern="dd.MM.yyyy" /></td>
                    </tr>
                    <tr>
                        <th>Deadline</th>
                        <td><fmt:formatDate value="${request.deadline}" pattern="dd.MM.yyyy" /></td>
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
                </table>
                <p><a href="${pageContext.request.contextPath}/client/requests.html">Back to Requests</a></p>
            </c:when>
            <c:otherwise>
                <p>No request details available.</p>
            </c:otherwise>
        </c:choose>
</u:page>
