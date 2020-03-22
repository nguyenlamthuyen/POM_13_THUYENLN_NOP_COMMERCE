package nop.commerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractPages;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.FooterMyAccountPageObject;
import pageObjects.nopCommerce.FooterNewProductPageObject;
import pageObjects.nopCommerce.FooterSearchPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_09_RegisterAndLogin_Undisplayed extends AbstractTest {
	private WebDriver driver;
	private WebElement element;
	private Date date;
	private String email, password, registerSuccessMsg;

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browserName) {
//		System.out.println("Browser name = " + browserName);
//		System.out.println("AUT Url = " + autUrl);
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_checkDisplayed() {
		registerPage = homePage.clickToRegisterLink();

		// Firstname textbox displayed
		Assert.assertTrue(registerPage.isFirstnameTextboxDisplayed());
	}

	@Test
	public void TC_02_CheckUndisplayed_In_DOM() {
		// Request verification token undisplayed (có trong DOM)	
		Assert.assertTrue(registerPage.isRequestVerifyTokenTextboxUndisplayed());

	}

	@Test
	public void TC_03_CheckUndisplayed_Not_In_DOM() {
		// Register button undisplayed (ko có trong DOM)
		Assert.assertTrue(registerPage.isRegisterButtonUndisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
