package lcfFaces;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A1_MDLD_with_Locality extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_with_Locality() throws InterruptedException
	
	{
		
		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		
		String locality = "velachery";
		
		/*String locality = "velachery";
		String url="http://www.sulekha.com/drivers/"+locality+"-chennai";*/

		driver.get(url);
		
		Reporter.log(url, true);
		
		Thread.sleep(3000);
		
		commonforms();
		//locality
			
		String sr1 = driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")).getText();
		System.out.println("Pre-selected locality : "+sr1);
		
		SoftAssert assersion = new SoftAssert();
		
		assersion.assertTrue(sr1.equalsIgnoreCase(locality), "Error is preselection locality is not matched");
		
		
		contactinfo();

		//addinfo();
		
		OTP();

		
		ThankorDash();
		
		assersion.assertAll();
		
		
	}

}
