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

public class Login_08_RegisterAndLogin_Dynamic_Locator extends AbstractTest {
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
//		System.out.println("Browser name = " + browserName);
//		System.out.println("AUT Url = " + autUrl);
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

//	@Test
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

//	@Test
	public void TC_02_LoginToSystem() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToPasswordTextbox(password);
		loginPage.inputToEmailTextbox(email);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test(description = "Only use incase less page")
	public void TC_03_Dynamic_Less() {
		// Home Page -> My Account (Footer)
		myAccountPage = (FooterMyAccountPageObject) homePage.openFooterPageByName(driver, "My account");
		myAccountPage.sleepInSecond(2);

		// My Account -> Search
		searchPage = (FooterSearchPageObject) myAccountPage.openFooterPageByName(driver, "Search");
		searchPage.sleepInSecond(2);

		// Search -> New products
		newProductPage = (FooterNewProductPageObject) searchPage.openFooterPageByName(driver, "New products");
		newProductPage.sleepInSecond(2);

		// New products -> Home page
		homePage = newProductPage.openHomePage(driver);
		homePage.sleepInSecond(2);

		// Home Page -> Search
		searchPage = (FooterSearchPageObject) homePage.openFooterPageByName(driver, "Search");
		searchPage.sleepInSecond(2);

		// Search -> My Account
		myAccountPage = (FooterMyAccountPageObject) searchPage.openFooterPageByName(driver, "My account");

		// My Account -> New products
		newProductPage = (FooterNewProductPageObject) myAccountPage.openFooterPageByName(driver, "New products");

		// New product -> Search
		searchPage = (FooterSearchPageObject) newProductPage.openFooterPageByName(driver, "Search");
	}

	// Xử lý việc khởi tạo đối tượng page ở chính cái step trong testcase
	@Test(description = "Only use incase more page")
	public void TC_04_Dynamic_More() {
		// New Product -> My Account (Footer)
		newProductPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
		myAccountPage.sleepInSecond(2);

		// My Account -> Search
		myAccountPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getFooterSearchPage(driver);

		// Search -> New products
		searchPage.openFooterPageByName(driver, "New products");
		newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);

		// New products -> Home page
		homePage = newProductPage.openHomePage(driver);

		// Home Page -> Search
		homePage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getFooterSearchPage(driver);

		// Search -> My Account
		searchPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);

		// My Account -> New products
		myAccountPage.openFooterPageByName(driver, "New products");
		newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);

		// New product -> Search
		newProductPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getFooterSearchPage(driver);
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
