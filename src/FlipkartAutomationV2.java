import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ToolsLib.Log;
import ToolsLib.WebHandle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlipkartAutomationV2 {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		Log.startTestCase("Flipkart Automation Testing Started");
		String sBrowser = "Chrome";
		String sBaseURL = "https://www.flipkart.com/";
		driver = WebHandle.launchBrowser(sBrowser, sBaseURL);
		if (driver != null) {
			Log.info("Driver Loaded With " + sBaseURL);
		} else
			Log.error("Driver Not Yet Started!");
	}

	@After
	public void testTermination() throws Exception {
		try {
			driver.quit();
			Log.info("WebDriver Wipe Completed");
			Log.endTestCase("Flipkart Automation Testing Ended");
		} catch (Exception e) {
			Log.error("Exception Occur : " + e.getMessage().toString());
		}
	}

	@Test
	public void testProcess() throws Exception {
		try {
			Log.info("Test Started");
			System.out.println("Element is Available? "
					+ WebHandle.isElementAvailable(By.xpath("(//*/button/span[contains(text(),'Login')])")));
		} catch (Exception e) {
			Log.error("Exception Occur : " + e.getMessage().toString());
		}
	}

}
