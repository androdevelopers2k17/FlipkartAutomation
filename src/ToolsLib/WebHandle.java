package ToolsLib;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebHandle {
	static WebDriver driver;

	public static WebDriver launchBrowser() throws SessionNotCreatedException {
		try {
			Log.info("Driver Setup initiated");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		} catch (Exception e) {
			Log.error("Driver Setup Failed : "+e.getMessage().toString());
			return driver;
		}
	}

	public boolean launchBrowser(String Browser) {

		return false;
	}
}
