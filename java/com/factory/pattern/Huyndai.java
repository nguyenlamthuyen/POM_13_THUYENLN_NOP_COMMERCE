package com.factory.pattern;

public class Huyndai extends Car {

	@Override
	public void viewCar() {
		System.out.println("Xem các loại xe của hãng xe Huyndai");
		
	}
	
	@Override
	public String getCarName() {
		String huyndaiName = "Tucson - Santafe - ..";
		return huyndaiName;
	}

}
