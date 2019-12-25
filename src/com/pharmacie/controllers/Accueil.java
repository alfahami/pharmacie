package com.pharmacie.controllers;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMedicament medocMetier;

	public Accueil() {
		super();

	}

	public void init() {
		medocMetier = new MedicamentDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
		int recordsPage = 5;

		HttpSession session = request.getSession(false);

		Utilisateur user = (Utilisateur) session.getAttribute("session");
		if (user != null) {

			String username = user.getNom();

			if (request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			List<Medicament> m = medocMetier.listAll((page - 1) * recordsPage, recordsPage);
			int noOfRecords = medocMetier.getNoOfRecords();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPage);
			request.setAttribute("medocs", m);
			request.setAttribute("totalPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("username", username);
			request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
		} else {
			response.sendRedirect("index");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}