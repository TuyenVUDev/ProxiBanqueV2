<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.gtm.proxibanque.domain.Client"%>
<%@ page import="fr.gtm.proxibanque.domain.Compte"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="iso-8859-1"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="CSS/Style.css">
<title>ModificationCLient</title>
</head>
<body>
<div class="container-fluid" id=menu1>
	<div class="row" id=bando>
		<div class="col-lg-12" id=bandoint1>
			<img src="CSS/images/Proxibanque.jpg" alt="proxilogo" id=logo>
		</div>
	</div>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="ListeClients.jsp">Liste des Clients</a></li>
      <li><a href="CreationClient.html">Créer un nouveau Client</a></li>
      <li><a href="Virement.jsp">Effectuer un Virement</a></li>
      <li class="act"><a href="#">Modification du Client: ${Client.prenom} ${Client.nom}</a></li>
    </ul>
  </div>
</nav>




<form class="form-horizontal" id=form1 action = "ModificationClientServlet" method = POST>
  <div class="form-group">
    <label class="control-label col-sm-2" for="nom">Nom :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="nom" name="nom" value="${Client.nom}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="prenom">Prénom :</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" placeholder="prenom" name="prenom" value="${Client.prenom}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="adresse">Adresse :</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" placeholder="adresse" name = "adresse" value="${Client.adresse}">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email :</label>
    <div class="col-sm-10"> 
      <input type="email" class="form-control" placeholder="email" name ="email" value="${Client.email}">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-10 col-sm-2">
      <button type="submit" class="btn btn-warning">Modification</button>
    </div>
  </div>
</form>
	<div class="row" id=supp>
	
		<div class="col-lg-1"></div>
		<div class="col-lg-2" id=ComptCour>Compte Courant:</div>
		<div class="col-lg-3" id=buttsupp1><a href="" class="btn btn-danger">supprimer</a></div>
		<div class="col-lg-1"></div>
		<div class="col-lg-2" id=ComptEp>Compte Epargne:</div>
		<div class="col-lg-3" id=buttsupp2><a href="" class="btn btn-danger">supprimer</a></div>
	</div>
</div>

</body>
</html>