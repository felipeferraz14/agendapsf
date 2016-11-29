<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE >
<html>
<head>
	<meta charset=utf-8>
	<title>Cadastro de Eventos</title>
	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath}/estilo.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.css"/>
</head>
<body>
	<c:import url="menuNav.jsp"></c:import>
	<section class="container">
		<fieldset>
			<legend>Cadastro de Eventos</legend>
			<form:form servletRelativeAction="/agendapsf/eventos" method="post">
				<div>
					<label>Nome do Evento</label>
					<input type="text" name="nomeEvento" class="form-control">
				</div>
				<div>
					<label>Descrição do Evento</label>
					<textarea rows="10" cols="20" name="descricaoEvento" class="form-control"></textarea>
				</div>
				<div>
					<label>Endereço do Evento</label>
					<input type="text" name="localEvento" class="form-control">
				</div>
				<div>
					<label>Data do Evento</label>
					<input type="date" name="dataEvento">
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Gravar</button>
				</div>
				
			</form:form>
			
			<form:form servletRelativeAction="/agendapsf/deletarevento" method="POST">
				<div>
					<label>Eventos</label>
					<select name="id" class="form-control">
						<c:forEach items="${eventos}" var="evento">
							<option value="${evento.id}">${evento.id} - ${evento.nomeEvento} </option>
						</c:forEach>
					</select> 
				</div>
					
				<button type="submit" class="btn btn-primary">Deletar</button>
			</form:form>
		
		
		</fieldset>
	</section>

</body>
</html>