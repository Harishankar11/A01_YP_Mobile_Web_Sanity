package lcfFaces;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A9_MDLD_Need_page extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_MDLD_Need_page() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/commercial-vehicle-driver-services-n/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		boolean s1 = driver.findElement(By.xpath("//div[@class='lcf-needquestion']")).isDisplayed();
		
		Assert.assertTrue(s1, "Need page is not display");
		
		Reporter.log("LCF land on Need question", true);
		
		commonforms();
		
		Singlelocality();
		
		addinfo();
		
		contactinfo();
		

		OTP();
		
		ThankorDash();
		
	}

}
