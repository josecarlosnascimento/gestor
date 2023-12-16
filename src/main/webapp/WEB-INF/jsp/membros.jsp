<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Membros</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/common/menu.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<h6 class="card-header">Vincular Membros</h6>
			<div class="card-body">
				<input type="hidden" name="id" value="0" />
				<div class="form-group col-md-6">
					<form:form method="get" action="/membros/listagem-membros"
						modelAttribute="membro">
						<label for="projeto">Projeto</label>

						<div class="form-row">
							<div class="form-group col-md-6">
								<form:select path="projeto.id" class="form-control">
									<form:option value="0" label="-- SELECIONE --"></form:option>
									<c:forEach items="${projetos}" var="projeto">
										<form:option value="${projeto.id}" label="${projeto.nome}"></form:option>
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group col-md-6">
								<form:button type="submit" class="btn btn-primary">Filtrar</form:button>
							</div>
						</div>
					</form:form>
				</div>
				<form:form method="post" action="/membros" modelAttribute="membro">
				
					<div class="card">
						<h6 class="card-header">Funcionários</h6>
						<div class="card-body">
							<ul class="list-group">
								<c:forEach items="${membro.pessoas}" var="membro" varStatus="vs">
									<li class="list-group-item"><form:checkbox
											class="form-check-input me-1" path="pessoas[${vs.index}].id"
											value="${membro}"
											label="${membro.nome}" id="${membro.id}"
											checked="${membro.membro}"></form:checkbox></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<p />
					<div align="right">
						<div class="form-group col-md-6">
							<form:button type="submit" class="btn btn-primary">Atualizar Membros</form:button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<p />
</body>
</html>