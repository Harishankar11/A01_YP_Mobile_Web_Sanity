package lcfFaces;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A6_MDLD_Listing_GetQuote extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_Listing_GetQuote() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/transporters/chennai?q=Transporter#popup";
		
		driver.get(url); Reporter.log(url, true);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("scroll(0,600)");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//ol[@id='m_divV8Businesslist']/li[1]//li[3]/a")).click();
		
		System.out.println("Get quote button is clicked");
		
		commonforms();
		
		Singlelocality();
	
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
		
		
		
		
		
	}

}
