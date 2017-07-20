package lcfFaces;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A4_MDLD_Brand_locality_U2B extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_Brand_locality_U2B() throws InterruptedException
	
	{
		
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/projector-repair-services/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		commonforms();
		
		
		//back
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='step step2']//div[@class='form-footer']//button[2]")).click();
		
		//back
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='step step1']//div[@class='form-footer']//button[2]")).click();
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Select multi select attribute
		String d1 = driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[2]")).getText();
		
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[2]")).click();
		
		Reporter.log("Location changed attribute : "+d1, true);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Next
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();

		/*driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Next
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();*/
		
		
		Multilocality();
	
		contactinfo();
		
		OTP();
		
		ThankorDash();

	}

}
