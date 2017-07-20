package lcfFaces;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class C1_SearchEnterbutton extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void SearchLCF() throws InterruptedException
	
	{
		
		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		
		Thread.sleep(500);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//div[@class='search-wrap']/div[2]/input")).click();
		
		driver.findElement(By.xpath("//a[@class='search-icon']")).click();
		
		driver.findElement(By.xpath("//div[@class='icons-mobile']//input")).sendKeys("pack");
		
		driver.findElement(By.xpath("//div[@class='icons-mobile']//input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(500);
		
		WebDriverWait wait = new WebDriverWait(driver, 15); 	Thread.sleep(500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti1']")));
		
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();	
		
		
		Thread.sleep(2000);
		
		commonforms();
		
		Singlelocality();
		
		contactinfo();
		
		
		OTP();
		
		ThankorDash();
		
	}

}
