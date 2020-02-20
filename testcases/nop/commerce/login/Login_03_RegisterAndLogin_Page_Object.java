package nop.commerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractPages;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_03_RegisterAndLogin_Page_Object extends AbstractPages {
	private WebDriver driver;
	private String email, password, registerSuccessMsg;

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		openUrl(driver, "https://demo.nopcommerce.com/");
		
		homePage = new HomePageObject(driver);

		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {

		// Click to Register link
		registerPage = homePage.clickToRegisterLink();
		
		// Input to Lastname textbox
		registerPage.inputToLastNameTextbox("Foster");
		
		// Input to Firstname textbox
		registerPage.inputToFirstNameTextbox("Sarah");
		
		// Select item in Day
		registerPage.selectDayDropdown("8");

		// Select item in Month
		registerPage.selectMonthDropdown("August");

		// Select item in Year
		registerPage.selectYearDropdown("1988");

		// Input to Company textbox
		registerPage.inputToCompanyTextbox("Sarah Channel");

		// Click male radio button
		registerPage.clickToMaleRadio();

		// Input to Email textbox
		registerPage.inputToEmailTextbox(email);

		// Input to Password textbox
		registerPage.inputToPasswordTextbox(password);

		// Input to ConfirmPassword textbox
		registerPage.inputToConfirmPasswordTextbox(password);

		// Click to Register button
		registerPage.clickToRegisterButton();

		// Verify registered success
		registerSuccessMsg = registerPage.getRegisterSuccessMessage();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");

		// Logout to System
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_LoginToSystem() {
		// Click Login link
		loginPage = homePage.clickToLoginLink();

		// Input to Password textbox
		loginPage.inputToPasswordTextbox(password);
		
		// Input to Email textbox
		loginPage.inputToEmailTextbox(email);

		// Click to Login button
		homePage = loginPage.clickToLoginButton();
		
		// Verify My Account link displayed
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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
