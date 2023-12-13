<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Listagem de Projetos</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/common/menu.jsp"%>
	<p></p>
	<form method="post">
		<div class="container">
	    <c:if test="${projetoRemovido}">
	        <div class="alert alert-success" role="alert">Projeto ${codigo} Removido com Sucesso.</div>
	    </c:if>
	    <c:if test="${quantidadeRegistros > 0}">
	        <div class="alert alert-success" role="alert">Sua Busca Retorou ${quantidadeRegistros} Projetos.</div>
	    </c:if>
	    <c:if test="${quantidadeRegistros == 0}">
	        <div class="alert alert-warning" role="alert">Não há resultados para esta pesquisa.</div>
	    </c:if>
		<div>
	  		<a type="button" class="btn btn-primary btn-md" href="/projetos/listagem-projetos">Buscar Projetos</a>
	 	</div>
		<p></p>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">Data Início</th>
					<th scope="col">Data Prevista</th>
					<th scope="col">Data Final</th>
					<th scope="col">Status</th>
					<th scope="col">Gerente</th>
					<th scope="col">Ação</th>
				</tr>
			</thead>
			<tbody>
		     <c:forEach items="${projetos}" var="projeto">
				<tr>
					<td>${projeto.nome}</td>
					<td>${projeto.dataInicio}</td>
					<td>${projeto.dataPrevisao}</td>
					<td>${projeto.dataTemino}</td>
					<td>${projeto.status}</td>
					<td>${projeto.gerente.nome}</td>
					<td>
						<a type="button" class="btn btn-info" title="Ver" href="/projetos/buscar?id=${projeto.id}">
							VER
						</a>
						<c:if test="${projeto.permiteExclusao}">
							<a type="button"  class="btn btn-danger" title="Remover" href="/projetos/${projeto.id}">
								DELETAR
							</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</form>
</body>
</html>