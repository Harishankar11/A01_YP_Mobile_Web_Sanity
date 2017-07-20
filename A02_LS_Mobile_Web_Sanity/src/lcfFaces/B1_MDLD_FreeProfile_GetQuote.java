package lcfFaces;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B1_MDLD_FreeProfile_GetQuote extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_FreeProfile_GetQuote() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="https://www.sulekha.com/gopalakrishna-driving-school-kelambakkam-chennai-contact-address";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		//get quote button
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='quotes fixed']/a")).click();
		
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Driving Schools']")));
		
		driver.findElement(By.xpath("//a[@title='Driving Schools']")).click();
		
		Thread.sleep(2000);
		
		commonforms();
		
		Singlelocality();
		
		contactinfo();
		
		/*Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Next
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
		
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Next last page
		driver.findElement(By.xpath("//textarea[@name='txtaddinfo']/following::button[1]")).click();
		*/
		OTP();
		
		ThankorDash();
		
	}

}
