package com.servlets;

import java.io.IOException;
import java.util.Random;

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
@WebServlet("/data")
public class carController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

    /**
     * Default constructor. 
     */
    public carController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random rand = new Random();
		response.getWriter().append("Data :").append(""+rand.nextInt());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Posted");
		doGet(request, response);
	}

}
