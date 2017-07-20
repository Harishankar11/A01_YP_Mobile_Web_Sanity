package lcfFaces;

import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A7_MDLD_B2U_Locality_LCF extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_B2U_Locality_LCF() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/valet-parking-drivers/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		commonforms();
		
		Singlelocality();
		
		contactinfo();
		
		//addinfo();
		
		OTP();
		
		ThankorDash();
		
		
		
		
		
		
	}

}
