package lcfFaces;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class A0_MobileLCFposted_SMS {
	
	static WebDriver driver;
	
	@BeforeClass
	public void MobileFirefoxBrowser()
	{
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","iPhone");
		driver = new FirefoxDriver(profile);Dimension d = new Dimension(420,720);
		
		driver.manage().window().setSize(d);
		
	}
	
	@AfterClass
	public void quit()
	{
		driver.quit();
		
	}

	@Test
	public void LCFPosting() throws InterruptedException {
		
		try {
			MobileLCFposted_SMS();
			} catch (Exception ie) {
			try{
				MobileLCFposted_SMS();
				}catch (Exception ie1) {
				
				 Reporter.log(  "Lcf not posted successfully");	
				 driver.get("http://ypsmsindia.sulekha.com/sendsms.aspx?mobileno=8667428646&message1="+"Alert! Mobile Web LCF submission not working."); //hari
				/* driver.get("http://ypsmsindia.sulekha.com/sendsms.aspx?mobileno=8870384148&message1="+"Alert! Mobile Web LCF submission not working."); //madan
				 driver.get("http://ypsmsindia.sulekha.com/sendsms.aspx?mobileno=8667428646&message1="+"Alert! Mobile Web LCF submission not working."); //hari 
				 driver.get("http://ypsmsindia.sulekha.com/sendsms.aspx?mobileno=9962552141&message1="+"Alert! Mobile Web LCF submission not working."); //chennam       
				 driver.get("http://ypsmsindia.sulekha.com/sendsms.aspx?mobileno=9884616313&message1="+"Alert! Mobile Web LCF submission not working."); //prabhu
				 driver.get("http://ypsmsindia.sulekha.com/sendsms.aspx?mobileno=7904996653&message1="+"Alert! Mobile Web LCF submission not working."); //prabhu
				 driver.get("http://ypsmsindia.sulekha.com/sendsms.aspx?mobileno=9952358328&message1="+"Alert! Mobile Web LCF submission not working."); //prakash
*/				 Assert.fail();
			   }
			}

	}
	
	
	public static void MobileLCFposted_SMS() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		Thread.sleep(2000);
		
		String Url = "https://www.sulekha.com/ac-services/chennai";
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(Url);Reporter.log(Url,true);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'active')]")));Thread.sleep(500);  // category - first quest
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='cate']//li[1]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")));Thread.sleep(500);  //  second quest
		
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")));Thread.sleep(500);  //  Third quest
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-p.nextBtn.nxtbtn")));Thread.sleep(500); // Next button
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")));Thread.sleep(500);  //  Fourth quest
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'active')][@data-type='2']//li[1]")));Thread.sleep(500);  //  Fifth quest
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='2']//li[1]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-p.nextBtn.nxtbtn")));Thread.sleep(500); // Next button
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")));Thread.sleep(500);  //  sixth quest
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'active')][@data-type='8']//li[1]")));Thread.sleep(500);  //  Seventh quest
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='8']//li[1]")).click();
		
		Reporter.log("LCF Forms are selected", true);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")));Thread.sleep(500);//Locality
		driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lcf-loc']//ul[@class='sl-list radio']//li[5]")));Thread.sleep(500); //locality
		driver.findElement(By.xpath("//div[@class='lcf-loc']//ul[@class='sl-list radio']//li[5]")).click();
	
		Reporter.log("LCF Locality seleted", true);
		Thread.sleep(2000);
		
		//Contact form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='lcftxtmobile']")));Thread.sleep(500);
		driver.findElement(By.cssSelector("input[name='lcftxtmobile']")).clear();
		driver.findElement(By.cssSelector("input[name='lcftxtmobile']")).sendKeys("9380835000");

		// User Name
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);Thread.sleep(500);
		driver.findElement(By.cssSelector("input[name='lcftxtname']")).clear();
		driver.findElement(By.cssSelector("input[name='lcftxtname']")).sendKeys("Harish");

		// Email
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);Thread.sleep(500);
		driver.findElement(By.cssSelector("input[name='lcftxtemail']")).clear();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn-p nextBtn']")));Thread.sleep(500); // Next
		driver.findElement(By.cssSelector("button[class='btn-p nextBtn']")).click();
		
		Reporter.log("LCF Contact info submitted", true);
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='lcftxtvcode']"))); Thread.sleep(500);// OTP
		driver.findElement(By.cssSelector("input[name='lcftxtvcode']")).sendKeys("999999");
		
		Reporter.log("LCF OTP entered", true);
		
		int i;
		for (i = 1; i < 20; i++) {

			String dashurl = driver.getCurrentUrl();
			
			if (dashurl.contains("xxxxxxxxxxx")) { //dashboard

				Reporter.log("Dashboard landed succesfully - LCF submitted PASS", true);

				break;

			} else {

				Thread.sleep(4000);
			}
			
			if (i == 19) {
				Reporter.log("==== LCF submission not landed on Dashboard ===", true);
				driver.findElement(By.id("Hari"));//Failing the test case after condition is true
			}
		}
		
		
	}	
	
}
