<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE >
<html>
<head>
	<meta charset=ISO-8859-1>
	<title>Cadastro</title>
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
			<legend>Cadastro de Procedimentos</legend>
			<form:form servletRelativeAction="/agendapsf/procedimentos" method="post">
				<div>
					<label>Descrição</label>
					<input type="text" name="descricao" class="form-control">
				</div>
				<button type="submit" class="btn btn-primary">Gravar</button>
			</form:form>
			
			<form:form servletRelativeAction="/agendapsf/procedimentosdeletar" method="POST">
				<div>
					<label>Procedimento</label>
					<select name="id" class="form-control">
						<c:forEach items="${procedimentos}" var="procedimento">
							<option value="${procedimento.id}">${procedimento.id} - ${procedimento.descricao} </option>
						</c:forEach>
					</select> 
				</div>
					
				<button type="submit" class="btn btn-primary">Deletar</button>
			</form:form>
		</fieldset>
	</section>
</body>
</html>