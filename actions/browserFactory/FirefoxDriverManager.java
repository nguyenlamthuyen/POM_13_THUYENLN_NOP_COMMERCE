package browserFactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDriverManager extends DriverManager {

	@Override
	void createDriver() {
		// Add service and new driver
		/*
		 * String rootFolder = System.getProperty("user.dir"); FirefoxProfile profile = new FirefoxProfile(); profile.setAcceptUntrustedCertificates(false); profile.setAssumeUntrustedCertificateIssuer(true);
		 * profile.setPreference("dom.webnotifications.enabled", false); profile.setPreference("browser.download.folderList", 2); profile.setPreference("browser.helperApps.AlwaysAsk.force", false);
		 * profile.setPreference("browser.download.manager.shwowWhenStarting", false); profile.setPreference("browser.dowload.dir", rootFolder + "\\downloadFiles");
		 * profile.setPreference("browser.dowload.downloadDir", rootFolder + "\\downloadFiles"); profile.setPreference("browser.dowload.defaultFolder", rootFolder + "\\downloadFiles");
		 * profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/anytext, text/plain, text/html, application/plain"); driver = new FirefoxDriver((Capabilities) profile);
		 */
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		
	}

}
