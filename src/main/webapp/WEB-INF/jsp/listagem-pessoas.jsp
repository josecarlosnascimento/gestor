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
		<div>
			<a type="button" class="btn btn-primary btn-md" href="/pessoas/listagem-pessoas">Buscar Pessoas</a>
	 	</div>
		<p></p>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">Cargo</th>
				</tr>
			</thead>
			<tbody>
		     <c:forEach items="${pessoas}" var="pessoa">
				<tr>
					<td>${pessoa.nome}</td>
					<td>${pessoa.cpf}</td>
					<td>${pessoa.gerente?'Gestor':'Funcionario'}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</form>
</body>
</html>