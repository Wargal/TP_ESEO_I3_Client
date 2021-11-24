package com.servlets;

import java.io.IOException;

import com.dao.Dao;
import com.dto.Ville;
import com.dto.Ville.Coordonnees;
import com.model.CityList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class villeController
 */
@WebServlet("/ville")
public class villeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    private static final double r2d = 180.0D / 3.141592653589793D;
    private static final double d2r = 3.141592653589793D / 180.0D;
    private static final double d2km = 111189.57696D * r2d;
    public static double meters(double lt1, double ln1, double lt2, double ln2) {
        double x = lt1 * d2r;
        double y = lt2 * d2r;
        return Math.acos( Math.sin(x) * Math.sin(y) + Math.cos(x) * Math.cos(y) * Math.cos(d2r * (ln1 - ln2))) * d2km;
    }

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
		if(request.getParameter("cityDataUpdate")!=null) {
			response.getWriter().append((new CityList()).echoCities(Integer.valueOf(request.getParameter("cityDataUpdate"))));
		}else {
			this.getServletContext().getRequestDispatcher("/Hello.jsp").forward(request, response);
		}
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
		
		if(request.getParameter("btnDistanceCity")!=null) {
			System.out.println("Calculated");
			String[] coord1 = request.getParameter("coord1").split("/");
			String[] coord2 = request.getParameter("coord2").split("/");
			System.out.println(coord1);
			System.out.println(coord2);
			Double distance = meters(Double.parseDouble(coord1[0]),Double.parseDouble(coord1[1]),Double.parseDouble(coord1[0]),Double.parseDouble(coord2[1]));
			request.getSession().setAttribute("depart", coord1[2]);
			request.getSession().setAttribute("arrivee", coord2[2]);
			request.getSession().setAttribute("distance", Math.round(distance));
		}
		if(request.getParameter("changePage")!=null) {
			System.out.println("Page set to "+Integer.parseInt(request.getParameter("changePage")));
			request.getSession().setAttribute("page",Integer.parseInt(request.getParameter("changePage")));
		}
		

		doGet(request, response);
	}

}
