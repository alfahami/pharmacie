package com.pharmacie.controllers;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/rechercherMedicament")
public class rechercherMedicament extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMedicament medocMetier;
       
    public rechercherMedicament() {
        super();
        
    }
    
    public void init() {
		medocMetier = new MedicamentDao();
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		int page = 1;
		int recordsPage = 5;
		HttpSession session = request.getSession(false);
		Utilisateur user = (Utilisateur) session.getAttribute("session");
		if (user != null) {
			String keyword = request.getParameter("motCle");	
			String username = user.getNom();
			if (request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			int noOfRecords = medocMetier.getNoOfRecords();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPage);	
			List<Medicament> medocs = new ArrayList<Medicament>();
			medocs = medocMetier.findMedicament("%"+keyword+"%");
			request.setAttribute("medocs", medocs);
			request.setAttribute("totalPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("username", username);
			request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
		}
		
		else {
			response.sendRedirect("index");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		
	}

}
