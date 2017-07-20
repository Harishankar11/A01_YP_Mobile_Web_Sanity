package listingProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import lib.Retry;

public class OLDMobile_NonCore_Listing2 {
	
	WebDriver driver;
	String url="https://www.sulekha.com/banks/chennai";
	String city="Chenna"; 
	String cat="ac duct";
	String Mob="9380835000";
	int tc4=1,tc8=1,tc6=1;
	

	@BeforeMethod
	
	public void before() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "./Files/chromedriver.exe");

        Map<String, String> mobileEmulation = new HashMap<String, String>(); 

        mobileEmulation.put("deviceName", "Google Nexus 5");  

        Map<String, Object> chromeOptions = new HashMap<String, Object>(); 

        chromeOptions.put("mobileEmulation", mobileEmulation); 

        DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 

		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions); 

		driver = new ChromeDriver(capabilities); 
		
		
	}
	
	@Test(enabled=true,priority=1/*,retryAnalyzer=Retry.class*/)

	public void TC001_Filterby() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		try{
		//Frame popup
		
		WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		
		driver.switchTo().frame(ele);
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//div[@class='close-action-container']")).click();
			
		driver.switchTo().defaultContent();
		
		}catch(Exception ie){}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		String s1 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();
		
		Thread.sleep(4000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@id='filter']")).click();
		
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")));
		
		String s2 = driver.findElement(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")).getText();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='txtLocalitySearch']/following::label[1]")).click();

		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='apply']")).click();
		
		Thread.sleep(4000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		String s3 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();
		
		
		Reporter.log("Business list first business before filter : "+s1, true);
		
		Reporter.log("Business list first business after filter : "+s2, true);
		
		Reporter.log("Filter values : "+s2, true);
		
		Assert.assertTrue(s1 != s2, "Business order getting suffle" );
		
		Assert.assertTrue(s3.contains(s2), "Locality filter working fine");
		
	}
	
	
	@Test(enabled=true,priority=2, retryAnalyzer = Retry.class)//6
	public void TC002_SortOption() throws InterruptedException{
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		//
		
		try{
			//Frame popup
			
			WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
			
			driver.switchTo().frame(ele);
			
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[@class='close-action-container']")).click();
				
			driver.switchTo().defaultContent();
			
			}catch(Exception ie){}
				
				Thread.sleep(2000);
		String s1 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@data-target='.sort-by']")).click();
		Thread.sleep(2000);
		 //rating
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[@for='rating']")).click();
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String s2 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();
		
		Reporter.log("Business name first business before filter : "+s1, true);
		
		Reporter.log("Business name after rating : "+s2, true);
		
		Thread.sleep(2000);
		
		Assert.assertTrue(s1 != s2, "Business order getting suffle" );
		
		//default
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//button[@data-target='.sort-by']")).click();
		
		driver.switchTo().defaultContent();
		 
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//label[@for='default']")).click();
		
		Thread.sleep(4000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String s3 = driver.findElement(By.xpath("//h2//following::a[1]")).getText();
		
		Reporter.log("Business name after default : "+s3, true);
		
		//Assert.assertTrue(s2 != s3, "Business order getting suffle" );
		
		jse.executeScript("window.scrollBy(0,-250)", "");
		
		//score not given condition
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
				driver.findElement(By.xpath("//button[@data-target='.sort-by']")).click();
				 driver.switchTo().defaultContent();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@for='score']")).click();
				 driver.switchTo().defaultContent();
				 
				 
			
	}

	
   @Test(enabled=true,priority=3,retryAnalyzer = Retry.class)
	
	public void TC003_Listing_SavetoPhone() throws InterruptedException{
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try{
			//Frame popup
			
			WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
			
			driver.switchTo().frame(ele);
			
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[@class='close-action-container']")).click();
				
			driver.switchTo().defaultContent();
			
			}catch(Exception ie){}
		
		Thread.sleep(2000);
		
		try{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			

			Thread.sleep(5000);
		WebElement Ele=driver.findElement(By.cssSelector(".list-item"));
		Thread.sleep(1000);
		List<WebElement>sp=Ele.findElements(By.cssSelector(".btn-t.savePhoneEmail"));
		System.out.println(sp.size());
		Thread.sleep(500);
		System.out.println(sp.get(0).getText());
		sp.get(0).click();
	
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
		}catch (Exception e7) {
			
			Reporter.log("Save to phone is not working fine", true);
			Assert.fail();
		}
		
		
	
	}
    //@Test(enabled=true, priority=4,retryAnalyzer = Retry.class)

    public void TC004_ListingProfile_ScoreMatch()throws Exception{

    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(0));

    	driver.get(url);
    	driver.manage().window().maximize();
    	try{
			//Frame popup
			
			WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
			
			driver.switchTo().frame(ele);
			
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[@class='close-action-container']")).click();
				
			driver.switchTo().defaultContent();
			
			}catch(Exception ie){}
		
    	Thread.sleep(2000);
    	

