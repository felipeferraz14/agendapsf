<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
	<title>Agendamento</title>
	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath}/estilo.css"/>	
	
</head>
<body>
	<div class="barra-superior" >
		<a href="/agendapsf/"> <img alt="Posto de Saúde" src="imagens/LOGOESFmenor.png"></a> 
		Posto Saúde Familiar
	</div>
	<section class="container">
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li><a href="/agendapsf/formAgenda">Agendamento</a></li>
		        <li><a href="/agendapsf/listaAgendas">Meus Agendamentos</a></li>
		        <li><a href="/agendapsf/eventos">Eventos</a></li>
		        <li><a href="/agendapsf/unidades">Unidades de atendimento</a></li>

		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastros <span class="caret"></span></a>
		          <ul class="dropdown-menu">		   
		          	<li><a href="/agendapsf/formEventos">Eventos</a></li>         
		          	<li><a href="/agendapsf/formProced">Procedimentos</a></li>
		            <li><a href="/agendapsf/formPsf">Unidades</a></li>
		            <li><a href="/agendapsf/formUsuario">Usuários</a></li>
		          </ul>
		       
		        </li>
		        <li class="dropdown">
		          <a href="/agendapsf/logout" role="button" >Sair</a>
		        </li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		
</section>
<script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
<script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
<script>
  $(function () {
    $('.dropdown-toggle').dropdown();
  }); 
</script>


</body>
</html>