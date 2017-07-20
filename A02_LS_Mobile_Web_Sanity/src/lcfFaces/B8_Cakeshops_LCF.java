package lcfFaces;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B8_Cakeshops_LCF extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void Cakeshops_LCF() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="https://www.sulekha.com/cake-shops/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Next
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
		
		contactinfo();
				
		Thread.sleep(3000);
		
		OTP();
		
		Thread.sleep(3000);
		
		ThankorDash();
		
	}

}
