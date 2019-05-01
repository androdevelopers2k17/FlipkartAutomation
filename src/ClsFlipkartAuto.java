import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author barunkum
 *
 */
public class ClsFlipkartAuto {
	static Boolean fnIsElementAvailable(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException NE) {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			Log.startTestCase("Flipkart Mobile Order");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://www.google.com");
			Log.info("Web Driver Initiated");
			driver.findElement(By.xpath("//a[contains(@id,'gb_70')]")).click();
			driver.findElement(By.id("identifierId")).sendKeys("arun.ark512");
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(5000);
			if (fnIsElementAvailable(driver, By.xpath("//span[contains(text(),'More ways to sign in')]"))) {
				Log.info("Multiple Options Available for Logging in");
				driver.findElement(By.xpath("//span[contains(text(),'More ways to sign in')]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[contains(text(),'Enter your password')]")).click();
				Log.warn("Password sign in option is now selected");
			} else
				Log.warn("Password sign in option is now selected");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("arkSally%12");
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Log.info("Login Processing");
			if (fnIsElementAvailable(driver, By.xpath("//a[contains(text(),'Gmail')]"))) {
				Log.info("Login Successful!");
				driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[@class='gb_cb gbii']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
				Log.warn("Signed out!");
			} else
				Log.error("Oops..Wrong Password!");
			Log.endTestCase("Google Account Signin");
		} catch(WebDriverException | InterruptedException we) {

		}
	}
}
