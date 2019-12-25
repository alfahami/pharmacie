<%@ page import="java.util.*"%>
<%@ page import="com.pharmacie.entities.Medicament"%>
<%@include file="header.jsp"%>

<%
	
	String keyword = (String) request.getParameter("motCle");

	int currentPage = (int) request.getAttribute("currentPage");
	int noOfPages = (int) request.getAttribute("totalPages");
	List<Medicament> medocs = (List<Medicament>) request.getAttribute("medocs");
	

%>

<div class="title">
	<h2 id="heading2">Gestion des médicaments</h2>
	<form action="rechercherMedicament?motCle=<%=keyword%>" method="get"
		class="form-group pull-right">
		<label for="motCle" class="sr-only">Mot clé</label> <input
			class="searchbox" type="text" name="motCle" id="motCle"
			<% if(keyword != null) { %>
			value="<%=request.getParameter("motCle")%>" <% } %>
			placeholder="Rechercher par mot clé" />
		<button type="submit" class="btn btn-sm btn-success">Chercher</button>
	</form>
</div>

<p></p>
<div>

	<table class="table table-striped table-bordered">
		<tr>
			<th class="centered">Id</th>
			<th class="centered">Code Barre</th>
			<th class="centered">Nom</th>
			<th class="centered">Prix</th>
			<th class="centered">Quantité</th>
			<th class="centered">Editer</th>
		</tr>

		<%
			
			for (Medicament m : medocs) {
		%>

		<tr>
			<td class="sized centered"><%=m.getIdMedicament()%></td>
			<td class="sized centered"><%=m.getCode()%></td>
			<td class="sized centered"><%=m.getNom()%></td>
			<td class="sized centered"><%=m.getPrix()%></td>
			<td class="sized centered"><%=m.getQte()%></td>
			<td class="sized centered"><a
				href="editerMedicament?id=<%=m.getIdMedicament()%>"
				class="btn btn-sm btn-primary">Modifier</a></td>
			<!-- 
				<a
				href="supprimerMedicament?id=<%=m.getIdMedicament()%>"
				class="btn btn-sm btn-danger">Supprimer</a>
				-->
		</tr>


		<%
			}
		%>

	</table>
	<div class="centered">
		<%
			if (currentPage != 1) {
		%>

		<a class="btn btn-sm btn-default sized"
			href="accueil?page=<%=currentPage - 1%>">Précédent</a>

		<%
			}
		%>

		<%
			if (currentPage < noOfPages) {
		%>


		<a class="btn btn-sm btn-default sized police"
			href="accueil?page=<%=currentPage + 1%>">Suivant</a>
		<hr>
		<%
			}
		%>
	</div>

	<div class="centered add">
		<a href="ajouterMedicament" type="button"
			class="btn btn-sm btn-success"><span
			class="glyphicon glyphicon-plus"></span> Ajouter un medicament</a>
	</div>
</div>
<%@include file="footer.jsp"%>