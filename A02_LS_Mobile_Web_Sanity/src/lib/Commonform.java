package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Commonform extends Commonmethod {

	public void commonforms() {

		for (int i = 1; i <= 8; i++) {
			try {

				// check data type LIST = cate, 1, BRAND = 2, CITY = 3, LOCALITY
				// = 4, DATE = 5, country = 6, CUSTOM = 7, SCHEDULING_BASIC = 8
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				Explicitwait(15, "//div[contains(@class, 'active')]");

				WebElement ele = driver.findElement(By.xpath("//div[contains(@class, 'active')]"));

				ele.isDisplayed();

				String datatype = driver.findElement(By.xpath("//div[contains(@class, 'active')]"))
						.getAttribute("data-type");
				Thread.sleep(1000);
				if (datatype.equalsIgnoreCase("cate")) {

					// Explicitwait(20, "//div[contains(@class,
					// 'active')][@data-type='cate']//li[1]//input");
					// check radio / check box
					String type = driver
							.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='cate']//li[1]//input"))
							.getAttribute("type");

					// Click on first attribute value
					String data = driver
							.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='cate']//li[1]"))
							.getText();

					driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='cate']//li[1]")).click();

					Reporter.log("Selected Attribute : " + data, true);

					Reporter.log("Check box / Radio  : " + type, true);

					Thread.sleep(6000);

					Nextbutton(type);

					Thread.sleep(1000);

				} else if (datatype.equalsIgnoreCase("3")) {

					// Explicitwait(20, "//div[contains(@class,
					// 'active')][@data-type='3']//li[1]//input");
					// check radio / check box
					String type = driver
							.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='3']//li[1]//input"))
							.getAttribute("type");

					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					// Click on first attribute value
					String data = driver
							.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='3']//li[2]"))
							.getText();

					driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='3']//li[2]")).click();

					Reporter.log("Selected Attribute : " + data, true);

					Reporter.log("Check box / Radio  : " + type, true);

					Thread.sleep(1000);

					Nextbutton(type);

					Thread.sleep(500);

				}

				else {

					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

					String type = driver
							.findElement(By.xpath(
									"//div[contains(@class, 'active')][@data-type='" + datatype + "']//li[1]//input"))
							.getAttribute("type");

					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

					String data = driver
							.findElement(
									By.xpath("//div[contains(@class, 'active')][@data-type='" + datatype + "']//li[1]"))
							.getText();

					driver.findElement(
							By.xpath("//div[contains(@class, 'active')][@data-type='" + datatype + "']//li[1]"))
							.click();

					Reporter.log("Selected Attribute : " + data, true);

					Reporter.log("Check box / Radio  : " + type, true);

					Thread.sleep(1000);

					Nextbutton(type);

					Thread.sleep(500);

				}

			} catch (Exception ie1) {
				i = i - 1;
				System.out.println("Total form count : " + i);
				break;

			}

		}
	}

	public void Nextbutton(String type) throws InterruptedException {

		if (type.equalsIgnoreCase("checkbox")) {
			WebDriverWait wait = new WebDriverWait(driver, 10);

			Thread.sleep(500);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-p.nextBtn.nxtbtn")));

			driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();

			Thread.sleep(2000);

		} else {

			Thread.sleep(2000);

		}

	}

}

// existing code reference

/*
 * public void commonforms() {
 * 
 * for(int i=1;i<=8;i++) { try{
 * 
 * //check data type LIST = cate, 1, BRAND = 2, CITY = 3, LOCALITY = 4, DATE =
 * 5, country = 6, CUSTOM = 7, SCHEDULING_BASIC = 8 WebDriverWait wait = new
 * WebDriverWait(driver, 15); Thread.sleep(500);
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
 * xpath("//div[contains(@class, 'active')]")));
 * 
 * WebElement ele =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')]"));
 * 
 * ele.isDisplayed();
 * 
 * String datatype =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')]")).
 * getAttribute("data-type"); Thread.sleep(500);
 * if(datatype.equalsIgnoreCase("3")) {
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // check
 * radio / check box String type =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]//input")).getAttribute("type");
 * 
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Click on
 * first attribute value String data =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[2]")).getText();
 * 
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[2]")).click();
 * 
 * Reporter.log("Selected Attribute : "+ data, true);
 * 
 * Reporter.log("Check box / Radio  : "+ type, true);
 * 
 * Thread.sleep(1000);
 * 
 * Nextbutton(type);
 * 
 * Thread.sleep(3000);
 * 
 * } else {
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 * 
 * String type =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]//input")).getAttribute("type");
 * 
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 * 
 * String data =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]")).getText();
 * 
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]")).click();
 * 
 * 
 * Reporter.log("Selected Attribute : "+ data, true);
 * 
 * Reporter.log("Check box / Radio  : "+ type, true);
 * 
 * Thread.sleep(1000);
 * 
 * Nextbutton(type);
 * 
 * Thread.sleep(3000);
 * 
 * }
 * 
 * 
 * }catch(Exception ie1) { i = i-1; System.out.println("Total form count : "+i);
 * break;
 * 
 * }
 * 
 * 
 * } }
 */

/*
 * public void commonforms() {
 * 
 * for(int i=1;i<=8;i++) { try{
 * 
 * //check data type LIST = cate, 1, BRAND = 2, CITY = 3, LOCALITY = 4, DATE =
 * 5, country = 6, CUSTOM = 7, SCHEDULING_BASIC = 8
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 * 
 * String datatype =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')]")).
 * getAttribute("data-type");
 * 
 * if(datatype.equalsIgnoreCase("3")) {
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // check
 * radio / check box String type =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]//input")).getAttribute("type");
 * 
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Click on
 * first attribute value String data =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[2]")).getText();
 * 
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[2]")).click();
 * 
 * Reporter.log("Selected Attribute : "+ data, true);
 * 
 * Reporter.log("Check box / Radio  : "+ type, true);
 * 
 * Thread.sleep(2000);
 * 
 * Nextbutton(type);
 * 
 * Thread.sleep(3000);
 * 
 * } else {
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 * 
 * String type =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]//input")).getAttribute("type");
 * 
 * 
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 * 
 * String data =
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]")).getText();
 * 
 * driver.findElement(By.xpath("//div[contains(@class, 'active')][@data-type='"
 * +datatype+"']//li[1]")).click();
 * 
 * 
 * Reporter.log("Selected Attribute : "+ data, true);
 * 
 * Reporter.log("Check box / Radio  : "+ type, true);
 * 
 * Thread.sleep(2000);
 * 
 * Nextbutton(type);
 * 
 * Thread.sleep(3000);
 * 
 * }
 * 
 * 
 * }catch(Exception ie1) { i = i-1; System.out.println("Total form count : "+i);
 * break;
 * 
 * }
 * 
 * 
 * } }
 */
