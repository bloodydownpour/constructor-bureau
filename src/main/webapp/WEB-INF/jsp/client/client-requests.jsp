<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="u" tagdir="/WEB-INF/tags"%>

<u:page title="Your Requests"
    css="${['/css/client/client-styles.css']}">
        <c:choose>
            <c:when test="${not empty requests}">
                <table border="1" cellpadding="10" cellspacing="0">
                    <thead class="client-background">
                        <tr>
                            <th>Request ID</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Creation Date</th>
                            <th>Deadline</th>
                            <th>Status</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="request" items="${requests}">
                            <tr>
                                <td>${request.id}</a></td>
                                <td>${request.title}</td>
                                <td>${request.description}</td>
                                <td><fmt:formatDate value="${request.creationDate}" pattern="dd.MM.yyyy" /></td>
                                <td><fmt:formatDate value="${request.deadline}" pattern="dd.MM.yyyy" /></td>
                                <td>${request.status}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/client/details.html?id=${request.id}">View Details</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <p><a href="${pageContext.request.contextPath}/client/request/new.html">Create a new request</a>.</p>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>No requests found. <a href="${pageContext.request.contextPath}/client/request/new.html">Create a new request</a>.</p>
            </c:otherwise>
        </c:choose>
</u:page>
