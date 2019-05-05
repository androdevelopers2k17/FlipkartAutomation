import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import ToolsLib.Log;
import ToolsLib.WebHandle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlipkartAutomationV2 {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		Log.startTestCase("Flipkart Automation Testing");
		driver = WebHandle.launchBrowser();
		if (driver != null) {
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com");
		} else
			Log.error("Driver Not Yet Started!");
	}

	@After
	public void tearDown() throws Exception {
		try {
			driver.quit();
			Log.info("WebDriver Wipe Completed");
			Log.endTestCase("Facebook Account Signin");
		} catch (Exception e) {
		}
	}

	@Test
	public void signinCheck() throws Exception {
		try {
			Log.info("Test Started");
			driver.findElement(By.id("email")).sendKeys("9659135936");
			driver.findElement(By.id("pass")).sendKeys("arkMiracles%12");
			driver.findElement(By.id("u_0_2")).click();
			Thread.sleep(10000);

			if (fnIsElementAvailable(driver, By.xpath("//a[@href='https://www.facebook.com/settings?ref=mb&drop']"))) {
				Log.info("Login Success");
				driver.findElement(By.xpath("//a[@href='https://www.facebook.com/settings?ref=mb&drop']")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
				Thread.sleep(5000);
				Log.info("Logout");
			} else
				Log.error("Login Failed... Check Username Password");
		} catch (Exception e) {
		}
	}

	private boolean fnIsElementAvailable(WebDriver driver2, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException NE) {
			return false;
		}
	}

}
