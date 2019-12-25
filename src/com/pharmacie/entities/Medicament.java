package com.pharmacie.entities;

public class Medicament {
	private int idMedicament;
	private int codeBarre;
	private int prix;
	private String nom;
	private int qte;
	
	public Medicament(int codeBarre, int prix, String nom, int qte) {
//		super();
		this.codeBarre = codeBarre;
		this.prix = prix;
		this.nom = nom;
		this.qte =qte;
	}

	public Medicament(int idMedicament, int codeBarre, int prix, String nom, int q) {
//		super();
		this.idMedicament = idMedicament;
		this.codeBarre = codeBarre;
		this.prix = prix;
		this.nom = nom;
		this.qte = q;
	}

	public Medicament() {
		this.nom = "";
		this.codeBarre = 0;
		this.prix = 0;
		this.qte = 0;
	}

	public Medicament(int code, String nom, int prix, int qte) {
//		super();
		this.codeBarre = code;
		this.nom = nom;
		this.prix = prix;
		this.qte = qte;
	}

	public int getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public int getCode() {
		return codeBarre;
	}
	

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public void setCodeBarre(int codeBarre) {
		this.codeBarre = codeBarre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", codeBarre=" + codeBarre + ", prix=" + prix + ", nom="
				+ nom + "]";
	}
	
}
