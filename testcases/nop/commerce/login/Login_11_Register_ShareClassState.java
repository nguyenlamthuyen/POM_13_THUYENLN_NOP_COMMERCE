package nop.commerce.login;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class Login_11_Register_ShareClassState extends AbstractTest{
	private WebDriver driver;

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	
	@Parameters({ "browser"})
	@BeforeTest
	public void beforeTest(@Optional("firefox") String browserName) {
//		System.out.println("Browser name = " + browserName);
//		System.out.println("AUT Url = " + autUrl);
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.password);
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.email);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		// Login success
	}

	@Test
	public void TC_01_ViewProduct() {

	}
	
	@Test
	public void TC_02_Order() {

	}
	
	@Test
	public void TC_03_Payment() {

	}

}
