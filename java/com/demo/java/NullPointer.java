package com.demo.java;

public class NullPointer {
	static String name;
	
	public static void main(String[] args) {
		printFullName(name);
	}

	public static void printFullName(String name) {
		System.out.println(name);
	}
}
