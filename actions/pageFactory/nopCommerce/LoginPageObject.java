package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPageFactory {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	private WebElement loginButton;

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementDisplayed(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, passwordValue);
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		return new HomePageObject(driver);
	}

}
