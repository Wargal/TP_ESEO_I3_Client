package com.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.dto.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherGet {
private Weather weather;
private String html;

public WeatherGet(String lat, String lon) throws ClientProtocolException, IOException {
	// Create an instance of HttpClient.
			HttpClient httpClient = HttpClients.createDefault();

			// Create a method instance.
			HttpGet get = new HttpGet("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=7d4698a1f473b12d3de5c6053bb94495&mode=html&units=metric&lang=fr");

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
				this.html=data;

				//System.out.println(data);
				//ObjectMapper objectMapper = new ObjectMapper();
				//setWeather(objectMapper.readerFor(Weather.class).readValue(data));
			}
}

public Weather getWeather() {
	return weather;
}

public String getWeatherHTML() {
	return html;
}

public void setWeather(Weather weather) {
	this.weather = weather;
}
}
