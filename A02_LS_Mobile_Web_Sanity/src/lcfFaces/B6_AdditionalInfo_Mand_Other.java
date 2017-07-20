package lcfFaces;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B6_AdditionalInfo_Mand_Other extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void AdditionalInfo_Mand_Other() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/packers-and-movers/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		commonforms();
		
		//back
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//div[@class='step step2']//div[@class='form-footer']//button[2]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='step step1']//div[@class='form-footer']//button[2]")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Select multi select attribute
		String d1 = driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[4]")).getText();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='1']//li[4]")).click();
		
		Reporter.log("Selected Other attribute : "+d1, true);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Next
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
		
		//calendar question
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String d2 = driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='8']//li[3]")).getText();
		
		Reporter.log("Selected Date schedule attribute : "+d2, true);
		
		driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='8']//li[3]")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String d3 = driver.findElement(By.xpath("//td[@class='today day']")).getText();
		
		Reporter.log("Selected Date : "+d3, true);
		
		driver.findElement(By.xpath("//td[@class='today day']")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Next
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
		
		contactinfo();
		
		addinfo();
		
		OTP();
		
		ThankorDash();
		
	}

}
