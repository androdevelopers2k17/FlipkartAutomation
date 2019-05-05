package ToolsLib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebHandle {
	static WebDriver driver;

	public static WebDriver launchBrowser() throws SessionNotCreatedException {
		try {
			Log.info("Driver Setup initiated");
			driver = new ChromeDriver();
			return driver;
		} catch (Exception e) {
			Log.error("Driver Setup Failed : " + e.getMessage().toString());
			return driver;
		}
	}

	public static WebDriver launchBrowser(String sBrowser, String sBaseURL) {
		sBrowser = sBrowser.toUpperCase();
		if (sBrowser.equalsIgnoreCase("CHROME")) {
			setSystemProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (sBrowser.equalsIgnoreCase("FIREFOX")) {
			setSystemProperty("webdriver.firefox.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (sBrowser.equalsIgnoreCase("IE")) {
			setSystemProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else
			driver = launchBrowser();
		loadURL(sBaseURL);
		return driver;
	}

	public static void setSystemProperty(String sDriverName, String sDriverLoader) {
		System.setProperty(sDriverName, sDriverLoader);
	}

	public static boolean loadURL(String sBaseURL) {
		driver.get(sBaseURL);
		waitForPageLoad();
		driver.manage().window().maximize();
		return false;
	}

	public static void waitForPageLoad()
	{
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}};
			WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
	}
	public static boolean isElementAvailable(By byLocater)
	{
		try{
			WebElement webElement=driver.findElement(byLocater);
			if(webElement!=null)
				return true;
			else
				return false;	
		}
		catch (NoSuchElementException NE) {
			return false;
		}
		catch(Exception e)
		{
			Log.error("Element Find Exception : " + e.getMessage().toString());
		}
		
		return false;
		
	}
}
