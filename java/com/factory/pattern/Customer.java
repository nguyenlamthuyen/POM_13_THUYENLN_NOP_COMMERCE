package com.factory.pattern;

public class Customer {

	public static void main(String arrg[]) {
		Customer customer = new Customer();
		
		customer.viewHonda();
		customer.viewLexus();
		customer.viewHuyndai();
		
		CarFactory carFactory = new CarFactory();
		
		carFactory.viewCar("HONDA");
		carFactory.viewCar("LEXUS");
		carFactory.viewCar("HUYNDAI");
	}
	
	public void viewHonda() {
		// Cửa hàng Honda (Q1)
		Honda honda = new Honda();
		honda.viewCar();
		honda.getCarName();
		System.out.println(honda.getCarName());
	}
	
	public void viewLexus() {
		// Cửa hàng Lexus (Q5)
		Lexus lexus = new Lexus();
		lexus.viewCar();	
		System.out.println(lexus.getCarName());
	}
	
	public void viewHuyndai() {
		// Cửa hàng Huyndai (Q10)
		Huyndai huyndai = new Huyndai();
		huyndai.viewCar();		
		System.out.println(huyndai.getCarName());
	}
}
