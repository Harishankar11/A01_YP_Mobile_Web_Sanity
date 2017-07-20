package lcfFaces;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A2_MDLD_attribute_page extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_attribute_page() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/bike-transport-services/chennai";
		
		
		String Attribute = "selected";
		
		driver.get(url);
		
		
		String sr1 = driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")).getAttribute("class");
		System.out.println("Pre-selected attribute class name : "+sr1);
		String sr2 = driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")).getText();
		System.out.println("Pre-selected attribute class name : "+sr2);
		
		SoftAssert assersion = new SoftAssert();
		
		assersion.assertTrue(sr1.equalsIgnoreCase(Attribute), " preselection is not working");
		
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[1]")).click();
		
		Reporter.log(url, true);
		
		commonforms();
		
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
		assersion.assertAll();
		
		
	}

}
