<%@page import="org.omg.CORBA.SystemException"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pharmacie.entities.Medicament"%>
<%@include file="header.jsp"%>

<h1>Modification d'un médicament</h1>

<%
	Medicament m = (Medicament) request.getAttribute("medoc");
	String alertMessage = (String) request.getAttribute("alertMessage");
	if (request.getParameter("supprimer") != null) {
%>


<div class='alert alert-danger'>
	<p>
		Êtes-vous sûr de vouloir supprimer ce médicament? <br> Cet action
		est irreversible!
	</p>
	<br>

	<form action="supprimerMedicament" method='get'>
		<a type='button'
			href="supprimerMedicament?id=<%=m.getIdMedicament()%>"
			class='btn btn-danger btn-sm'>Oui supprimer</a> <a type='button'
			class='btn btn btn-default btn-sm' data-dismiss='alert'>Oops!
			Non, Merci</a>
	</form>
</div>

<%
	}
%>

<% if (alertMessage == "success") { %>

<div class='alert alert-success'>
	Medicament ajouté avec succès.
	<button type='button' class='close' aria-label='Close'
		data-dismiss='alert'>
		<span aria-hidden='true'>&times;</span>
	</button>
</div>

<% } %>

<form action="editerMedicament" method="post" class="row" name="editer">
	<div class="form-group col-md-12">
		<label for="code">ID</label> <input type="text"
			class="form-control input-lg" id="id" name="id"
			value="<%=m.getIdMedicament()%>" readonly>
	</div>
	<div class="form-group col-sm-6">
		<label for="code">Code Barre *</label> <input type="text"
			class="form-control input-lg" id="code" name="code"
			value="<%=m.getCode()%>">
	</div>
	<div class="form-group col-sm-6">
		<label for="prix">Prix *</label> <input type="text"
			class="form-control input-lg" id="prix" name="prix"
			value="<%=m.getPrix()%>">
	</div>
	<div class="form-group col-sm-6">
		<label for="nom">Nom</label> <input type="text"
			class="form-control input-lg" id="nom" name="nom"
			value="<%=m.getNom()%>">
	</div>
	<div class="form-group col-sm-6">
		<label for="quantite">Quantité</label> <input type="text"
			class="form-control input-lg" id="quantite" name="quantite"
			value="<%=m.getQte()%>">
	</div>

	<div class="form-group col-sm-12">
		<hr>
		<input type="submit" name="supprimer" value="Supprimer"
			class="btn btn-lg btn-danger pull-left">

		<div class="pull-right">
			<input type="submit" name="annuler" class="btn btn-lg btn-default"
				value="Annuler"> <input type="submit"
				class="btn btn-lg btn-success" name="modifier" value="Modifier">
		</div>
	</div>
</form>

<%@include file="footer.jsp"%>