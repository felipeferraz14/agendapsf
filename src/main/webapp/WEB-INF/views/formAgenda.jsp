<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html >
<html>
<head>
	<meta charset=ISO-UTF-8>
	<title>Agendamento</title>
	<c:url value="/resources" var="resPath" />
	<link rel="stylesheet" href="${resPath}/css/estilo.css"/>
	<link rel="stylesheet" href="${resPath}/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" href="${resPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="${resPath}/css/bootstrap.css"/>
	<link rel="stylesheet" href="${resPath}/css/bootstrap-theme.css"/>
    

	  	
	
</head>
<body>

	<c:import url="menuNav.jsp"></c:import>
	<section class="container">
	
		<fieldset>
			<legend>Cadastro da Agenda</legend>
				<form:form servletRelativeAction="/agendapsf/cadagenda" method="post" >
					
					<div>
						<label>ID</label>
						<security:authentication property="principal" var="logado"/>
						<select name="usuario.id">					
								<option value="${logado.id}">${logado.id}</option>
						</select>
						
					</div>
					<div>
						<label>Paciente</label>
						<security:authentication property="principal.nomeUsuario" />
					</div>
					<security:authorize access="hasAnyRole('ROLE_ADMIN')">
					<div>
						<label>Regra</label>
						<security:authentication property="principal" var="user" />
						${user.authorities }<a></a>
					</div>
					</security:authorize>
					

					<div>
						<label>Cartão SUS</label>
						<security:authentication property="principal.cartSUS" />
					</div>
					<div>
						<label>Telefone</label>
						<security:authentication property="principal.telefone" />
					</div>
					<div>
						<label>Celular</label>
						<security:authentication property="principal.celular" />
					</div>
					<div>
						<label>Endereço</label>
						<security:authentication property="principal.enderecoUsuario" />
					</div>
					<div>
						<label>Cidade</label>
						<security:authentication property="principal.cidadeUsuario"/>
					</div>
					<div>
						<label>Estado</label>
						<security:authentication property="principal.UF"/>

					</div>
					<div>
						<label>Posto de Saúde</label>
						<security:authentication property="principal.postosaude.nomePsf"/>
					</div>
					<div>
						<label>Procedimento</label>
						<select name="procedimento.id" class="form-control" id="proced">
							<c:forEach items="${procedimentos}" var="procedimento">
								<option value="${procedimento.id}">${procedimento.id} - ${procedimento.descricao} </option>
							</c:forEach>
						</select> 
					</div>
					<div class="form-group">
                        <label for="dtp_input2">Data Atendimento</label>
                        <div class="input-group date form_date col-md-5" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd ">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" value="" name="dataAtendimento" /><br/>
                    </div>
			
					<script type="text/javascript" src="${resPath}/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
				    <script type="text/javascript" src="${resPath}/js/bootstrap.min.js"></script>
				    <script type="text/javascript" src="${resPath}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
				    <script type="text/javascript" src="${resPath}/js/locales/bootstrap-datetimepicker.pt-BR.js" charset="UTF-8"></script>
					<script type="text/javascript">					
			            $('.form_date').datetimepicker({
			                daysOfWeekDisabled: [0,6],			                    
			                language: 'pt-BR',
			                weekStart: 0,
			                todayBtn: 1,
			                autoclose: 1,
			                todayHighlight: 1,
			                startView: 2,
			                minView: 2,
			                forceParse: 0
			            });
			        </script>		        
	        
					<div>
						<button type="submit" class="btn btn-primary">Gravar</button>
					</div>
				</form:form>
		</fieldset>
	</section>

</body>
</html>