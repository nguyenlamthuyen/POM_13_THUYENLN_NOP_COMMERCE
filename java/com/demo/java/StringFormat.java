package com.demo.java;

public class StringFormat {
	
	public static void main(String[] args) {
//		String EMPTY_EMAIL_MESSAGE = "//div[@id='advice-required-entry-email' and text()='%s']";
		
//		EMPTY_EMAIL_MESSAGE = String.format(EMPTY_EMAIL_MESSAGE, "This is a required field.");
		
//		System.out.println(EMPTY_EMAIL_MESSAGE);
		
		String DYNAMIC_FOOTER_LINK = "//div[@id='advice-required-entry-email' and text()='%s']";
		String DYNAMIC_HEADER_FOOTER_LINK = "//div[@id='%s' and text()='%s']";
		
		// 4 params
		String DYNAMIC_COUNTRY_TEXT = "//td[text()='%s']/following-sibling::td[@data-key='total']";
		String DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL = "//td[@data-key='females' and text()='%s']/following-sibling::td"
				+ "[@data-key='country' and text()='%s']/following-sibling::td"
				+ "[@data-key='males' and text()='%s']/following-sibling::td"
				+ "[@data-key='total' and text()='%s']";				
		
		clickToFooterLink(DYNAMIC_FOOTER_LINK, "Search");
		clickToFooterLink(DYNAMIC_FOOTER_LINK, "My account");
		clickToFooterLink(DYNAMIC_FOOTER_LINK, "Shopping cart");
		
		// 2 params
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "header", "Search");
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "header", "My account");
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "footer", "Shopping cart");
		
		// 1 para,
		clickToFooterLink(DYNAMIC_COUNTRY_TEXT, "Afghanistan");
		clickToFooterLink(DYNAMIC_COUNTRY_TEXT, "Algeria");
		
		// 4 param
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "338282", "Argentina", "349238", "687522");
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "276880", "Angola", "276472", "553353");
	}
	
	/*
	 * // 1 param public static void clickToFooterLink(String locator, String pageName) { locator = String.format(locator, pageName); System.out.println("Click to page with 1 param = " + locator); }
	 * 
	 * // 2 param public static void clickToFooterLink(String locator, String headerOrFooterName, String pageName) { locator = String.format(locator, headerOrFooterName, pageName);
	 * System.out.println("Click to page with 2 param = " + locator); }
	 * 
	 * // 4 param public static void clickToFooterLink(String locator, String female, String countryName, String male, String total) { locator = String.format(locator, female, countryName, male, total);
	 * System.out.println("Click to page with 2 param = " + locator); }
	 */

	// n params
	public static void clickToFooterLink(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("Click to page with n param = " + locator);
	}
}
