<%@ page import="java.util.*"%>
<%@ page import="com.pharmacie.entities.Medicament"%>
<%@include file="header.jsp"%>

<%
	String alertMessage = (String) request.getAttribute("alertMessage");
%>

<h1>Ajout d'un médicament</h1>

<%
	if (alertMessage == "success") {
%>
<div class='alert alert-success'>
	Medicament ajouté avec succès!
	<button type='button' class='close' aria-label='Close'
		data-dismiss='alert'>
		<span aria-hidden='true'>&times;</span>
	</button>
</div>
<%
	}
%>
<%
	if (alertMessage == "erreur") {
%>

<div class='alert alert-danger'>
	Merci de remplir ce formulaire
	<button type='button' class='close' aria-label='Close'
		data-dismiss='alert'>
		<span aria-hidden='true'>&times; </span>
	</button>
</div>

<%
	}
%>
<form action="ajouterMedicament" method="post" class="row">
	<div class="form-group col-sm-6">
		<label for="code">Code Barre *</label> <input type="text"
			class="form-control input-lg" id="code" name="codeBarre">
	</div>
	<div class="form-group col-sm-6">
		<label for="prix">Prix *</label> <input type="text"
			class="form-control input-lg" id="prix" name="prix">
	</div>
	<div class="form-group col-sm-6">
		<label for="nom">Nom</label> <input type="text"
			class="form-control input-lg" id="nom" name="nom" value="">
	</div>
	<div class="form-group col-sm-6">
		<label for="quantite">Quantité</label> <input type="text"
			class="form-control input-lg" id="quantite" name="quantite">
	</div>

	<div class="form-group col-sm-12">
		<input type="submit" class="btn btn-lg btn-default" name="annuler"
			value="Annuler"> <input type="submit"
			class="btn btn-lg btn-success pull-right" name="ajouter"
			value="Ajouter">
	</div>
</form>

<%@include file="footer.jsp"%>


