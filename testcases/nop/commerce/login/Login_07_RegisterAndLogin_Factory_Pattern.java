package nop.commerce.login;

import org.testng.annotations.Test;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_07_RegisterAndLogin_Factory_Pattern extends AbstractTest{
	private WebDriver driver;
	private String email, password, registerSuccessMsg;

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private DriverManager driverManager;

	@Parameters({ "browser"})
	@BeforeTest
	public void beforeTest(String browserName) {

//		driver = getBrowserDriver(browserName);
		driverManager = DriverManagerFactory.getBrowserManager(browserName);
		driver = driverManager.getBrowserDriver();

		homePage = PageGeneratorManager.getHomePage(driver);
		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.selectDayDropdown("8");
		registerPage.inputToFirstNameTextbox("Sarah");
		registerPage.inputToLastNameTextbox("Foster");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1988");
		registerPage.inputToCompanyTextbox("Sarah Channel");
		registerPage.clickToMaleRadio();
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		registerSuccessMsg = registerPage.getRegisterSuccessMessage();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToPasswordTextbox(password);
		loginPage.inputToEmailTextbox(email);
		homePage = loginPage.clickToLoginButton();
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
