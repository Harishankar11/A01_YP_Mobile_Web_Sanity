package lcfFaces;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B2_MDLD_PaidProfile_GetQuote extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_PaidProfile_GetQuote() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		
		//String url="http://www.sulekha.com/vls-logistic-supply-chain-service-isanpur-ahmedabad-contact-address#popup";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		//get quote button
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='filter fixed']//li[3]")).click();
		
		Thread.sleep(2000);
		
		commonforms();
		
		
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
	}

}
