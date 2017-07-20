package lcfFaces;


import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B9_Internet_Providers_LCF extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void Internet_Providers_LCF() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="https://www.sulekha.com/internet-service-providers/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		commonforms();
		
		Singlelocality();
		
		contactinfo();
		
		
		OTP();
		
		ThankorDash();
		
	}

}
