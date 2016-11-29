<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html >
<html>
<head>
	<meta charset=UTF-8>
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
			<legend>Cadastro do Posto de Saúde Familiar</legend>
			<form:form servletRelativeAction="/agendapsf/posto" method="post">
				<div>
					<label>Nome do Posto</label>
					<input type="text" name="nomePsf" class="form-control">
				</div>
				<div>
					<label>Endereço</label>
					<input type="text" name="endPsf" class="form-control">
				</div>
				<div>
					<label>Cidade</label>
					<input type="text" name="cidadePsf" class="form-control">
				</div>
				<div>
					<label>Estado</label>
					<select name="UF">
						<c:forEach items="${UF}" var="UF">
							<option value="${UF}">${ UF}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Gravar</button>
				</div>
			</form:form>
			
			<form:form servletRelativeAction="/agendapsf/deletarpsf">
				<div>
					<label>Posto de Saúde</label>
				</div>
				<select name="id" class="form-control">
					<c:forEach items="${postos }" var="posto">
						<option value="${posto.id }">${posto.id } - ${posto.nomePsf }</option>
					</c:forEach>	
				</select>

				<button type="submit" class="btn btn-primary">Deletar</button>
		
			</form:form>
		</fieldset>
	</section>

</body>
</html>