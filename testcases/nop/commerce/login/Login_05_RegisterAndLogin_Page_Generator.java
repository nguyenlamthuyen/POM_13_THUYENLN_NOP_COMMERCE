package nop.commerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

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

public class Login_05_RegisterAndLogin_Page_Generator {
	private WebDriver driver;
	private String email, password, registerSuccessMsg;

	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("https://demo.nopcommerce.com/");
		
		// Nhược: Ko tuân theo nguyên tắc đóng gói của OOP
		// homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		// -------- 1 - Home Page -> Register page --------------
		// C2: Đưa việc khởi tạo vào trong hàm
		// Ưu: Thấy sự kết nối giữa 2 page
		// Ưu: Che dấu được sự khởi tạo
		// Click to Register link
		registerPage = homePage.clickToRegisterLink();
		
		// C1: Khởi tạo trực tiếp trên tầng testcase
		// Nhược: Ko có sự kết nối giữa 2 page
		// Nhược: Ko tuân theo nguyên tắc đóng gói của OOP
		// registerPage = new RegisterPageObject(driver);
	
		// Select item in Day
		registerPage.selectDayDropdown("8");
		
		// Input to Firstname textbox
		registerPage.inputToFirstNameTextbox("Sarah");
		
		// Input to Lastname textbox
		registerPage.inputToLastNameTextbox("Foster");

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
