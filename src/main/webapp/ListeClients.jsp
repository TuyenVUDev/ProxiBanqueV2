<!DOCTYPE>
<%@ page import="java.util.List"%>
<%@ page import="fr.gtm.proxibanque.domain.Client"%>
<%@ page import="fr.gtm.proxibanque.domain.Compte"%>
<%@ page import="fr.gtm.proxibanque.service.ConseillerService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta charset="iso-8859-1"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="CSS/Style.css">
<title>ListeCLients</title>
</head>
<body id=Lclients>
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
      <li class="act"><a href="ListeClientsServlet">Liste des Clients</a></li>
      <li><a href="CreationClient.html">Créer un nouveau Client</a></li>
      <li><a href="Virement.jsp">Effectuer un Virement</a></li>
    </ul>
  </div>
</nav>
<div class="container-fluid">
	<div class="row" id = table1>
	<table class="table table-bordered table-inverse" id=listeclient>
	    <thead>
	      <tr>
	        <th>Nom</th>
	        <th>Prénom</th>
	        <th>Email</th>
	        <th>Adresse</th>
	        <th>id compte courant</th>
	        <th>id compte epargne</th>
	        <th></th>
	        <th></th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	    <% List<Client> ListC = (List<Client>) session.getAttribute("ListC"); %>
	    <% ConseillerService cs = new ConseillerService(); %>
	    <%for(Client client:ListC){%>
	    <tr>
	    <td><% out.println(client.getNom());%></td>
	    <td><% out.println(client.getPrenom());%></td>
	    <td><% out.println(client.getEmail());%></td>
	    <td><% out.println(client.getAdresse());%></td>
	    <td>id : <% out.println(client.getIdCompteCourant());%> <%if(client.getIdCompteCourant()!=0){out.print("| solde : " + cs.getSoldeCompteByID(client.getIdCompteCourant())+ " euros");}else{out.print("");};%></td>
	    <td>id : <% out.println(client.getIdCompteEpargne());%> <%if(client.getIdCompteEpargne()!=0){out.print("| solde : " + cs.getSoldeCompteByID(client.getIdCompteEpargne())+ " euros");}else{out.print("");};%></td>
	    <td id=ajoutcompte><a href="AjoutCompteServlet?id=<%out.print(client.getId());%>">Ajouter un Compte</a></td>
	    <td id=modifier><a href="ModificationClientServlet?id=<%out.print(client.getId());%>">Modifier</a></td>
		<td id=supprimer><a href="SupprimerClientServlet?id=<%out.print(client.getId());%>">Supprimer</a></td>
		</tr>
		<%} %>
		
	    <%-- <c:forEach var="Cl" items="${ListC}">
						<tr>
					    <td><c:out value="${Cl.nom}"/></td>
					    <td><c:out value="${Cl.prenom}"/></td>
					    <td><c:out value="${Cl.email}"/></td>
					    <td><c:out value="${Cl.adresse}"/></td>
					    <td><c:out value="${Cl.idCompteCourant} :"/></td>
					    <td><c:out value="${Cl.idCompteEpargne} :"/></td>
					    <td id=modifier><a href="">Modifier</a></td>
					    <td id=supprimer><a href="">Supprimer</a></td>
					    </tr>
		</c:forEach> --%>
	    </tbody>
	  </table>
	</div>
</div>





</body>
</html>