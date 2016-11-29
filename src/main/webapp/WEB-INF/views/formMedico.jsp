<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html >
<html >
<head>
	<meta charset=UTF-8>
	<title>Cadastro do M�dico</title>
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
	
	
		<form:form servletRelativeAction="/agendapsf/medico" method="post">
			<fieldset>
				<legend>Cadastro M�dico</legend>
				<div class="form-group">
					<label>Nome do M�dico</label>
					<input type="text" name="nomeMedico" class="form-control">
				</div>
				<div class="form-group">
					<label>Conselho do M�dico</label>
					<input type="number" name="crmMedico" class="form-control" style="max-width:20%;" >
				</div>
				<button type="submit" class="btn btn-primary" >Gravar</button>
			</fieldset>
		</form:form>
	</section>
	



</body>
</html>