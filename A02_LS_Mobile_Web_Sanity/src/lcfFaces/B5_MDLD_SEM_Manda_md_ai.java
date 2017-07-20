package lcfFaces;


import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B5_MDLD_SEM_Manda_md_ai extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_SEM_Manda_md_ai() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/cleaning-services/pune?pagetype=sem&md=ai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		commonforms();
		
		Singlelocality();
		
		contactinfo();
		
		addinfo();
		
		OTP();
		
		ThankorDash();
		
	}

}
