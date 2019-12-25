<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PHARMANAGER</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" href="css/styles.css" rel="stylesheet">
</head>

<% String username = (String) request.getAttribute("username"); %>

<body style="padding-top: 60px;">

	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
		style="margin-bottom: 40px;">
		<div class="container-fluid">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="accueil">PHAR<strong>MANAGER</strong></a>
			</div>
			<% if(username != null) { %>
			<div id="navbar-collapse" class="navbar-collapse collapse">
				<%
				
				%>
				<ul class="nav navbar-nav">
					<li><a href="accueil">Medocs</a></li>
					<li><a href="ajouterMedicament">Ajouter un medoc</a></li>
					<li><a href="#">Vendre</a></li>
					<li><a href="#">Commander</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<p class="navbar-text">
						Bienvenu, <a href="#"><strong><%=username%></strong></a>
					</p>

					<li><a href="Deconnexion">Deconnexion</a></li>
				</ul>
				
				<% } else { %>
				
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index">Connexion</a></li>

					<li><a href="#">Inscription</a></li>
				</ul>
				<% } %>
			</div>

		</div>

	</nav>
	<div class="container">