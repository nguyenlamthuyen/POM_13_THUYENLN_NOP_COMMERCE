package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementDisplayed(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);
	}

}
