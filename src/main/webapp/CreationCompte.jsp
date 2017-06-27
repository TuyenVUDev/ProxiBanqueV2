<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.gtm.proxibanque.domain.Client"%>
<%@ page import="fr.gtm.proxibanque.domain.Compte"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta charset="iso-8859-1"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="CSS/Style.css">
<title>CreationClient</title>
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
      <li class="act"><a href="#">Ajouter Comptes au Client</a></li>
    </ul>
  </div>
</nav>
<% Client client = (Client) session.getAttribute("client"); %>
<form class="form-horizontal" id=form1 action ="AjoutClientServlet" method = POST>
  <div class="form-group">
    <label class="control-label col-sm-2" for="id">IdClient :</label>
    <div class="col-sm-2"> 
      <input type="text" id="disabledInput" class="form-control" value="<%out.print(client.getId());%>" name="id" disable>
  	</div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="compteCourant">Compte Courant :</label>
    <div class="col-sm-1">
      <input type="checkbox" name="compteCourant" id=cb1>
    </div>
    <label class="control-label col-sm-2" for="soldecc">Solde Compte Courant :</label>
    <div class="col-sm-5"> 
      <input type="text" class="form-control" name="soldecc">
  	</div>
  </div>
  <div class="form-group">
     <label class="control-label col-sm-2" for="adresse">Compte Epargne :</label>
    <div class="col-sm-1"> 
      <input type="checkbox" name="compteEpargne" id=cb2>
    </div>
       <label class="control-label col-sm-2" for="email">Solde Compte Courant :</label>
    <div class="col-sm-5"> 
     <input type="text" class="form-control" name="soldecc">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-10 col-sm-2">
      <button type="submit" class="btn btn-success">Valider</button>
    </div>
  </div>
</form>
<div class="container-fluid">
	<div class="row" id = table1>
	<table class="table table-bordered table-inverse" id=listecompte>
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Type</th>
	        <th>Solde</th>
	      </tr>
	    </thead>
	    <tbody>
	    <% List<Compte> ListeCompte = (List<Compte>) session.getAttribute("ListeCompte"); %>
	    <%for(Compte compte:ListeCompte){%>
	    <tr>
	    <td><% out.println(compte.getId());%></td>
	    <td><% out.println(compte.getTypeDeCompte());%></td>
	    <td><% out.println(compte.getSolde());%></td>
		</tr>
		<%} %>
	    </tbody>
	  </table>
	</div>
</div>
</div>


</body>
</html>