<%@tag pageEncoding="UTF-8"%>
<%@attribute name="title" type="java.lang.String" required="true" rtexprvalue="true"%>
<%@attribute name="css" type="java.util.List" required="false" rtexprvalue="true"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="u" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <c:if test="${not empty css}">
		<c:forEach var="css_item" items="${css}">
			<c:url var="url_css" value="${css_item}"/>
			<link rel="stylesheet" href="${url_css}">
		</c:forEach>
	</c:if>
</head>
<body>
<u:header/>
<div class="content">
    <jsp:doBody/>
</div>
</body>
</html>