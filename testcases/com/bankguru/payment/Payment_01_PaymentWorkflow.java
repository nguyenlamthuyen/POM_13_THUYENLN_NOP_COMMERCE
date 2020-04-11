package com.bankguru.payment;

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

public class Payment_01_PaymentWorkflow extends AbstractTest {
	private WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
	}

	@Test
	public void TC_01_RegisterToSystem() {

	}

	@Test
	public void TC_02_LoginToSystem() {

	}

	@AfterTest
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
