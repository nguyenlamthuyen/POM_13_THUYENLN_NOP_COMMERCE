package com.factory.pattern;

public class CarFactory {

	public void viewCar(String carType) {
		Car car;
		if(carType.equalsIgnoreCase("HONDA")) {
			car = new Honda();
			car.viewCar();
			car.getCarName();
		}else if(carType.equalsIgnoreCase("LEXUS")) {
			car = new Lexus();
			car.viewCar();
			car.getCarName();
		}else if(carType.equalsIgnoreCase("HUYNDAI")) {
			car = new Huyndai();
			car.viewCar();
			car.getCarName();
		}
	}
}
