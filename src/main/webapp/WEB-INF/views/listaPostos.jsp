<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<legend>Listagem de Postos de Saúde Cadastrados</legend>
			<ul>
				<c:forEach items="${postos }" var="posto">
				<dl>
				
					<dt> <label>Nome:</label> ${posto.nomePsf }</dt>
					<dd> <label> Endereço:</label> ${posto.endPsf } </dd>
					<dd> <label> Cidade: </label> ${posto.cidadePsf } </dd>
				</dl>
				</c:forEach>
			</ul>
		</fieldset>
	</section>
	

</body>
</html>