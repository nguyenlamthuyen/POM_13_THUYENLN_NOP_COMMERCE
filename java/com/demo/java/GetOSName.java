package com.demo.java;

public class GetOSName {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		System.out.println(osName.toLowerCase());

		if(osName.toLowerCase().contains("windows")) {
			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		} else if(osName.toLowerCase().contains("mac")) {
			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver");
		}
	}

}
