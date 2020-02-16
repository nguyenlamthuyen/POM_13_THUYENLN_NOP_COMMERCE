package nop.commerce.login;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_01_RegisterAndLogin {
	private WebDriver driver;
	private Select select;
	private String email, password;

	@BeforeTest
	public void beforeTest() {
//		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		email = "corona" + randomNumber() + "@gmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {		
		driver.get("https://demo.nopcommerce.com/");
		
		// Click to Register link
		driver.findElement(By.cssSelector(".ico-register")).click();

		// Select item in Day
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		select.selectByVisibleText("1");

		// Select item in Month
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		select.selectByVisibleText("February");

		// Select item in Year
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select.selectByVisibleText("1986");

		// Input to Company textbox
		driver.findElement(By.cssSelector("#Company")).sendKeys("Corona Virus");
		
		// Click male radio button
		driver.findElement(By.cssSelector("#gender-male")).click();

		// Input to Firstname textbox
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Corona307");

		// Input to Lastname textbox
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Virus");
		
		// Input to Email textbox
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);

		// Input to Password textbox
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);

		// Input to ConfirmPassword textbox
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);

		// Click to Register button
		driver.findElement(By.cssSelector("#register-button")).click();

		// Verify registered success
		String resultText = driver.findElement(By.cssSelector(".result")).getText();
		Assert.assertEquals(resultText, "Your registration completed");

		// Logout to System
		driver.findElement(By.cssSelector(".ico-logout")).click();
		
	
	}

	@Test
	public void TC_02_LoginToSystem() {
		driver.get("https://demo.nopcommerce.com/");
		
		// Click Login link
		driver.findElement(By.cssSelector(".ico-login")).click();

		// Input to Email textbox
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);

		// Input to Password textbox
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		
		// Click to Login button
		driver.findElement(By.cssSelector(".login-button")).click();
		
		// Verify My Account link displayed 
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
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
