/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import library.CaptureScreenshot;
import tests.BaseClass;

/**
 * @author SG0304279
 * @date 1 Feb 2019
 */
public class SetRestrictionsPage{
	
	WebDriver driver;
	protected WebDriverWait wait;
	By propertyName=By.xpath("//h2[@class='header-name']");
	String expectedPropertyName;
	
	public SetRestrictionsPage(WebDriver driver) {
		this.driver=driver;
	}

	public void verifyPropertyName(String actualPropertyName) {
		wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(propertyName));
		expectedPropertyName=driver.findElement(propertyName).getText();
		Assert.assertEquals(actualPropertyName, expectedPropertyName);
		System.out.println("Testcase Passed");
	}
	

}
