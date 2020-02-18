package nop.commerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractPages;

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
	private Select select;
	private String email, password;
	// Declare an instance of Abstract Page
	private WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		openUrl(driver, "https://demo.nopcommerce.com/");

		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {

		// Click to Register link
		clickToElement(driver, "//a[@class='ico-register']");

		// Select item in Day
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "1");

		// Select item in Month
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "February");

		// Select item in Year
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1986");

		// Input to Company textbox
		driver.findElement(By.cssSelector("#Company")).sendKeys("Corona Virus");

		// Click male radio button
		clickToElement(driver, "//input[@id='gender-male']");
		
		// Input to Firstname textbox
		sendKeyToElement(driver, "//input[@id='FirstName']", "Corona307");

		// Input to Lastname textbox
		sendKeyToElement(driver, "//input[@id='LastName']", "Virus");

		// Input to Email textbox
		sendKeyToElement(driver, "//input[@id='Email']", email);

		// Input to Password textbox
		sendKeyToElement(driver, "//input[@id='Password']", password);

		// Input to ConfirmPassword textbox
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		// Click to Register button
		clickToElement(driver, "//input[@id='register-button']");

		// Verify registered success
		String resultText = getTextElement(driver, "//div[@class='result']");
		Assert.assertEquals(resultText, "Your registration completed");

		// Logout to System
		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_02_LoginToSystem() {

		// Click Login link
		clickToElement(driver, "//a[@class='ico-login']");

		// Input to Email textbox
		sendKeyToElement(driver, "//input[@id='Email']", email);

		// Input to Password textbox
		sendKeyToElement(driver, "//input[@id='Password']", password);

		// Click to Login button
		clickToElement(driver, "//input[@class='button-1 login-button']");

		// Verify My Account link displayed
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
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
