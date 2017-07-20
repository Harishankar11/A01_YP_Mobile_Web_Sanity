package lcfFaces;


import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B4_MDLD_SEM_Page extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_SEM_Page() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/packers-and-movers/chennai?pagetype=sem";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		commonforms();
		
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
	}

}
