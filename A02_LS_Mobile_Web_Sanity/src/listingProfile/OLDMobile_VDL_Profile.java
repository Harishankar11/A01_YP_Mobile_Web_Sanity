package listingProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.Retry;



public class OLDMobile_VDL_Profile {

	WebDriver driver;int tc9=1;
	String url="http://www.sulekha.com/category-king-locality9-ypcity-contact-address";
	String url1="http://www.sulekha.com/zee-computers-india-pvt-ltd-nehru-place-delhi-contact-address";
	String city="Chennai"; String cat="Overseas Engineering";String Mob="9380835000";
	
	
	@BeforeTest
	public void before() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "./Files/chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<String, String>(); 

        mobileEmulation.put("deviceName", "Google Nexus 5");  

        Map<String, Object> chromeOptions = new HashMap<String, Object>(); 

        chromeOptions.put("mobileEmulation", mobileEmulation); 

        DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 

		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions); 

		driver = new ChromeDriver(capabilities); 
		
	    /*ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    driver.manage().window().maximize();*/

	}
	

	@Test(enabled=true,priority=1,retryAnalyzer = Retry.class)
	public void TC001_Profile_Getquote() throws InterruptedException{
	
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(0));
 
    driver.get(url);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	Thread.sleep(2000);
	Reporter.log(url);    
	driver.findElement(By.cssSelector(".btn-t.needlcfpop")).click();
		Thread.sleep(2000);
		
		if (driver.getCurrentUrl().contains("getquotes")) {
			System.out.println("Get quote form open");
			Reporter.log("Get quote Pass");
		} else {
			System.out.println("Get quote form not open");
			Reporter.log("Get quote Fail");
		}
}

	@Test(enabled=true,priority=2,retryAnalyzer = Retry.class)
	public void TC002_SaveToPhone() throws Exception{ 
		
		 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(0));
		    
		    driver.get(url);
		    Thread.sleep(2000);
		Reporter.log(url);
		    WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divsavetophone")));
			Thread.sleep(500);
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(500);
			
	//Click save to phone		
	    driver.findElement(By.id("divsavetophone")).click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtMobile")));
		Thread.sleep(500);
	    driver.findElement(By.id("txtMobile")).clear();
	    driver.findElement(By.id("txtMobile")).sendKeys("9380835000");
	    Thread.sleep(500);
	    driver.findElement(By.id("btnSavetoPhonePopup")).click();
	    Thread.sleep(1000);
	    
	 //Enter OTP   
	    
	    try {
	    	  if (driver.findElement(By.xpath("//div[5]/div[2]/div[1]/div[1]/div/div/input")).isDisplayed()){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]/div[2]/div[1]/div[1]/div/div/input")));
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[5]/div[2]/div[1]/div[1]/div/div/input")).click();
		driver.findElement(By.xpath("//div[5]/div[2]/div[1]/div[1]/div/div/input")).sendKeys("999999");
		driver.findElement(By.xpath("//button[@class='btn-p verify-otp']")).click();
	    	  }
	    } catch (Exception e1){System.out.println("OTP page not came");}
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div/div[2]/h4")));
	    Thread.sleep(500);
		String t=driver.findElement(By.xpath("html/body/div[3]/div/div[2]/h4")).getText();
	    System.out.println(t);
	    
	    if (t.contains("Thank you"))
	    {
	    	System.out.println("Save to phone pass");
	    	Reporter.log("Save to phone pass");
	    	
	    } 
	    
	    driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
	    Thread.sleep(500);
	    
	    driver.findElement(By.id("divsavetophone")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
	    } 
				
	  @Test(enabled=true,priority=3,retryAnalyzer = Retry.class)
			public void TC003_VerifySymbol() throws InterruptedException{
				
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(0));
			    
			    driver.get("https://www.sulekha.com/jai-sri-sai-ram-packers-movers-palavakkam-chennai-contact-address");
			    Thread.sleep(4000);
			    Thread.sleep(2000);
			    Reporter.log("https://www.sulekha.com/jai-sri-sai-ram-packers-movers-palavakkam-chennai-contact-address");
				driver.findElement(By.xpath("//span[@class='bus-verified']")).isDisplayed();
				
				 System.out.println("Verify symbol displayed");
				   Reporter.log("Verify symbol displayed near Business name");
			    
		}
	       
	
		
	@AfterTest
	public void after(){
		driver.quit();
	}
	
}
