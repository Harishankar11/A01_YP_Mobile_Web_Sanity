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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.Retry;

public class OLDMobile_VDL_Listing {
	
	WebDriver driver;
	String url="https://www.sulekha.com/ac-services/chennai";
	String city="Chenna"; 
	String cat="ac duct";
	String Mob="9380835000";
	int tc4=1,tc8=1,tc6=1;

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
		
		
	}
	
	@Test(enabled=true,priority=1,retryAnalyzer=Retry.class)

	public void TC001_Filterby() throws InterruptedException{
		
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));

	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(2000);
		/*try{
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/a")).click();
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}catch(Exception ie){}*/
	    driver.findElement(By.id("filter")).isDisplayed();
			   
	    String title1=driver.findElement(By.xpath("//li[1]/div[1]/h3/a")).getText();
		Reporter.log("Displayed title in top without any filter selection  : "+title1);
		System.out.println("Title in top without any filter  : "+title1);
		Reporter.log("................................................................................");
		Thread.sleep(1000);
		
//Requirement filter
	    
	    try{
			  	driver.findElement(By.id("filter")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='chk22160']")).click();
		Thread.sleep(2000);
		String Require=driver.findElement(By.xpath("//div[4]/div[2]/div[3]/div[2]/div")).getText();
		System.out.println("Selected Requirement: "+Require);
		Reporter.log("Selected Requirement: "+Require);
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#applyFilter>a")).click();
		} catch (Exception ie5){
			
		}
		
		Thread.sleep(3000);
		String title2=driver.findElement(By.xpath("//div[2]/div[1]/ol/li[1]/div[1]/h3/a")).getText();
		Reporter.log("Displayed title in top after need filter selection : "+title2);
		System.out.println("Displayed title in top after choosing need at filter selection : "+title2);
		
		if(title1.contentEquals(title2)){
			Reporter.log("Requirement filter - FAIL");
			System.out.println("Requirement filter FAIL");
			tc4++;
		}else{
			Reporter.log("Requirement filter is  working");
			System.out.println("Requirement filter is  working");
		}
		Reporter.log("................................................................................");
			

//locality filter
				try{
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			Thread.sleep(1500);
		driver.findElement(By.id("filter")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Locality')]")).click();
		Thread.sleep(2000);
		String l=driver.findElement(By.xpath("//div[4]/div[2]/div[3]/div[3]/div/div/div[4]/ul/li[3]/label")).getText();
		driver.findElement(By.xpath("//div[4]/div[2]/div[3]/div[3]/div/div/div[4]/ul/li[3]/label")).click();
		Thread.sleep(2000);
		String loc=driver.findElement(By.xpath("//div[4]/div[2]/div[3]/div[2]/div")).getText();
		System.out.println(loc);
		
		driver.findElement(By.cssSelector("#applyFilter>a")).click();
		
		Thread.sleep(3000);	
		
		String title3=driver.findElement(By.xpath("//div[2]/div[1]/ol/li[1]/div[1]/h3/a")).getText();
		
		System.out.println("Displayed title in top after Locality filter selection : "+title3);
		Reporter.log("Displayed title in top after Locality filter selection : "+title3);
		
		
		if((title2.contentEquals(title3))||(!title3.contains(l))){
			System.out.println("Locality filter - FAIL");
			Reporter.log("Locality filter - FAIL");
			tc4++;
		}else{
			Reporter.log("Locality filter is working");
			System.out.println("Locality filter is working");
		}
		Reporter.log("................................................................................");
			} catch (Exception ie6){
	}
}
	
	
	@Test(enabled=true,priority=2,retryAnalyzer=Retry.class)//6
	public void TC002_SortOption() throws InterruptedException{

//New tab
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(0));
		   
			    driver.get(url);	
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(2000);
				/*try{
					driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
					Thread.sleep(2000);
					driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/a")).click();
					driver.switchTo().defaultContent();
					Thread.sleep(2000);
				}catch(Exception ie){}*/
//Sort
		String txt1=driver.findElement(By.xpath("//div[2]/div[1]/ol/li[1]/div[1]/h3")).getText();
		Reporter.log("Top SP at Short by Default: "+txt1);
		 System.out.println(txt1);
		 
		 Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@data-target='.sort-by']")).click(); 
	    driver.switchTo().defaultContent();
	    Thread.sleep(1000);
	    
// By rating	  
	    driver.findElement(By.xpath("//label[@for='rating']")).click();
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    String txt3=driver.findElement(By.xpath("//div[2]/div[1]/ol/li[1]/div[1]/h3")).getText();
	    Reporter.log("Top biz in By Rating :"+txt3);
	    System.out.println(txt3);
	    Thread.sleep(2000);
	    
	    if(!txt1.contentEquals(txt3)){
			String FRR = "##*********Sort by Rating is working fine*********#";
			Reporter.log(FRR);
	}else{
		String FRR = "##*********Sort by Rating is not working properly*********#";
		Reporter.log(FRR);
		tc6++;
	}    
	   
	    
