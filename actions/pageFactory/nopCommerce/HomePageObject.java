package pageFactory.nopCommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends AbstractPageFactory {
	private WebDriver driver;
	
	// Khởi tạo element
	
	public HomePageObject(WebDriver driver) {
		// Gán driver
		this.driver = driver;
		
		// Khởi tạo element và lưu vào trong cache
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		return new LoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementDisplayed(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

}
