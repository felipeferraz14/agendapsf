<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html >
<html>
<head>
	<meta charset=utf-8>
	<title>Agenda PSF</title>
	<c:url value="/resources/css" var="cssPath" />
	<c:url value="/resources/js" var="jsPath" />
	<link rel="stylesheet" href="${cssPath}/tela-login.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.css"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap-theme.css"/>
	<link rel="stylesheet" href="${jsPath}/bootstrap.js"/>
	<link rel="stylesheet" href="${jsPath}/bootstrap.min.js"/>

	
</head>
<body>

		<img alt="Logo Posto" src="imagens/LOGO_ESF.png">

	<section class="container-principal">
		<div class="tela-login">
			<form:form servletRelativeAction="/login" method="post" cssClass="form-horizontal">
			  <div class="form-group">
			    <label for="login" class="col-sm-2 control-label">Cartão SUS</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="login" placeholder="Cartão SUS" name="username">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="senha" class="col-sm-2 control-label">Senha</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="senha" placeholder="senha" name="password">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Lembrar-me
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Acessar</button>
			    </div>
			  </div>
			  <a class="btn btn-primary btn-large" data-toggle="modal" data-target="#myModal">Cadastre-se </a>		 
			</form:form>
		</div>
		<button type="button" class="btn btn-primary btn-lg" >
		  Launch demo modal
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Cadastre-se</h4>
		      </div>
		      <div class="modal-body">
		        <p>Para se cadastrar, é necessário que se dirija a um posto de atendimento mais
		        próximo a sua residência. 
		      </div>
		    </div>
		  </div>
		</div>
	</section>
	
	<script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
	<script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>﻿
		

</body>
</html>