//By score
	   
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(1500);
	    driver.findElement(By.xpath("//button[@data-target='.sort-by']")).click(); 
	    Thread.sleep(1000);
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//label[@for='score']")).click();
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    
	    WebElement scor=driver.findElement(By.cssSelector("#m_divV8Businesslist"));
	    List<WebElement>sc=scor.findElements(By.cssSelector(".sulekha-score>strong"));
	    for(int score=1;score<=sc.size()-1;score++){
	    	String num=sc.get(score).getText();
	    	Float num1 = Float.parseFloat(num.trim());
	    	
	    	String nxtnum=sc.get(score).getText();
	    	
	    	Float nxtnum1 = Float.parseFloat(nxtnum.trim());
	    	
	    	System.out.println(num1+"firs");
	    	System.out.println(nxtnum1+"nxt");
	    		if(num1 < nxtnum1){
	    			Reporter.log("Score filter fail");
	    			Reporter.log("Score for before Ad number"+num1);
	    			Reporter.log("Score for Ad number"+nxtnum);
	    			Reporter.log(".............................................");
	    			  tc6++;
	
	    		}else{
	    				Reporter.log("Score filter pass");
		    			Reporter.log("Score for before number"+num1);
		    			Reporter.log("Score for Ad number"+nxtnum);
		    			Reporter.log(".............................................");
	    			}
	    }
	    
	      
 //Default
		
			 Thread.sleep(3000);
			 
			 JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("window.scrollBy(0,-250)", "");
				Thread.sleep(1500);
				
			 driver.findElement(By.xpath("//button[@data-target='.sort-by']")).click(); 
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//label[@for='default']")).click();
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    String txt4=driver.findElement(By.xpath("//div[2]/div[1]/ol/li[1]/div[1]/h3")).getText();
	    System.out.println(txt4);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

 if(!txt1.contentEquals(txt3)){
	 String FRR = "##*********Sort by Rating is working fine*********#";
		Reporter.log(FRR);
	
}else{
	String FRR = "##*********Sort by Rating is not working properly*********#";
	Reporter.log(FRR);
	tc6++;
}
	

if(tc6>1){
	Assert.fail();
}
	}

	
@Test(enabled=true,priority=3,retryAnalyzer = Retry.class)
	
	public void TC003_Listing_SavetoPhone() throws InterruptedException{
	
	driver.get("https://www.sulekha.com/cake-shops/chennai");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(6000);

	
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
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("input[class='txt-otp']")).sendKeys("999999");
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector(".btn-t.closeclick")).click();
	
	Reporter.log("Save to phone working fine", true);
	}catch (Exception e7) {
		
		Reporter.log("Save to phone is not working fine", true);
	}
	
	
	}

@Test(enabled=true, priority=4,retryAnalyzer = Retry.class) //4

	public void TC004_Getquote()throws Exception{

driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs.get(0));

	driver.get(url);
	Thread.sleep(2000);
	
	Thread.sleep(3000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[1]/div[2]/div[1]/ol/li[1]/div[3]/ul/li[3]/a")).click();
	Thread.sleep(500);
	
	if (driver.findElement(By.xpath("//div[1]/section/div/div[1]/div[1]")).isDisplayed()){
		System.out.println("Get quote LCF available");
		Reporter.log("Getquote LCF appeared");
		
	}else
	{
	System.out.println("Get quote LCF not available");
	Reporter.log("Getquote LCF not appeared");
	}
	}


	@Test(enabled=true, priority=5,retryAnalyzer = Retry.class)

	public void TC005_ListingProfile_ScoreMatch()throws Exception{

driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs.get(0));

	driver.get(url);
	Thread.sleep(2000);
	
	Thread.sleep(3000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	
	String s1 = driver.findElement(By.xpath("//ol/li[1]/div[1]/div/span[3]/strong")).getText();
	Thread.sleep(500);
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


	@Test(enabled=true, priority=6,retryAnalyzer = Retry.class)	
	public void TC006_ListingProfile_Review()throws Exception{

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

	driver.get(url);
	Thread.sleep(2000);
	
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
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
	@Test(enabled=true, priority=7,retryAnalyzer = Retry.class)

	public void TC007_ListingVerifiedMark()throws Exception{

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

	driver.get(url);
	Thread.sleep(2000);
	
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String s1 = driver.findElement(By.xpath("//ol/li[1]/div[1]/h3/span")).getAttribute("class");
	Thread.sleep(500);
	if(s1.equals("bus-verified"))
	{
		System.out.println("Listing page: Verified button is display");
		Reporter.log("Listing page: Verified button is display");
	} else {
		System.out.println("****Verified button Not display **********");
		Reporter.log("****Verified button Not display **********");
	}
	
	
}

@AfterTest
public void after(){
	driver.quit();
}
	

}
