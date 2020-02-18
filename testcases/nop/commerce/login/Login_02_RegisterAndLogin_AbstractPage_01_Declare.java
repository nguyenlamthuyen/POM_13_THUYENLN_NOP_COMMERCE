package nop.commerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;

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

public class Login_02_RegisterAndLogin_AbstractPage_01_Declare {
	private WebDriver driver;
	private Select select;
	private String email, password;
	// Declare an instance of Abstract Page
	private AbstractPage abstractPage;
	private WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {
//		String osName = System.getProperty("os.name");
//		System.out.println(osName.toLowerCase());
//
//		if(osName.toLowerCase().contains("windows")) {
//			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
//		} else if(osName.toLowerCase().contains("mac")) {
//			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver");
//		}
//		
//		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Init Abstract Page
//		abstractPage = new AbstractPage();

		abstractPage = new AbstractPage(driver);
		
//		abstractPage = new AbstractPage(wait);

		abstractPage.openUrl("https://demo.nopcommerce.com/");

		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {

		// Click to Register link
		abstractPage.clickToElement("//a[@class='ico-register']");

		// Select item in Day
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']", "1");

		// Select item in Month
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", "February");

		// Select item in Year
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']", "1986");

		// Input to Company textbox
		driver.findElement(By.cssSelector("#Company")).sendKeys("Corona Virus");

		// Click male radio button
		abstractPage.clickToElement("//input[@id='gender-male']");
		
		// Input to Firstname textbox
		abstractPage.sendKeyToElement("//input[@id='FirstName']", "Corona307");

		// Input to Lastname textbox
		abstractPage.sendKeyToElement("//input[@id='LastName']", "Virus");

		// Input to Email textbox
		abstractPage.sendKeyToElement("//input[@id='Email']", email);

		// Input to Password textbox
		abstractPage.sendKeyToElement("//input[@id='Password']", password);

		// Input to ConfirmPassword textbox
		abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", password);

		// Click to Register button
		abstractPage.clickToElement("//input[@id='register-button']");

		// Verify registered success
		String resultText = abstractPage.getTextElement("//div[@class='result']");
		Assert.assertEquals(resultText, "Your registration completed");

		// Logout to System
		abstractPage.clickToElement("//a[@class='ico-logout']");
	}

	@Test
	public void TC_02_LoginToSystem() {

		// Click Login link
		abstractPage.clickToElement("//a[@class='ico-login']");

		// Input to Email textbox
		abstractPage.sendKeyToElement("//input[@id='Email']", email);

		// Input to Password textbox
		abstractPage.sendKeyToElement("//input[@id='Password']", password);

		// Click to Login button
		abstractPage.clickToElement("//input[@class='button-1 login-button']");

		// Verify My Account link displayed
		Assert.assertTrue(abstractPage.isElementDisplayed("//a[@class='ico-account']"));
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
