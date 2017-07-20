package lcfFaces;


import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A5_MDLD_Brand_locality_B2U extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_Brand_locality_B2U() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		
		//String url="http://www.sulekha.com/projector-repair-services/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		commonforms();
		
		Singlelocality();
	
		contactinfo();
		
		OTP();
		
		ThankorDash();
	
	}

}
