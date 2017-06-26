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
<title>Effectuer un Virement</title>
</head>
<body>
<div class="container-fluid" id=menu1>
	<div class="row" id=bando>
		<div class="col-lg-12" id=bandoint1>
			<img src="CSS/images/Proxibanque.jpg" alt="proxilogo" id=logo>
		</div>
	</div>
</div>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="ListeClients.jsp">Liste des Clients</a></li>
      <li><a href="CreationClient.html">Cr�er un nouveau Client</a></li>
      <li class="act"><a href="#">Effectuer un Virement</a></li>
    </ul>
  </div>
</nav>

<form class="form-horizontal" id=form1 action = "AjoutClientServlet" method = POST>
  <div class="form-group">
   <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle col-sm-2" type="button" data-toggle="dropdown">Compte � D�biter
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <c:forEach items="${ListCLient}" var="Client">
      	<li><a href=""><c:out value="${Client.nom} ${Client.prenom} n�${Client.compteCourant.id}"/></a></li>
      	<li><a href=""><c:out value="${Client.nom} ${Client.prenom} n�${Client.compteEpargne.id}"/></a></li>
      </c:forEach>
    </ul>
    <label class="control-label col-sm-2" for="Solded">Solde Compte � d�biter :</label>
    <div class="col-sm-8">
      <input type="text" id="disabledInput" class="form-control" placeholder="Solde compte � d�biter" name="Solded" value="${CompteD.solde}"  disabled>
    </div>
   </div>
  </div> 
 <div class="form-group">
   <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle col-sm-2" type="button" data-toggle="dropdown">Compte � Cr�diter
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <c:forEach items="${ListCLient}" var="Client">
      	<li><a href=""><c:out value="${Client.nom} ${Client.prenom} n�${Client.compteCourant.id}"/></a></li>
      	<li><a href=""><c:out value="${Client.nom} ${Client.prenom} n�${Client.compteEpargne.id}"/></a></li>
      </c:forEach>
    </ul>
    <label class="control-label col-sm-2" for="Solded">Solde Compte � Cr�diter :</label>
    <div class="col-sm-8">
      <input type="text" id="disabledInput" class="form-control" placeholder="Solde compte � cr�diter" name="Solded" value="${CompteC.solde}"  disabled>
    </div>
   </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-4" for="montant">Montant :</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" placeholder="montant du virement" name = "montant">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-10 col-sm-2">
      <button type="submit" class="btn btn-success">Valider</button>
    </div>
  </div>
</form>