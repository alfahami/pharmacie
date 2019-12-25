package com.pharmacie.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacie.dao.MedicamentDao;
import com.pharmacie.entities.Medicament;
import com.pharmacie.entities.Utilisateur;
import com.pharmacie.metier.IMedicament;

@WebServlet("/ajouterMedicament")
public class ajouterMedicament extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ajouterMedicament() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("session");
		if (user != null) {
			String username = user.getNom();
			request.setAttribute("username", username);
			request.getRequestDispatcher("WEB-INF/addMedocForm.jsp").forward(request, response);
		} else {
			response.sendRedirect("index");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("codeBarre");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String qte = request.getParameter("quantite");
		String alertMessage = "erreur";
		if (request.getParameter("ajouter") != null) {

			if(code == "" || nom == "" || prix == "" || qte == "") {
				
				request.setAttribute("alertMessage", alertMessage);
				doGet(request, response);
			}
			else {
				alertMessage = "success";
				int codeBarre = Integer.parseInt(code);
				int prixMed = Integer.parseInt(prix);
				int quantite = Integer.parseInt(qte);
				IMedicament medocMetier = new MedicamentDao();
				Medicament medoc = new Medicament(codeBarre, nom, prixMed, quantite);
				
				medocMetier.add(medoc);
				request.setAttribute("alertMessage", alertMessage);
				doGet(request, response);
				
			}
			
		}


		if (request.getParameter("annuler") != null) {
			response.sendRedirect("accueil");
		}

	}
}