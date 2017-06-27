<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.net.httpserver.HttpServer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Ajout réussi</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Velocation</a>
	</div>
	<ul class="nav navbar-nav">
		<li class="active"><a href="index.html">Home</a></li>
		<li><a href="ajoutVeloBS.html">Ajout</a></li>
		<li><a href="lireVeloById.html">Lecture</a></li>
		<li><a href="LireTousLesVelosServlet">Affichage Stock</a></li>
	</ul>
	</nav>
	<div class="container-fluid">



	<table class="table table-hover">
		<thead>
			<tr>
				<th>id</th>
				<th>nom</th>
				<th>prix</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listeClients" items="${listeClients}">
				<tr>
					<td>${listeClients.nom}</td>
					<td>${listeClients.prenom}</td>
					<td>${listeClients.adresse}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>

