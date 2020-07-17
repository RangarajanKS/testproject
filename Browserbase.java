package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserbase {
	public static WebDriver driver;

	public static WebDriver StartBrowser(String browsername) {
		// If the browser is Firefox
		if (browsername.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.chrome.driver", "F:\\firefoxdriver.exe");
			driver = new FirefoxDriver();
		}

		// If the Chrome as browser
		else if (browsername.equalsIgnoreCase("Chrome")) {
			// Set the path for chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		// If the IE as browser
		else if (browsername.equalsIgnoreCase("IE")) {
			// Set the path for IEdriver.exe
			System.setProperty("webdriver.ie.driver", "F:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;

	}

	public void waits() {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	public void maximize() {

		driver.manage().window().maximize();

	}

 
}
