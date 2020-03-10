package pageUIs.liveGuru;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='pass']";
	public static final String LOGIN_BUTTON = "//button[@id='send2']";
	public static final String EMPTY_EMAIL_ERROR_MESSAGE = "//div[@id='advice-required-entry-email' and text()='%s']";
	public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "//div[@id='advice-required-entry-pass' and text()='%s']";
	public static final String INVALID_EMAIL_ERROR_MESSAGE = "//div[@id='advice-validate-email-email' and text()='%s']";
	public static final String NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD_ERROR_MESSAGE = "//span[contains(.,'%s')]";
	public static final String PASSWORD_LESS_THAN_ERROR_MESSAGE = "//div[@id='advice-validate-password-pass' and text()='%s']";
}
