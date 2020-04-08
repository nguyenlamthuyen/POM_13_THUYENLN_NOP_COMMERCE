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

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_12_RegisterAndLogin_Dynamic_Element_Component extends AbstractTest {
	private WebDriver driver;
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
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		homePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		registerPage.inputToTextboxByID(driver, "FirstName", "Sarah");
		registerPage.inputToTextboxByID(driver, "LastName", "Foster");
		
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", "8");
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", "August");
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", "1988");
		
		registerPage.inputToTextboxByID(driver, "Email", email);
		registerPage.inputToTextboxByID(driver, "Company", "Sarah Channel");
		
		// Click (Select)
		registerPage.clickToCheckboxByID(driver, "Newsletter", true);
		
		// Click (Deselect)
		registerPage.clickToCheckboxByID(driver, "Newsletter", false);
		
		registerPage.inputToTextboxByID(driver, "Password", password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
		
		registerPage.clickToButtonByValue(driver, "Register");
		
		registerSuccessMsg = registerPage.getRegisterSuccessMessage();
		verifyEquals(registerSuccessMsg, "Your registration completed");
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_02_LoginToSystem() {
		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.inputToPasswordTextbox(password);
		loginPage.inputToEmailTextbox(email);
		
		loginPage.clickToButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterTest
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
