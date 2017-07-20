package listingProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.Retry;

public class AA2_Mobile_NonCore_Listing {

	WebDriver driver;
	String url = "https://www.sulekha.com/banks/chennai";
	String city = "Chenna";
	String cat = "ac duct";
	String Mob = "9380835000";
	int tc4 = 1, tc8 = 1, tc6 = 1;

	@BeforeTest

	public void before() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Files/chromedriver.exe");

		Map<String, String> mobileEmulation = new HashMap<String, String>();

		mobileEmulation.put("deviceName", "Google Nexus 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();

		chromeOptions.put("mobileEmulation", mobileEmulation);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		driver = new ChromeDriver(capabilities);

	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retry.class)

	public void TC001_Filterby() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 25);

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		try {
			// Frame popup

			WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));

			driver.switchTo().frame(ele);
			
			Thread.sleep(2000);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//div[@class='close-action-container']")).click();

			driver.switchTo().defaultContent();

		} catch (Exception ie) {
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);

		String s1 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@id='filter']")).click();

		Thread.sleep(4000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")));

		Thread.sleep(500);
		String s2 = driver.findElement(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")).getText();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")).click();

		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@class='apply']")).click();

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String s3 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();

		Reporter.log("Business list first business before filter : " + s1, true);

		Reporter.log("Business list first business after filter : " + s2, true);

		Reporter.log("Filter values : " + s2, true);

		Assert.assertTrue(s1 != s2, "Business order getting suffle");

		Assert.assertTrue(s3.contains(s2), "Locality filter working fine");

	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retry.class)

	public void TC002_Listing_SavetoPhone() throws InterruptedException {

		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			// Frame popup

			WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));

			driver.switchTo().frame(ele);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//div[@class='close-action-container']")).click();

			driver.switchTo().defaultContent();

		} catch (Exception ie) {
		}

		Thread.sleep(2000);

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			Thread.sleep(3000);
			WebElement Ele = driver.findElement(By.cssSelector(".list-item"));
			Thread.sleep(1000);
			List<WebElement> sp = Ele.findElements(By.cssSelector(".btn-t.savePhoneEmail"));
			sp.get(0).click();
			Thread.sleep(4000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("txtMobile")).clear();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("txtMobile")).sendKeys("9380835000");
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("btnSavetoPhonePopup")).click();
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("input[class='txt-otp']")).sendKeys("999999");
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(".btn-t.closeclick")).click();

			Reporter.log("Save to phone working fine", true);
		} catch (Exception e7) {

			Reporter.log("Save to phone is not working fine", true);
			Assert.fail();
		}

	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retry.class)
	public void TC003_GetquoteButtonHide() throws Exception {

		driver.navigate().to(url);
		driver.manage().window().maximize();

		try {
			// Frame popup

			WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));

			driver.switchTo().frame(ele);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//div[@class='close-action-container']")).click();

			driver.switchTo().defaultContent();

		} catch (Exception ie) {
		}

		List<WebElement> ele = driver.findElements(By.xpath("//a[@class='btn-p needlcfpop']"));

		if (ele.size() >= 2) {
			Reporter.log("Get quote button is display", true);
			Assert.fail();
		} else {
			Reporter.log("Get quote button is not display", true);
		}
	}

	@AfterTest
	public void after() {
		driver.quit();
	}

}
