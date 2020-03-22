package com.framework.datatable;

import org.testng.annotations.Test;

import commons.AbstractPages;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Handle_Dynamic_Datatable_Grid extends AbstractPages {
	WebDriver driver;
	String locator, total;
	int index;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Test
	public void TC_01_CLick_To_Page() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");

		// 5
		goToPageByPageNumber("5");
		sleepInSecond(2);
		Assert.assertTrue(isPageActivedByPageNumber("5"));

		// 10
		goToPageByPageNumber("10");
		sleepInSecond(2);
		Assert.assertTrue(isPageActivedByPageNumber("10"));

		// 16
		goToPageByPageNumber("16");
		sleepInSecond(2);
		Assert.assertTrue(isPageActivedByPageNumber("16"));
	}
	
//	@Test
	public void TC_02_Click_To_Icon_By_Country() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		
		// Remove
		clickToDynamicIconByCountryName("Afghanistan", "remove");
		sleepInSecond(1);
		clickToDynamicIconByCountryName("Armenia", "remove");
		
		// Edit
		clickToDynamicIconByCountryName("Australia", "edit");
		sleepInSecond(1);
	}
	
//	@Test
	public void TC_03_Get_Total_Value_By_Country() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		
		total = getTotalValueByCountryName("Argentina");
		System.out.println("Argentina = " + total);
		Assert.assertEquals(total, "687522");
		
		total = getTotalValueByCountryName("Algeria");
		System.out.println("Algeria = " + total);
		Assert.assertEquals(total, "578961");
	}
	
//	@Test
	public void TC_04_Input_To_Textbox() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
//		inputToTextboxByColumnNameAndRowNumber("company", "2", "KMS");
		inputToTextboxByColumnAndRow("Company", "2", "KMS");
		sleepInSecond(2);
		
//		inputToTextboxByColumnNameAndRowNumber("name", "1", "John Terry");
		inputToTextboxByColumnAndRow("Contact Person", "1", "John Terry");
		sleepInSecond(2);
		
//		inputToTextboxByColumnNameAndRowNumber("orderPlaced", "3", "500");
		inputToTextboxByColumnAndRow("Order Placed", "3", "500");
		sleepInSecond(2);
	}
	
	@Test
	public void TC_05_Click_Icon_By_Row() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		// Remove row 1
		clickToIconByRowNumber("Remove", "1");
		sleepInSecond(2);
		
		// Insert row 1
		clickToIconByRowNumber("Insert", "1");
		sleepInSecond(2);
		
		// Move Up row 3
		clickToIconByRowNumber("Move Up", "3");
		sleepInSecond(2);
	}
 
	// Go to page by page number
	public void goToPageByPageNumber(String pageNumber) {
		// interface - Page UI
		locator = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
		waitToElementClickable(driver, locator, pageNumber);
		clickToElement(driver, locator, pageNumber);
	}
	
	public boolean isPageActivedByPageNumber(String pageNumber) {
		locator = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
		waitToElementVisible(driver, locator, pageNumber);
		return isElementDisplayed(driver, locator, pageNumber);
	}
	
	public void clickToDynamicIconByCountryName(String countryName, String iconName) {
		locator = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
		waitToElementClickable(driver, locator, countryName, iconName);
		clickToElement(driver, locator, countryName, iconName);
	}
	
	public String getTotalValueByCountryName(String countryName) {
		locator = "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total']";
		waitToElementVisible(driver, locator, countryName);
		return getTextElement(driver, locator, countryName);
		
	}
	
	public void inputToTextboxByColumnNameAndRowNumber(String columnName, String rowNumber, String value) {
		locator = "//input[@id='tblAppendGrid_%s_%s']";
		waitToElementVisible(driver, locator, columnName, rowNumber);
		sendKeyToElement(driver, locator, value, columnName, rowNumber);
	}
	
	public void inputToTextboxByColumnAndRow(String columnName, String rowNumber, String value) {
		locator = "//th[text()='%s']/preceding-sibling::th";
		index = findElementsByXpath(driver, locator, columnName).size() + 1;	
		locator = "//tr["+rowNumber+"]/td["+ index +"]/input";
		waitToElementVisible(driver, locator);
		sendKeyToElement(driver, locator, value);
	}
	
	public void clickToIconByRowNumber(String iconName, String rowNumber) {
		locator = "//tr[%s]//button[contains(@title,'%s')]";
		waitToElementClickable(driver, locator, rowNumber, iconName);
		clickToElement(driver, locator, rowNumber, iconName);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
