<%@page contentType="text/html;charset=UTF-8"%>
 <%@taglib prefix="c" uri="jakarta.tags.core"%>
 <%@taglib prefix="u" tagdir="/WEB-INF/tags"%>
 <%--@elvariable id="session_user" type="by.vsu.ist.domain.User"--%>
 <c:set var="user_css" value="${'css/login-styles.css'}"/>
 <c:if test="${not empty session_user}">
 	<c:choose>
 		<c:when test="${session_user.role == 'MANAGER'}">
 			<c:set var="user_css" value="${'/css/manager/manager-styles.css'}"/>
 		</c:when>
 		<c:when test="${session_user.role == 'CLIENT'}">
 			<c:set var="user_css" value="${'/css/client/client-styles.css'}"/>
 		</c:when>
 		<c:when test="${session_user.role == 'CONSTRUCTOR'}">
 			<c:set var="user_css" value="${'/css/constructor/constructor-styles.css'}"/>
 		</c:when>
 	</c:choose>
 </c:if>

 <u:page title='Конструкторское бюро "Равшан & Джамшут"'
 css="${['/css/login-styles.css']}">
 	<h2 class="page_title primary-color" styles="text-align: center;">Авторизация</h2>
 	<c:url var="url__login_perform" value="${'/login/perform.html'}"/>
 	<form action="${url__login_perform}" method="post" class="form">
 		<div class="input_block">
 			<label for="login-input">Имя пользователя:</label>
 			<input type="text" id="login-input" name="login">
 		</div>
 		<div class="input_block">
 			<label for="password-input">Пароль:</label>
 			<input type="password" id="password-input" name="password">
 		</div>
 		<div class="buttons_block">
 			<button type="submit" class="button button__primary">Войти</button>
 		</div>
 	</form>
 </u:page>