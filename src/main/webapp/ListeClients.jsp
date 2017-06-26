<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.gtm.proxibanque.domain.Client"%>
<%@ page import="fr.gtm.proxibanque.domain.Compte"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE>
<html>
<head>
<meta charset="iso-8859-1"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="CSS/Style.css">
<title>index</title>
</head>
<body>
<div class="container-fluid" id=menu1>
	<div class="row" id=bando>
		<div class="col-lg-12" id=bandoint1>
			<img src="images/Proxibanque.jpg" alt="proxilogo" id=logo>
		</div>
	</div>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Liste de Client</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
<div class="container-fluid">
	<div class="row" id = table1>
	<table class="table table-condensed">
	    <thead>
	      <tr>
	        <th>Nom</th>
	        <th>Prénom</th>
	        <th>Email</th>
	        <th>Adresse</th>
	        <th>Compte Courant</th>
	        <th>Compte Epargne</th>
	        <th>Modifier</th>
	        <th>Supprimer</th>
	      </tr>
	    </thead>
	    <tbody>
	     <c:forEach items="${ListCLient}" var="Client">
						<tr>
					    <td><c:out value="${Client.nom}"/></td>
					    <td><c:out value="${Client.prenom}"/></td>
					    <td><c:out value="${Client.email}"/></td>
					    <td><c:out value="${Client.adresse}"/></td>
					    <td><c:out value="${Client.compteCourant.id} : ${Client.compteCourant.solde}"/></td>
					    <td><c:out value="${Client.compteEpargne.id} : ${Client.compteEpargne.solde}"/></td>
					    <td><a href=""><button</a>
					    </tr>
		</c:forEach>
	    </tbody>
	  </table>
	</div>
</div>





</body>
</html>