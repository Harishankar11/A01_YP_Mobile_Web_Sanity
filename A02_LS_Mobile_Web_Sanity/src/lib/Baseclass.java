package lib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;



public class Baseclass{
	
public WebDriver driver;

	
	//@BeforeClass
	public void MobileBrowser()
	{
		FirefoxProfile FFP = new FirefoxProfile();
		FFP.setPreference("general.useragent.override", "iPhone");
		driver = new FirefoxDriver(FFP);
		driver.manage().window().setSize(new Dimension(400,800));
	}
	
	@BeforeClass
	public void MobileChromeBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "./Files/chromedriver.exe");

    Map<String, String> mobileEmulation = new HashMap<String, String>(); 

    mobileEmulation.put("deviceName", "Google Nexus 5");  

    Map<String, Object> chromeOptions = new HashMap<String, Object>(); 

    chromeOptions.put("mobileEmulation", mobileEmulation); 

    	DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 

    	capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions); 

    	driver = new ChromeDriver(capabilities); 
    	
    	driver.manage().window().maximize();
	}
	
	@AfterClass
	public void quit()
	{
		driver.quit();
		
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Capturescreenshot(driver, result.getName());
		}
		
	}
	
	
	public void Capturescreenshot(WebDriver driver, String Screenshotname)
	{
		try
		{
		
			Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("dd_MM-HH_mm");  
		    String strDate= formatter.format(date);  
			
		
		
		TakesScreenshot TS = (TakesScreenshot)driver;
		File Source = TS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("./Screenshots/"+strDate+Screenshotname+".png"));
		System.out.println("Screenshot taken");
		}
		catch(Exception ie)
		{
			System.out.println("Sceenshot is not taken");
		}
		
		
	}
	
		
}

