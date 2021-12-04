package testbase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	
	
	public WebDriver driver;
	
	public DesiredCapabilities cap = new DesiredCapabilities();
	
	public WebDriver  launchBrowser(String browser) throws MalformedURLException {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName(BrowserType.CHROME);
			cap.setCapability("--start-maximized", true);
			cap.setCapability("--disable-notifications", true);
			cap.setCapability("ignore-certificate-errors", true);
			
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
			
		}else if(browser.equalsIgnoreCase("Firefox")) {
			cap.setBrowserName(BrowserType.FIREFOX);
			cap.setPlatform(Platform.ANY);
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(cap);
			
		}else if(browser.equalsIgnoreCase("Edge")) {
			cap.setBrowserName(BrowserType.EDGE);
			cap.setPlatform(Platform.ANY);
			
			EdgeOptions options = new EdgeOptions();
			options.merge(cap);
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

}
