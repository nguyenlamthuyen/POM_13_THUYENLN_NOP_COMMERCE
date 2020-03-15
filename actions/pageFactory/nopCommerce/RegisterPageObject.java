package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPageFactory {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(id = "FirstName")
	private WebElement firstnameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastnameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	private WebElement dateDropdownList;
	
	@FindBy(name = "DateOfBirthMonth")
	private WebElement monthDropdownList;
	
	@FindBy(name = "DateOfBirthYear")
	private WebElement yearDropdownList;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Company")
	private WebElement companyTextbox;
	
	@FindBy(id = "Password")
	private WebElement passowrdTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(className = "result")
	private WebElement registerSuccessText;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutlink;

	public void selectDayDropdown(String expectedItem) {
		waitToElementClickable(driver, dateDropdownList);
		selectItemInDropdown(driver, dateDropdownList, expectedItem);
	}

	public void selectMonthDropdown(String expectedItem) {
		waitToElementClickable(driver, monthDropdownList);
		selectItemInDropdown(driver, monthDropdownList, expectedItem);
	}

	public void selectYearDropdown(String expectedItem) {
		waitToElementClickable(driver, yearDropdownList);
		selectItemInDropdown(driver, yearDropdownList, expectedItem);
	}

	public void clickToMaleRadio() {
		waitToElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementDisplayed(driver, firstnameTextbox);
		sendKeyToElement(driver, firstnameTextbox, firstNameValue);
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementDisplayed(driver, lastnameTextbox);
		sendKeyToElement(driver, lastnameTextbox, lastNameValue);
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementDisplayed(driver, passowrdTextbox);
		sendKeyToElement(driver, passowrdTextbox, passwordValue);
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementDisplayed(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPasswordValue);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitToElementDisplayed(driver, registerSuccessText);
		return getTextElement(driver, registerSuccessText);
	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, logoutlink);
		clickToElement(driver, logoutlink);
		return new HomePageObject(driver);
	}

	public void inputToCompanyTextbox(String companyValue) {
		waitToElementDisplayed(driver, companyTextbox);
		sendKeyToElement(driver, companyTextbox, companyValue);
	}

}
