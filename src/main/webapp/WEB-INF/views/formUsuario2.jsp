<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Cadastro do usuario</title>
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
			<legend>Cadastro de Usuário</legend>
			<form:form servletRelativeAction="/agendapsf/usuario" method="POST">
				<div>
					<label>Nome</label> <input type="text" class="form-control"
						placeholder="Nome do usuário" name="nomeUsuario">
				</div>
				<div>
					<label>Cartão SUS</label> <input type="text" class="form-control"
						name="cartSUS">
				</div>
				<div>
					<label>Endereço</label> <input type="text" class="form-control"
						name="enderecoUsuario">
				</div>
				<div>
					<label>Cidade</label> <input type="text" class="form-control"
						name="cidadeUsuario">
				</div>
				<div>
					<label>Estado</label> <select name="UF" class="form-control"
						id="uf">
						<c:forEach items="${UF}" var="UF">
							<option value="${UF}">${UF}</option>
						</c:forEach>
					</select>
				</div>
				<div class="contato">
					<label>Telefone</label> <input type="text" name="telefone"
						placeholder="73 3291-9092">
				</div>
				<div class="contato">
					<label>Celular</label> <input type="text" name="celular"
						placeholder="73 999998888">
				</div>
				<div>
					<label>Posto de Saúde</label> <select name="postosaude.id"
						class="form-control">
						<c:forEach items="${postos}" var="posto">
							<option value="${posto.id}">${posto.nomePsf}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label>Senha</label> <input type="text" name="senha"
						class="form-control" id="password">
				</div>

				<button type="submit" class="btn btn-primary" id="cadastrar">Cadastrar</button>

			</form:form>


		</fieldset>
	</section>
	<section class="separador"></section>
	<section class="container">
		<fieldset>
			<legend>Editar / Deletar Usuário</legend>
				<form:form servletRelativeAction="/agendapsf/buscarUsuario">
					<div>
						<label>Digite o cartão SUS do usuário</label>
					</div>
					<div>
						<input type="text" name="cartao" class="form-control">
						<button type="submit" class="btn btn-primary" >Buscar</button>
					</div>
				</form:form>
			<form:form servletRelativeAction="/agendapsf/deletarUsuario">
				<div>
					<label>Usuário Buscado</label>
					<select name="id" class="form-control">
							<option value="${usuarios.id}">${usuarios.nomeUsuario } </option>
					</select> 
				</div>
				<div>
					<button type="submit" class="btn btn-primary" >Deletar</button>
				</div>
			</form:form>
		</fieldset>
		
		
	</section>

</body>
</html>