package pageUIs.nopCommerce;

public class AbstractPageUI {
	public static final String HOME_PAGE_LINK = "//div[@class='header-logo']//img";
	
	// Footer = 23 links (pages) = 23 locators
	public static final String FOOTER_SEARCH_LINK = "//a[text()='Search']";
	public static final String FOOTER_NEW_PRODUCT_LINK = "//a[text()='New products']";
	public static final String FOOTER_MY_ACCOUNT_LINK = "//a[text()='My account']";
	
	// Header link
	public static final String DYNAMIC_HEADER_LINK = "//div[@class='header']//a[text()='%s']";
	
	// Header Menu/ SubMenu
	public static final String DYNAMIC_HEADER_MENU_LINK = "//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[contains(text(), '%s')]";
	
	// Footer
	public static final String DYNAMIC_FOOTER_LINK = "//a[text()='%s']";

	// Textbox
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	
	// Radio Button
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@id='%s' and @type='radio']";
	
	// Checkbox
	public static final String DYNAMIC_CHECKBOX = "//input[@id='%s' and @type='checkbox']";
	
	// Dropdown List
	public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']";
	
	// Button
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
}
