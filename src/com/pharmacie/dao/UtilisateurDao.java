package com.pharmacie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pharmacie.entities.Utilisateur;
import com.pharmacie.metier.IUtilisateur;

public class UtilisateurDao implements IUtilisateur {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	

	@Override
	public Utilisateur connexion(String login, String password) {
		Utilisateur user = new Utilisateur();
		connection = ConfigDB.getInstance().getConnection();
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM utilisateurs WHERE email = ? AND password = ?");
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				user.setIdUtilisateur(result.getInt("idUtilisateur"));
				user.setNom(result.getString("nom"));
				user.setPrenom(result.getString("prenom"));
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
			}
			return user;
			
		} catch(SQLException e) {
			System.out.println("Erreur sql " + e.getMessage());
		}
		
		return null;
	}
	
	

	@Override
	public void validateEmail(String email) {
		
		
	}

}
