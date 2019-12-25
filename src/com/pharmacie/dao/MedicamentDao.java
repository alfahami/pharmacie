package com.pharmacie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacie.entities.Medicament;
import com.pharmacie.metier.IMedicament;

public class MedicamentDao implements IMedicament {

	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private int noOfRecords;

	@Override
	public List<Medicament> listAll(int offset, int total) {
		List<Medicament> medocs = new ArrayList<Medicament>();
		connection = ConfigDB.getInstance().getConnection();

		try {
			// PreparedStatement preparedStatement;
			preparedStatement = connection
					.prepareStatement("SELECT SQL_CALC_FOUND_ROWS * FROM medicaments LIMIT " + offset + ", " + total);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Medicament medicament = new Medicament();
				medicament.setIdMedicament(result.getInt("idMedicament"));
				medicament.setCodeBarre(result.getInt("codeBarre"));
				medicament.setNom(result.getString("nom"));
				medicament.setPrix(result.getInt("prix"));
				medicament.setQte(result.getInt("quantite"));
				medocs.add(medicament);
			}
			
			result.close();
			
			preparedStatement = connection.prepareStatement("SELECT FOUND_ROWS()");
			result = preparedStatement.executeQuery();
			
			if(result.next()) 
				this.noOfRecords = result.getInt(1);
			
			return medocs;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}

		return null;
	}

	@Override
	public void add(Medicament medoc) {
		connection = ConfigDB.getInstance().getConnection();

		try {
			// PreparedStatement preparedStatement;
			preparedStatement = connection
					.prepareStatement("INSERT INTO medicaments(codeBarre, nom, prix, quantite) VALUES( ?, ?, ?, ?)");
			preparedStatement.setInt(1, medoc.getCode());
			preparedStatement.setString(2, medoc.getNom());
			preparedStatement.setInt(3, medoc.getPrix());
			preparedStatement.setInt(4, medoc.getQte());
			preparedStatement.execute();

		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}

	}

	@Override
	public Medicament update(Medicament medoc) {
		Connection connection = ConfigDB.getInstance().getConnection();

		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE medicaments SET codeBarre = ?, nom = ?, prix = ?, quantite = ? WHERE idMedicament = ?");
			preparedStatement.setInt(1, medoc.getCode());
			preparedStatement.setString(2, medoc.getNom());
			preparedStatement.setInt(3, medoc.getPrix());
			preparedStatement.setInt(4, medoc.getQte());

			preparedStatement.setInt(5, medoc.getIdMedicament());
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {

			System.out.println("Erreur SQL " + e.getMessage());
		}

		return medoc;

	}

	@Override
	public List<Medicament> findMedicament(String keyword) {
		List<Medicament> m = new ArrayList<Medicament>();

		connection = ConfigDB.getInstance().getConnection();

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM medicaments WHERE nom LIKE ?");
			preparedStatement.setString(1, keyword);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Medicament medoc = new Medicament();
				medoc.setIdMedicament(result.getInt("idMedicament"));
				medoc.setCodeBarre(result.getInt("codeBarre"));
				medoc.setNom(result.getString("nom"));
				medoc.setPrix(result.getInt("prix"));
				medoc.setQte(result.getInt("quantite"));

				m.add(medoc);
			}		
		
			return m;
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		connection = ConfigDB.getInstance().getConnection();

		try {
			preparedStatement = connection.prepareStatement("DELETE FROM medicaments where idMedicament = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Erreur SQL " + e.getMessage());
		}
		return false;

	}

	@Override
	public Medicament getMedicament(int id) {
		Medicament m = new Medicament();

		Connection connection = ConfigDB.getInstance().getConnection();

		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM medicaments WHERE idMedicament = ?");
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				m.setIdMedicament(result.getInt("IdMedicament"));
				m.setCodeBarre(result.getInt("CodeBarre"));
				m.setNom(result.getString("nom"));
				m.setPrix(result.getInt("prix"));
				m.setQte(result.getInt("quantite"));
			}
			return m;

		} catch (SQLException e) {
			System.out.println("Erreur SQL" + e.getMessage());
		}
		return null;
	}

	@Override
	public int getNoOfRecords() {
		return noOfRecords;
		
	}

}
