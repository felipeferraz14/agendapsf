<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<title>Postos de Saúde</title>
	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.css"/>
	<link rel="stylesheet" href="${cssPath}/estilo.css"/>
</head>
<body>
	<c:import url="menuNav.jsp"></c:import>
	<section class="container">
		<fieldset>
			<legend>Listagem de Eventos</legend>
			<ul>
				<c:forEach items="${eventos }" var="evento">
				<dl>
				
					<dt> <label>  Nome: </label> ${evento.nomeEvento }</dt>
					<dd> <label> Descrição: </label> ${evento.descricaoEvento } </dd>
					<dd> <label> Endereço:</label> ${evento.enderecoEvento } </dd>
					<dd> <label> Data: </label> <fmt:formatDate pattern="dd/MM/yyyy" value="${evento.dataEvento.time }" /> </dd>
				</dl>
				</c:forEach>
				<security:authorize access="hasAnyRole('ROLE_ADMIN')">
				<form:form servletRelativeAction="/agendapsf/enviarEventos" method="post">
				<div>
					<button type="submit" class="btn btn-primary">Enviar Eventos</button>
				</div>
				</form:form>
				</security:authorize>
			</ul>
		</fieldset>
	</section>
	

</body>
</html>