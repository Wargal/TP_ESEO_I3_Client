package com.model;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.dao.Dao;
import com.dto.Ville;

public class CityList {

	public CityList() {
		super();
		try {
			setCities(Dao.getVilles(null, null, null, null, null, null));
		} catch (UnsupportedOperationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Ville> cities;

	public List<Ville> getCities() {
		return cities;
	}

	public void setCities(List<Ville> cities) {
		this.cities = cities;
	}

	public void refreshCities(List<Ville> cities) {
		this.cities = cities;
	}

	public int getNPages() {
		int nPages = (int) Math.ceil((float) cities.size()/25);
		return nPages;
	}
	
	public String echoCities(int page) {
		String out="";
		for (int i = (page-1)*50; i < (page-1)*50+50; i++) {
			if(i<cities.size()) {
			Ville ville=cities.get(i);
			out+="<tr>";
			out+="<td>"+ville.getCode_commune_INSEE()+"</td>";
			out+="<td>"+ville.getNom_commune()+"</td>";
			out+="<td>"+ville.getCode_postal()+"</td>";
			out+="<td>"+ville.getLibelle_acheminement()+"</td>";
			out+="<td>"+ville.getCoordonnees().getLatitude()+"</td>";
			out+="<td>"+ville.getCoordonnees().getLongitude()+"</td>";
			out+="<td>"+ville.getCoordonnees().getLongitude()+"</td>";
			out+="</tr>";
			}
		}
		return out;
	}
	
	public void hello() {
		System.out.println("CAlled");
	}

}
