package com.pharmacie.metier;

import com.pharmacie.entities.Utilisateur;

public interface IUtilisateur {
	
	public Utilisateur connexion(String login, String password);
	public void validateEmail(String email);
	
	
}
