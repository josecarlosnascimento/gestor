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
<title>Inclusão de Projetos</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/common/menu.jsp"%>
	<p></p>
	<form:form method="post" action="/projetos" modelAttribute="projeto">

		<div class="container">
			<div class="card">
				<h6 class="card-header">Dados do Projeto</h6>
				<div class="card-body">
					<c:if test="${projetoAdicionado}">
						<div class="alert alert-success" role="alert">Projeto
							${meuProjeto.nome} Salvo com Sucesso.</div>
					</c:if>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="nomeProjeto">Nome do Projeto</label>
							<form:input type="text" class="form-control" id="nomeProjeto"
								path="nome" placeholder="Digite o Nome do Projeto"></form:input>
							<form:errors path="nome" cssClass="error" />
							<form:hidden class="form-control" id="id" path="id"></form:hidden>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="dataInicio">Data Inicio</label>
							<form:input type="text" class="form-control" id="dataInicio"
								path="dataInicio" placeholder="dd/mm/yyyy"></form:input>
						</div>
						<div class="form-group col-md-4">
							<label for="dataPrevisao">Data Prevista</label>
							<form:input type="text" class="form-control" id="dataPrevisao"
								path="dataPrevisao" placeholder="dd/mm/yyyy"></form:input>
						</div>
						<div class="form-group col-md-4">
							<label for="dataPrevista">Data Fim</label>
							<form:input type="text" class="form-control" id="dataTemino"
								path="dataTemino" placeholder="dd/mm/yyyy"></form:input>
						</div>
					</div>
					<div class="form-group">
						<label for="inputAddress">Descrição</label>
						<form:textarea class="form-control" id="descricao"
							path="descricao" placeholder="Detalhes do Projeto"></form:textarea>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="status">Status</label>
							<form:select id="status" path="status" class="form-control">
								<option value="EM ANALISE" label="EM ANALISE" />
								<option value="ANALISE REALIZADA" label="ANALISE REALIZADA" />
								<option value="ANALISE APROVADA" label="ANALISE APROVADA" />
								<option value="INICIADO" label="INICIADO" />
								<option value="PLANEJADO" label="PLANEJADO" />
								<option value="EM ANDAMENTO" label="EM ANDAMENTO" />
								<option value="ENCERRADO" label="ENCERRADO" />
								<option value="CANCELADO" label="CANCELADO" />
							</form:select>
						</div>
						<div class="form-group col-md-4">
							<label for="risco">Risco</label>
							<form:select id="risco" path="risco" class="form-control">
								<option value="BAIXO" label="BAIXO" />
								<option value="MEDIO" label="MEDIO" />
								<option value="ALTO" label="ALTO" />
							</form:select>
						</div>
						<div class="form-group col-md-4">
							<label for="orcamento">Orçamento</label>
							<form:input type="text" path="orcamento" class="form-control"
								id="orcamento" placeholder="Valor do Orçamento"></form:input>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="gerente">Gerente</label>
							<form:select path="gerente.id" class="form-control">
								<form:option value="0" label="-- SELECIONE --"></form:option>
								<c:forEach items="${gerentes}" var="gerente">
									<form:option value="${gerente.id}" label="${gerente.nome}"></form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div align="right">
						<form:button type="submit" class="btn btn-primary">Salvar</form:button>
						<a href="/listagem-projetos" class="btn btn-secondary">Voltar</a>
					</div>
				</div>
			</div>
		</div>
		<p />
	</form:form>
</body>
</html>