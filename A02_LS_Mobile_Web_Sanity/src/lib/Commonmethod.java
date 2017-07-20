package lib;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;

public class Commonmethod extends Baseclass {

	/*
	 * LOCALITY XPATH
	 * 
	 * try{ String sr1 = driver.findElement(By.
	 * xpath("//div[contains(@class, 'form-group')][@data-type='loca']")).
	 * getText(); System.out.println(sr1+"First"); }catch(Exception ie){}
	 * 
	 * try{ String sr2 = driver.findElement(By.
	 * xpath("//div[contains(@class, 'form-group')][@data-type='loca']/div/div[1]"
	 * )).getText(); System.out.println(sr2+"second"); }catch(Exception ie){}
	 * 
	 * locality selection //div[@class='lcf-loc']//div[@class='sl-menu
	 * sl-has-search']//li[3] //div[@class='lcf-loc']//div[@class='sl-menu
	 * sl-has-done sl-has-search']//li[3]/label
	 * //div[@class='lcf-loc']//div[@class='sl-menu sl-has-done
	 * sl-has-search']//li[3]
	 */

	public void Singlelocality() throws InterruptedException {

		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")));

		driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='lcf-loc']//ul[@class='sl-list radio']//li[5]")));

		String r1 = driver.findElement(By.xpath("//div[@class='lcf-loc']//ul[@class='sl-list radio']//li[5]"))
				.getText();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='lcf-loc']//ul[@class='sl-list radio']//li[5]")));

		driver.findElement(By.xpath("//div[@class='lcf-loc']//ul[@class='sl-list radio']//li[5]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']/div/div[1]")));

		String r2 = driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']/div/div[1]"))
				.getText();

		Reporter.log("Selected locality : " + r1, true);
		// Reporter.log("Selected locality : "+r2, true);

		Assert.assertTrue(r1.equalsIgnoreCase(r2), "Selected localtiy is mismatch");

	}

	public void Multilocality() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		Thread.sleep(2000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")));

		driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//li[3]")));
		// option 1
		String r1 = driver
				.findElement(
						By.xpath("//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//li[3]"))
				.getText();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//li[3]"))
				.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// option 2

		String r3 = driver
				.findElement(
						By.xpath("//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//li[4]"))
				.getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//li[4]"))
				.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Reporter.log("Selected locality : " + r1 + ", " + r3, true);

		// done

		driver.findElement(By.xpath("//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//a"))
				.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String r2 = driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']/div/div[1]"))
				.getText();

		Assert.assertTrue(r2.contains(r1), "Selected localtiy is mismatch");

		Reporter.log("Multi locality selected : " + r2, true);
	}

	public void contactinfo() throws InterruptedException {

		Thread.sleep(2000);

		String name = "Hari";
		String Mobileno = "9380835000";

		// User Mobile
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='lcftxtmobile']")));

		driver.findElement(By.cssSelector("input[name='lcftxtmobile']")).clear();
		driver.findElement(By.cssSelector("input[name='lcftxtmobile']")).sendKeys(Mobileno);

		// User Name
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[name='lcftxtname']")).clear();
		driver.findElement(By.cssSelector("input[name='lcftxtname']")).sendKeys(name);

		// Email
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[name='lcftxtemail']")).clear();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn-p nextBtn']")));
		driver.findElement(By.cssSelector("button[class='btn-p nextBtn']")).click();

		// driver.findElement(By.xpath("//input[@name='lcftxtmobile']/following::button[1]")).click();

		Thread.sleep(3000);
		
		Reporter.log("Note: Contact info vaules are filled");

	}

	// without next button
	public void contactinfo1() throws InterruptedException {

		Thread.sleep(2000);

		String name = "Hari";
		String Mobileno = "9380835000";

		// User Mobile
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='lcftxtmobile']")));

		driver.findElement(By.cssSelector("input[name='lcftxtmobile']")).clear();
		driver.findElement(By.cssSelector("input[name='lcftxtmobile']")).sendKeys(Mobileno);

		// User Name
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[name='lcftxtname']")).clear();
		driver.findElement(By.cssSelector("input[name='lcftxtname']")).sendKeys(name);

		// Email
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[name='lcftxtemail']")).clear();
		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@name='lcftxtmobile']/following::button[2]")));

		driver.findElement(By.xpath("//input[@name='lcftxtmobile']/following::button[2]")).click();

		Thread.sleep(3000);

	}

	public void addinfo() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='txtaddinfo']")));

		driver.findElement(By.xpath("//textarea[@name='txtaddinfo']")).sendKeys("I want best service");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@name='lcftxtmobile']/following::button[1]")));

		driver.findElement(By.xpath("//input[@name='lcftxtmobile']/following::button[1]")).click();

		Reporter.log("Additional info text entered ", true);

		Thread.sleep(2000);

	}

	public void OTP() throws InterruptedException {
		String OTP = "999999";
		// OTP
		WebDriverWait wait = new WebDriverWait(driver, 30);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='lcftxtvcode']")));

		WebElement ele = driver.findElement(By.cssSelector("input[name='lcftxtvcode']"));

		ele.isDisplayed();

		driver.findElement(By.cssSelector("input[name='lcftxtvcode']")).sendKeys(OTP);
		
		Reporter.log("Note: OTP vaule is filled");
	}

	public void ThankorDash() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {

			// Thank content contain thank word
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector(".step.success-message.thank-you-step>h4")));
			String thank = driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText();

			if (thank.contains("Thank")) {

				Reporter.log("Thank you message is display", true);

			} else {

				Reporter.log("====Thank you message is not capture====", true);

			}
		} catch (Exception ie1) {

			System.out.println(ie1.getMessage());

		}

		Thread.sleep(2000);

		// Dashboard url contain Dashboard text
		int i;

		for (i = 1; i < 10; i++) {

			String dashurl = driver.getCurrentUrl();

			if (dashurl.contains("dashboard")) {

				Reporter.log("Dashboard landed succesfully", true);

				break;

			} else {

				Thread.sleep(4000);
			}
			if (i == 9) {
				Reporter.log("==== LCF submission not landed on Dashboard ===", true);
				driver.findElement(By.id("Hari"));//Failing the test case after condition is true
			}
		}
		
	}

	public void leadmatch() throws Throwable {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("btnUpdatestatus"));
			}
		});
		System.out.println("WebElement is displayed" + element.isDisplayed());

	}
	
	public void Explicitwait(int seconds, String waitxpath) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitxpath)));
		Thread.sleep(500);
	}

}
