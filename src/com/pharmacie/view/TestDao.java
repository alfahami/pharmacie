package com.pharmacie.view;

import com.pharmacie.dao.MedicamentDao;
import com.pharmacie.entities.Medicament;
import com.pharmacie.metier.IMedicament;

public class TestDao {

	public static void main(String[] args) {
		IMedicament medocDao = new MedicamentDao();
		Medicament medoc1 = new Medicament(22224578, 50, "EFFERALGAN", 12);
		Medicament medoc2 = new Medicament(25478695, 60, "Paracetamol", 20);
		Medicament medoc3 = new Medicament(222278548, 80, "Ibuprofene", 54);
		
		
		medocDao.add(medoc1);
		medocDao.add(medoc2);
		medocDao.add(medoc3);
		
		/*medocDao.delete(3);
		medocDao.delete(4);*/
			
//		for (Medicament med : medocDao.listAll()) {
//			System.out.println(med);
//			
//		}
	}

}
