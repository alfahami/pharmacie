package com.pharmacie.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacie.dao.MedicamentDao;
import com.pharmacie.entities.Utilisateur;
import com.pharmacie.metier.IMedicament;

@WebServlet("/supprimerMedicament")
public class supprimerMedicament extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public supprimerMedicament() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("session");

		if (user != null) {

			int id = Integer.parseInt(request.getParameter("id"));
			IMedicament medocDao = new MedicamentDao();
			medocDao.delete(id);
			response.sendRedirect("accueil");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
	}

}
