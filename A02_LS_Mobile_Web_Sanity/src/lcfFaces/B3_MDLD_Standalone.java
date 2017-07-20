package lcfFaces;


import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B3_MDLD_Standalone extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_Standalone() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/pest-control-services/chennai?tp=getquotes";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		commonforms();
		
		Singlelocality();
		
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
	}

}
