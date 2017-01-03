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
	<section class="containeredit editdelet">
		<fieldset>
			<legend>Cadastro de Usuário</legend>
			<form:form servletRelativeAction="/agendapsf/editusuario" method="POST">
				<div>
					<select name="id" class="input_falso">
						<option value="${usuarios.id }" >${usuarios.id } </option>
					</select>
				</div>
				<div>
					<label>Nome</label> 
					<input type="text" class="form-control maioredit"  name="nomeUsuario" value="${usuarios.nomeUsuario }"/>	
					<form:errors path="Usuario.nomeUsuario" />					
				</div>
				<div>
					<label>Cartão SUS</label> 
					<input type="text" class="form-control maioredit"	name="cartSUS" value="${usuarios.cartSUS }">
					<form:errors path="Usuario.CartSUS"/>	
				</div>
				<div>
					<label>Endereço</label> <input type="text" class="form-control maioredit"
						name="enderecoUsuario"  value="${usuarios.enderecoUsuario }">
				</div>
				<div>
					<label>Cidade</label> <input type="text" class="form-control maioredit"
						name="cidadeUsuario" value="${usuarios.cidadeUsuario }">
				</div>
				<div>
					<label>Estado</label> <select name="UF" class="form-control maioredit"
						id="uf">
						<option value="${usuarios.UF}" selected>${usuarios.UF}</option>
						<c:forEach items="${UF}" var="UF">
							<option value="${UF}">${UF}</option>
							
						</c:forEach>
					</select>
				</div>
				<div class="contato">
					<label>Telefone</label> <input type="text" name="telefone"
						placeholder="73 3291-9092" value="${usuarios.telefone }">
				</div>
				<div class="contato">
					<label>Celular</label> <input type="text" name="celular"
						placeholder="73 999998888" value="${usuarios.celular }">
				</div>
				<div>
					<label>Posto de Saúde</label> 
					<select name="postosaude.id" class="form-control maioredit" >
						<option value="${usuarios.postosaude.id}">${usuarios.postosaude.nomePsf}</option>
						<c:forEach items="${postos}" var="posto">
							<option value="${posto.id}">${posto.nomePsf}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label>Senha</label> <input type="text" name="senha"
						class="form-control" id="password">
				</div>

				<button type="submit" class="btn btn-primary" id="cadastrar">Salvar</button>

			</form:form>


		</fieldset>
	</section>
	<section class="containeredit editdelet" id="editar">
		<fieldset>
			<legend>Editar / Deletar Usuário</legend>
				<form:form servletRelativeAction="/agendapsf/buscarUsuario">
					<div>
						<label>Digite o cartão SUS do usuário</label>
					</div>
					<div>
						<input type="text" name="cartao" class="form-control maioredit">
						<button type="submit" class="btn btn-primary" >Buscar</button>
					</div>
				</form:form>
			<form:form servletRelativeAction="/agendapsf/deletarUsuario">
				<div>
					<label>Usuário Buscado</label>
					<select name="id" class="form-control maioredit">
							<option value="${usuarios.id}">${usuarios.nomeUsuario } </option>
					</select> 
				</div>
				<div>
					<button type="submit" class="btn btn-primary" >Deletar</button>
				</div>
			</form:form>
		</fieldset>
		
		
	</section>
	</section>

</body>
</html>