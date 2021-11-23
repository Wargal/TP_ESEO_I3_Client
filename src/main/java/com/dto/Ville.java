package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
	
	private String Code_commune_INSEE;
	private String Nom_commune;
	private String Code_postal;
	private String Libelle_acheminement;
	private String Ligne_5;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Coordonnees{
		String Latitude;
		String Longitude;
	}
	private Coordonnees coordonnees;
}
