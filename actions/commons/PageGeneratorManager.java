package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.FooterMyAccountPageObject;
import pageObjects.nopCommerce.FooterNewProductPageObject;
import pageObjects.nopCommerce.FooterSearchPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;

public class PageGeneratorManager {

	// Cấp phát việc khởi tạo đối tượng cho Home Page
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPageObject(driver);
	}
	
	public static FooterNewProductPageObject getFooterNewProductPage(WebDriver driver) {
		return new FooterNewProductPageObject(driver);
	}
	
	public static FooterSearchPageObject getFooterSearchPage(WebDriver driver) {
		return new FooterSearchPageObject(driver);
	}
}
