<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<%@ page import="entity.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="caminho" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">

</head>

<body>

<h1 class="bg-dark p-5 display-4 border border-warning" style="color: white; text-align: center;">Cadastro de Clientes
<blockquote class="blockquote">
  <p class="mb-0">Faça o cadastro de clientes e exclua a qualquer momento.</p>
</blockquote>
</h1>

<div class="form-group col-md-6" style="margin-left: 23.5%;">
<form method="post" action="gravar"  style="text-align:">
	
	<b>Nome</b><br/>
	<input type="text" name="nomeCliente" id="nomeCliente" value="" class="form-control" placeholder="Digite um Nome"/>	
	<b>Data de Nascimento</b><br/>
	<input type="date" name="dataNascimento" id="dataNascimento" value="" class="form-control"/>	
	<b>Email</b><br/>
	<input type="email" name="emailCliente" id="emailCliente" value="" class="form-control" placeholder="Digite um Email"/>	
	<button type="submit" class="btn btn-warning" style="margin: 2%; margin-left: 40%">Gravar Dados</button>

</form>
</div>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Data de Nascimento(Ano-Mês-Dia)</th>
			<th>Email</th>
			<th>Excluir</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<c:forEach items="${lista}" var="a" >
				<td>${a.idCliente}</td>
				<td>${a.nomeCliente}</td>
				<td>${a.dataNascimento}</td>
				<td>${a.emailCliente}</td>
				<td><a href="${caminho}/excluir/${a.idCliente}" style="margin-left: 16%">X</a></td>
				</tr>
			</c:forEach>		
			
	</tbody> 
</table>



</body>
</html>