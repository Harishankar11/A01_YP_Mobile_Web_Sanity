package lcfFaces;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B7_MDLD_DateSelectionLCF extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_DateSelectionLCF() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="https://www.sulekha.com/playschools/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		commonforms();
		
		//calendar question
		
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				
				String d3 = driver.findElement(By.xpath("//td[@class='today day']")).getText();
				
				Reporter.log("Selected Date : "+d3, true);
				
				driver.findElement(By.xpath("//td[@class='today day']")).click();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				
		Multilocality();
		
		contactinfo();
		
		
		OTP();
		
		ThankorDash();
		
	}

}
