package com.dto;

import java.util.ArrayList;

import com.dto.Ville.Coordonnees;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
	Coord CoordObject;
	ArrayList<Object> weather = new ArrayList<Object>();
	private String base;
	MainData MainObject;
	private float visibility;
	Wind WindObject;
	Clouds CloudsObject;
	private float dt;
	Sys SysObject;
	private float timezone;
	private float id;
	private String name;
	private float cod;

	// Getter Methods

	public Coord getCoord() {
		return CoordObject;
	}

	public String getBase() {
		return base;
	}

	public MainData getMain() {
		return MainObject;
	}

	public float getVisibility() {
		return visibility;
	}

	public Wind getWind() {
		return WindObject;
	}

	public Clouds getClouds() {
		return CloudsObject;
	}

	public float getDt() {
		return dt;
	}

	public Sys getSys() {
		return SysObject;
	}

	public float getTimezone() {
		return timezone;
	}

	public float getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getCod() {
		return cod;
	}

	// Setter Methods

	public void setCoord(Coord coordObject) {
		this.CoordObject = coordObject;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public void setMain(MainData mainObject) {
		this.MainObject = mainObject;
	}

	public void setVisibility(float visibility) {
		this.visibility = visibility;
	}

	public void setWind(Wind windObject) {
		this.WindObject = windObject;
	}

	public void setClouds(Clouds cloudsObject) {
		this.CloudsObject = cloudsObject;
	}

	public void setDt(float dt) {
		this.dt = dt;
	}

	public void setSys(Sys sysObject) {
		this.SysObject = sysObject;
	}

	public void setTimezone(float timezone) {
		this.timezone = timezone;
	}

	public void setId(float id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCod(float cod) {
		this.cod = cod;
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Sys {
		private float type;
		private float id;
		private float message;
		private String country;
		private float sunrise;
		private float sunset;

		// Getter Methods

		public float getType() {
			return type;
		}

		public float getId() {
			return id;
		}

		public float getMessage() {
			return message;
		}

		public String getCountry() {
			return country;
		}

		public float getSunrise() {
			return sunrise;
		}

		public float getSunset() {
			return sunset;
		}

		// Setter Methods

		public void setType(float type) {
			this.type = type;
		}

		public void setId(float id) {
			this.id = id;
		}

		public void setMessage(float message) {
			this.message = message;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public void setSunrise(float sunrise) {
			this.sunrise = sunrise;
		}

		public void setSunset(float sunset) {
			this.sunset = sunset;
		}
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Clouds {
		private float all;

		// Getter Methods

		public float getAll() {
			return all;
		}

		// Setter Methods

		public void setAll(float all) {
			this.all = all;
		}
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Wind {
		private float speed;
		private float deg;

		// Getter Methods

		public float getSpeed() {
			return speed;
		}

		public float getDeg() {
			return deg;
		}

		// Setter Methods

		public void setSpeed(float speed) {
			this.speed = speed;
		}

		public void setDeg(float deg) {
			this.deg = deg;
		}
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MainData {
		private float temp;
		private float feels_like;
		private float temp_min;
		private float temp_max;
		private float pressure;
		private float humidity;

		// Getter Methods

		public float getTemp() {
			return temp;
		}

		public float getFeels_like() {
			return feels_like;
		}

		public float getTemp_min() {
			return temp_min;
		}

		public float getTemp_max() {
			return temp_max;
		}

		public float getPressure() {
			return pressure;
		}

		public float getHumidity() {
			return humidity;
		}

		// Setter Methods

		public void setTemp(float temp) {
			this.temp = temp;
		}

		public void setFeels_like(float feels_like) {
			this.feels_like = feels_like;
		}

		public void setTemp_min(float temp_min) {
			this.temp_min = temp_min;
		}

		public void setTemp_max(float temp_max) {
			this.temp_max = temp_max;
		}

		public void setPressure(float pressure) {
			this.pressure = pressure;
		}

		public void setHumidity(float humidity) {
			this.humidity = humidity;
		}
	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Coord {
		private float lon;
		private float lat;

		// Getter Methods

		public float getLon() {
			return lon;
		}

		public float getLat() {
			return lat;
		}

		// Setter Methods

		public void setLon(float lon) {
			this.lon = lon;
		}

		public void setLat(float lat) {
			this.lat = lat;
		}
	}
}
