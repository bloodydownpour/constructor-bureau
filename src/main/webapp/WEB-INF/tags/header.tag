<%@tag pageEncoding="UTF-8"%>
<div class="header background">
		<h1 class="header__title">Конструкторское бюро "Равшан & Джамшут"</h1>
		<c:if test="${not empty session_user}">
            <div  class="header__title" style="float: right;">
                <a href="${pageContext.request.contextPath}/logout/perform.html">Logout</a>
            </div>
		</c:if>
</div>