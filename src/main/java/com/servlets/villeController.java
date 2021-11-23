package com.servlets;

import java.io.IOException;

import com.dao.Dao;
import com.dto.Ville;
import com.dto.Ville.Coordonnees;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class villeController
 */
@WebServlet("/")
public class villeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public villeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        this.getServletContext().getRequestDispatcher("/Hello.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Posted");
		if(request.getParameter("btnAddCity")!=null) {
			System.out.println("Added");
			System.out.println(request.getParameter("codeCommune"));
			Dao.addVille(
					request.getParameter("codeCommune"),
					request.getParameter("nomCommune"),
					request.getParameter("codePostal"),
					request.getParameter("libelle"),
					request.getParameter("ligne5"),
					request.getParameter("latitude"),
					request.getParameter("longitude")
					);
		}
		if(request.getParameter("btnEditCity")!=null) {
			System.out.println("Edited");
			Dao.editVille(
					request.getParameter("codeCommune"),
					request.getParameter("nomCommune"),
					request.getParameter("codePostal"),
					request.getParameter("libelle"),
					request.getParameter("ligne5"),
					request.getParameter("latitude"),
					request.getParameter("longitude")
					);

		}
		if(request.getParameter("btnDeleteCity")!=null) {
			System.out.println("Deleted");
			System.out.println(request.getParameter("codeCommune"));
			Dao.deleteVille(request.getParameter("codeCommune"));
		}

		doGet(request, response);
	}

}
