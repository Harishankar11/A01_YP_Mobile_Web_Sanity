package listingProfile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
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

import bsh.ParseException;
import lib.Retry;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class AA1_Mobile_VDL_Listing {

	WebDriver driver;
	String url = "https://www.sulekha.com/ac-services/chennai";
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

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);

		String s1 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@id='filter']")).click();

		Thread.sleep(2000);

		// Locality

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Locality']")));

		driver.findElement(By.xpath("//*[text()='Locality']")).click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")));

		String s2 = driver.findElement(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")).getText();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")).click();

		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// apply buttom
		driver.findElement(By.xpath("//a[@class='apply']")).click();

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String s3 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();

		Reporter.log("Business list first business before filter : " + s1, true);

		Reporter.log("Business list first business after filter : " + s2, true);

		Reporter.log("Filter values : " + s2, true);

		Assert.assertTrue(s1 != s2, "Business order not getting suffle");

		Assert.assertTrue(s3.contains(s2), "Locality filter working fine");
		// ********************
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		((JavascriptExecutor) driver).executeScript("scroll(100,0)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='filter']")).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='stags']//a")));

		driver.findElement(By.xpath("//div[@class='stags']//a")).click();

		// Attribute

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='filterpanel']//li[1]/label"));
		ele.get(0).click();

		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// apply buttom
		driver.findElement(By.xpath("//a[@class='apply']")).click();

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String s4 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();

		Reporter.log("Business list first business before filter : " + s3, true);

		Reporter.log("Business list first business after filter : " + s4, true);

		Assert.assertTrue(s4 != s3, "Business order not getting suffle");

	}

	@Test(enabled = true, priority = 2 , retryAnalyzer = Retry.class )

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

			Thread.sleep(2000);
			WebElement Ele = driver.findElement(By.cssSelector(".list-item"));
			Thread.sleep(2000);
			List<WebElement> sp = Ele.findElements(By.cssSelector(".btn-t.savePhoneEmail"));
			sp.get(0).click();
			Thread.sleep(6000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("txtMobile")).clear();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(1000);
			driver.findElement(By.id("txtMobile")).sendKeys("9380835000");
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("btnSavetoPhonePopup")).click();
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> s1 = driver.findElements(By.cssSelector("input[class='txt-otp']"));
			s1.get(1).sendKeys("999999");
			// driver.findElement(By.cssSelector("input[class='txt-otp']")).sendKeys("999999");
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

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		Thread.sleep(3000);

		List<WebElement> ele = driver.findElements(By.xpath("//a[@class='btn-p needlcfpop']"));

		ele.get(0).click();

		Thread.sleep(3000);

		if (driver.findElement(By.xpath("//div[1]/section/div/div[1]/div[1]")).isDisplayed()) {
			System.out.println("Get quote LCF available");
			Reporter.log("Getquote LCF appeared");

		} else {
			System.out.println("Get quote LCF not available");
			Reporter.log("Getquote LCF not appeared");
		}

	}

	@Test(enabled = true, priority = 4, retryAnalyzer = Retry.class)
	public static void US_API_City_selection() throws ParseException, net.minidev.json.parser.ParseException {

		try {
			String webPage = "http://ls-location-api.azurewebsites.net/api/location/ip/35.163.151.89";
			String name = "sulekha";
			String password = "kJ!ve3~q9+fNpuEC";

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();
			String txt = result;
			JSONObject JsonIdURL = (JSONObject) new JSONParser().parse(txt);
			String str = (String) JsonIdURL.get("CountryCode");
			System.out.println("CountryCode--" + str);
			if (str.contentEquals("US")) {
				Reporter.log("Country code displayed correctly");
				Reporter.log("Displayed message : " + str);
			} else {
				Reporter.log("Country code displayed wrongly");
				Reporter.log("Displayed message : " + str);
				Assert.fail();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void after() {
		driver.quit();
	}

}
