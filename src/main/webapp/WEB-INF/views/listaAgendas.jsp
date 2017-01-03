<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8>
	<title>Minhas Agendas</title>
	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath}/login.css" />
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
	<link rel="stylesheet" href="${cssPath}/bootstrap.css" />
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.css" />
	<link rel="stylesheet" href="${cssPath}/estilo.css" />

</head>
<body>
<c:import url="menuNav.jsp"></c:import>
	<section class="container">
		<fieldset>
			<legend>Lista de Agendas</legend>

				<table class="table table-striped">
					<tr>
						<th>ID:</th>
						<th>Procedimento:</th>
						<th>Data:</th>
						<th>Deletar:</th>
					</tr>
					<c:forEach items="${agendas }" var="agenda">
						<security:authentication property="principal" var="logado"/>
							<c:if test="${logado.id.equals(agenda.usuario.id) }">
								<form:form servletRelativeAction="/agendapsf/deletarAgenda" method="post">
									<tr>
										<th><input value="${agenda.id }" name="id" class="input_falso"></th>
										<th>${agenda.procedimento.descricao }</th>
										<th><fmt:formatDate pattern="dd/MM/yyyy" value="${agenda.dataAtendimento}" /></th>
										<th><button type="submit" class="btn btn-default btn-xs">
											  <span class="glyphicon glyphicon-trash"></span>
											</button>
										</th>
										
									</tr>
								</form:form>
							</c:if>
					</c:forEach>
				</table>
			
		</fieldset>
	</section>
		

</body>
</html>