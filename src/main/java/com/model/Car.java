package com.model;


public class Car {
	public String getModel() {
		return model;
	}

	public void setModel() {
		this.model = "default";
	}

	public Car(String model) {
		super();
		this.model = model;
	}

	private String model;
	
	
}
