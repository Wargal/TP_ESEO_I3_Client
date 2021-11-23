package com.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.dto.Ville;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Dao {

	public static List<Ville> getVilles(String code_insee, String nom_commune, String code_postal, String libelle_acheminement,
			Integer limit, Integer offset) throws ClientProtocolException, IOException, UnsupportedOperationException {
		
		String parameters = "";
		boolean firstParameter = true;
		if(code_insee != null){
			if(firstParameter) {
				parameters+="?";
			} else {
				parameters+="&";
			}
			parameters+="code_insee="+code_insee;
		}
		if(nom_commune != null){
			if(firstParameter) {
				parameters+="?";
			} else {
				parameters+="&";
			}
			parameters+="nom_commune="+nom_commune;
		}
		if(code_postal != null){
			if(firstParameter) {
				parameters+="?";
			} else {
				parameters+="&";
			}
			parameters+="code_postal="+code_postal;
		}
		if(libelle_acheminement != null){
			if(firstParameter) {
				parameters+="?";
			} else {
				parameters+="&";
			}
			parameters+="libelle_acheminement="+libelle_acheminement;
		}
		if(limit != null){
			if(firstParameter) {
				parameters+="?";
			} else {
				parameters+="&";
			}
			parameters+="limit="+limit;
		}
		if(offset != null){
			if(firstParameter) {
				parameters+="?";
			} else {
				parameters+="&";
			}
			parameters+="offset="+offset;
		}
		
		List<Ville> list = null;
		// Create an instance of HttpClient.
		HttpClient httpClient = HttpClients.createDefault();

		// Create a method instance.
		HttpGet get = new HttpGet("http://localhost:8181/ville"+parameters);

		HttpResponse response = httpClient.execute(get);

		int internResponseStatus = response.getStatusLine().getStatusCode();

		if (200 == internResponseStatus) {
			BufferedReader rd = null;
			try {
				rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			} catch (UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StringBuffer result = new StringBuffer();
			String line = "";
			try {
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String data = result.toString();
			System.out.println(data);
			ObjectMapper objectMapper = new ObjectMapper();
			list = objectMapper.readerForListOf(Ville.class).readValue(data);
		}
		return list;
	}
}
