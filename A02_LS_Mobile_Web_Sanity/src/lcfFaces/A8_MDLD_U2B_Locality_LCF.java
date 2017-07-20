package lcfFaces;

import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A8_MDLD_U2B_Locality_LCF extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_U2B_Locality_LCF() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/womens-hostel/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		commonforms();
		
		Multilocality();
		
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
		
		
		
		
		
	}

}
