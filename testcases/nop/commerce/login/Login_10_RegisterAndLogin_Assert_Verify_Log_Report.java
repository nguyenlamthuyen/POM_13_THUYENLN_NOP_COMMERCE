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
import org.testng.annotations.Optional;
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

public class Login_10_RegisterAndLogin_Assert_Verify_Log_Report extends AbstractTest {
	private WebDriver driver;
	private HomePageObject homePage;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Assert() {
		log.info("TC_01 - Step 01: Open New Customer Page");
//		newCustomerPage = homePage.openNewCustomerPage(driver);

		log.info("TC_01 - Step 02: Verify New Customer page displayed");
		Assert.assertTrue(true);

		log.info("TC_01 - Step 03: Verify New Customer form not displayed");
		Assert.assertTrue(false);

		log.info("TC_01 - Step 04: Verify Home Page not displayed");
		Assert.assertTrue(true);

	}

	@Test
	public void TC_02_Verify() {
		log.info("TC_02 - Step 01: Open New Customer Page");
//		newCustomerPage = homePage.openNewCustomerPage(driver);

		log.info("TC_02 - Step 02: Verify New Customer page displayed");
		verifyTrue(true);

		log.info("TC_02 - Step 03: Verify New Customer form not displayed");
		verifyTrue(false);

		log.info("TC_02 - Step 04: Verify Home Page not displayed");
		verifyTrue(true);
		
		log.info("TC_02 - Step 05: Verify New Customer form not displayed");
		verifyTrue(false);

	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

}
