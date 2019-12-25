package com.pharmacie.metier;

import java.util.List;

import com.pharmacie.entities.Medicament;

public interface IMedicament {
	public List<Medicament> listAll(int offset, int noOfRecords);
	public void add(Medicament medoc);
	public Medicament update(Medicament medoc);
	public List<Medicament> findMedicament(String keyword);
	public Medicament getMedicament(int id);
	public boolean delete(int id);
	public int getNoOfRecords();
	
	
	
}
