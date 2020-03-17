package browserFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{

	@Override
	void createDriver() {
		// Add service and new driver
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");
		driver = new ChromeDriver(options);
		
	}
	
	

}