String s1 = driver.findElement(By.xpath("//ol/li[1]/div[1]/div/span[3]/strong")).getText();
Thread.sleep(2000);
driver.findElement(By.xpath("//li[1]/div[1]/h3/a")).click();
Thread.sleep(500);
Thread.sleep(3000);
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
String s2 = driver.findElement(By.xpath("//div/div/span[2]/strong")).getText();
if(s1.equals(s2))
{
	System.out.println("Listing page: "+s1+", Profile page: "+s2+" -Sulekha score same in Listing and profile page:");
	Reporter.log("Listing page: "+s1+", Profile page: "+s2+" -Sulekha score same in Listing and profile page:");
} else {
	System.out.println("****Sulekha score mismatch with listing and profile page **********");
	Reporter.log("****Sulekha score mismatch with listing and profile page **********");
}

}


@Test(enabled=true, priority=5,retryAnalyzer = Retry.class)

	public void TC005_ListingProfile_Review()throws Exception{

driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs.get(0));

	driver.get(url);
	driver.manage().window().maximize();
	try{
		//Frame popup
		
		WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		
		driver.switchTo().frame(ele);
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//div[@class='close-action-container']")).click();
			
		driver.switchTo().defaultContent();
		
		}catch(Exception ie){}
	
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String s1 = driver.findElement(By.xpath("//li[1]/div[1]/div/span[1]")).getAttribute("class");//rating
	Thread.sleep(500);
	String s3 = driver.findElement(By.xpath("//li[1]/div[1]/div/span[2]")).getText();//Review count
	Thread.sleep(500);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[1]/div[1]/h3/a")).click();
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String s2 = driver.findElement(By.xpath("//div[1]/section/section/div[1]/div/div/span[1]")).getAttribute("class");//Rating
	Thread.sleep(500);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String s4 = driver.findElement(By.xpath("//div[1]/div/div/a/span")).getText();// Review count
	Thread.sleep(500);
	
	if(s2.contains(s1))
	{
		System.out.println("Listing page: "+s1+", Profile page: "+s2+" -Rating same in Listing and profile page:");
		Reporter.log("Listing page: "+s1+", Profile page: "+s2+" -Rating same in Listing and profile page:");
	} else {
		System.out.println("****Rating mismatch with listing and profile page **********");
		Reporter.log("****Rating mismatch with listing and profile page **********");
	}
	if(s3.equals(s4))
	{
		System.out.println("Listing page: "+s3+", Profile page: "+s4+" -Review count same in Listing and profile page:");
		Reporter.log("Listing page: "+s3+", Profile page: "+s4+" -Review count same in Listing and profile page:");
	} else {
		System.out.println("****Review count mismatch with listing and profile page **********");
		Reporter.log("****Review count mismatch with listing and profile page **********");
	}
	
	
}

	@Test(enabled=true, priority=6,retryAnalyzer = Retry.class)
	public void TC006_GetquoteButtonHide()throws Exception{

		driver.get(url);
		driver.manage().window().maximize();
	
		try{
			//Frame popup
			
			WebElement ele = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
			
			driver.switchTo().frame(ele);
			
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[@class='close-action-container']")).click();
				
			driver.switchTo().defaultContent();
			
			}catch(Exception ie){}
		
		
		List<WebElement> ele = driver.findElements(By.xpath("//a[@class='btn-p needlcfpop']"));
		
		if(ele.size()>=2)
		{
			Reporter.log("Get quote button is display", true);
			Assert.fail();
		}
		else
		{
			Reporter.log("Get quote button is not display", true);
		}
	}



@AfterMethod
public void after(){
	driver.quit();
}
	

}
