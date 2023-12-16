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
<title>Inclusão de Pessoas</title>
<style type="text/css">

.error{
	color: red
}

</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/common/menu.jsp"%>
	<p></p>
	<form:form action="/pessoas" method="post" modelAttribute="pessoa">
		<div class="container">
			<div class="card">
				<h6 class="card-header">Dados da Pessoa</h6>
				<div class="card-body">
					<c:if test="${pessoaAdicionada}">
						<div class="alert alert-success" role="alert">Pessoa salva com Sucesso.</div>
					</c:if>
					<c:if test="${sistemaIndisponivel}">
						<div class="alert alert-danger" role="alert">Sistema Indiponível</div>
					</c:if>
					<div class="form-row">
						<div class="form-group col-md-8">
							<label for="nome">Nome</label>
							<form:input type="text" class="form-control" id="nome"
								path="nome" placeholder="Digite o Nome"></form:input>
								<form:errors path="nome" cssClass="error" />
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="dataNascimento">Data Nacimento</label>
							<form:input type="text" class="form-control" id="dataNascimento"
								path="dataNascimento" placeholder="dd/mm/yyyy"></form:input>
							<form:errors path="dataNascimento" cssClass="error" />
						</div>
						<div class="form-group col-md-4">
							<label for="cpf">CPF:</label>
							<form:input type="text" path="cpf" class="form-control" id="cpf"
								placeholder="Digite o CPF"></form:input>
							<form:errors path="cpf" cssClass="error" />
						</div>
						<div class="form-group col-md-4">
							<label for="status">Cargo</label>
							<form:select id="cargo" path="gerente" class="form-control">
								<option value="true">Gerente</option>
								<option value="false">Funcionario</option>
							</form:select>
						</div>
					</div>
					<div align="right">
						<form:button type="submit" class="btn btn-primary">Salvar</form:button>
						<a href="/listagem-pessoas" class="btn btn-secondary">Voltar</a>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>