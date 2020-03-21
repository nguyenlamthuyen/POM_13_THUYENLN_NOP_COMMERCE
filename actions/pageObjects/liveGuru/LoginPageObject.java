package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new MyDashboardPageObject(driver);
	}

	public boolean isEmptyEmailErrorMessageDisplayed(String errorMessage) {
		waitToElementVisible(driver, String.format(LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, errorMessage));
	}

	public boolean isEmptyPasswordErrorMessageDisplayed(String errorMessage) {
		waitToElementVisible(driver, String.format(LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE, errorMessage));
	}

	public boolean isInvalidEmailErrorMessageDisplayed(String errorMessage) {
		waitToElementVisible(driver, String.format(LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE, errorMessage));
	}

	public boolean isEmailNotExistOrInvalidPasswordErrorMessageDisplayed(String errorMessage) {
		waitToElementVisible(driver, String.format(LoginPageUI.NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD_ERROR_MESSAGE, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD_ERROR_MESSAGE, errorMessage));
	}

	public boolean isPasswordLessThan6CharsErrorMessageDisplayed(String errorMessage) {
		waitToElementVisible(driver, String.format(LoginPageUI.PASSWORD_LESS_THAN_ERROR_MESSAGE, errorMessage));
		return isElementDisplayed(driver, String.format(LoginPageUI.PASSWORD_LESS_THAN_ERROR_MESSAGE, errorMessage));
	}
}
