package com.pharmacie.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacie.dao.UtilisateurDao;
import com.pharmacie.entities.Utilisateur;


@WebServlet(name = "cs", urlPatterns = { "/index", "*.html" })
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao userDao = new UtilisateurDao();
       
    
    public Connexion() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String  password = request.getParameter("password");
		String alertMessage = " ";
		if(email == "" && password == "") {
			request.setAttribute("alertMessage", alertMessage);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			
		}
		else {
			Utilisateur user = userDao.connexion(email, password);
			if(user.getIdUtilisateur() != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("session", user);
				response.sendRedirect("accueil");
			}
			
			else if(user.getEmail() == null || password == null) {
				alertMessage = "erreur";
				request.setAttribute("alertMessage", alertMessage);
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}
			
			else {
				doGet(request, response);
			}
		}
		
		
		
	}

}
