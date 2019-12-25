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

@WebServlet("/editerMedicament")
public class editerMedicament extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMedicament medocMetier;

	public editerMedicament() {
		super();

	}

	public void init() {
		medocMetier = new MedicamentDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("session");

		if (user != null) {
			String username = user.getNom();
			int id = Integer.parseInt(request.getParameter("id"));
			Medicament m = medocMetier.getMedicament(id);
			request.setAttribute("medoc", m);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/WEB-INF/editMedoc.jsp").forward(request, response);
		}

		else {
			response.sendRedirect("index");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		int code = Integer.parseInt(request.getParameter("code"));
		int prix = Integer.parseInt(request.getParameter("prix"));
		int qte = Integer.parseInt(request.getParameter("quantite"));
		String nom = request.getParameter("nom");

		if (request.getParameter("modifier") != null) {
			Medicament m = new Medicament(code, prix, nom, qte);
			m.setIdMedicament(id);
			medocMetier.update(m);
			request.setAttribute("medoc", m);
			response.sendRedirect("accueil");
		}

		else if (request.getParameter("annuler") != null) {
			response.sendRedirect("accueil");
		}

		else if (request.getParameter("supprimer") != null) {

			doGet(request, response);

		}
	}
}