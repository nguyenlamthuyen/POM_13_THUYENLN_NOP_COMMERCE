package com.nopcommerce.common;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class Common_02_LoginToSystem extends AbstractTest {
	private WebDriver driver;
	public static String email, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters({ "browser" })
	@BeforeSuite
	public void login(@Optional("firefox") String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
		
		registerPage = homePage.clickToRegisterLink();
		registerPage.selectDayDropdown("8");
		registerPage.inputToFirstNameTextbox("Jessika");
		registerPage.inputToLastNameTextbox("Foster");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1988");
		registerPage.inputToCompanyTextbox("Sarah Channel");
		registerPage.clickToMaleRadio();
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		driver.quit();
	}

}
