package lcfFaces;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;

public class C3_AttributeType extends Commonform {

	@Test(retryAnalyzer = Retry.class)
	public void Need1AttributeType() throws InterruptedException

	{

		String name = this.getClass().getSimpleName();

		System.out.println(name);

		dynamicdata obj1 = new dynamicdata();

		String url = obj1.urlpicker(name);

		// String url="https://www.sulekha.com/cleaning-services/chennai";

		WebDriverWait wait = new WebDriverWait(driver, 15);

		driver.get(url);

		Reporter.log(url, true);


		Thread.sleep(500);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		

		for (int j = 1; j <= 3; j++) {
			
			String a1[] = { "radio", "checkbox", "radio", "checkbox" };
			String a2[] = { "radio", "radio", "radio" };
			String a3[] = { "radio", "checkbox", "radio", "radio"};
			int b = 0;

			for (int i = 1; i <= 5; i++) {

				try {

					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

					WebElement ele = driver.findElement(By.xpath("//div[contains(@class, 'active')]"));

					ele.isDisplayed();

					String datatype = driver.findElement(By.xpath("//div[contains(@class, 'active')]"))
							.getAttribute("data-type");
					

					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					// check radio / check box
					
					String type = driver
							.findElement(By.xpath(
									"//div[contains(@class, 'active')][@data-type='" + datatype + "']//li["+j+"]//input"))
							.getAttribute("type");
					
					if(j==1)
					{

					Reporter.log("First need " + i + " Attribute type is correct > " + a1[b] + " : " + type, true);

					Assert.assertTrue(type.equalsIgnoreCase(a1[b]), "issue in page attribute types");
					
					} else if(j==2)
					{
						Reporter.log("First need " + i + " Attribute type is correct > " + a2[b] + " : " + type, true);

						Assert.assertTrue(type.equalsIgnoreCase(a2[b]), "issue in page attribute types");
					} else {
						
						Reporter.log("First need " + i + " Attribute type is correct > " + a3[b] + " : " + type, true);

						Assert.assertTrue(type.equalsIgnoreCase(a3[b]), "issue in page attribute types");
					}

					// Click on first attribute value
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

					String data = driver
							.findElement(
									By.xpath("//div[contains(@class, 'active')][@data-type='" + datatype + "']//li["+j+"]"))
							.getText();

					driver.findElement(
							By.xpath("//div[contains(@class, 'active')][@data-type='" + datatype + "']//li["+j+"]"))
							.click();

					Reporter.log("Selected Attribute : " + data, true);

					Thread.sleep(3000);

					Nextbutton(type);

					Thread.sleep(1000);

					b++;

				} catch (Exception ie1) {
					
					Thread.sleep(1000);
					
					driver.findElement(By.cssSelector("input[name='lcftxtmobile']")).clear();  //veriry attribute is completed
					
					driver.navigate().to(url);
					
					Thread.sleep(1000);
					
					i = i - 1;
					
					Reporter.log("Total form count : " + i, true);
					
					Reporter.log("********** "+j+" need completed ", true); Reporter.log("  ", true);
					
					break;

				}

			}
			
			

		}
	}

}
