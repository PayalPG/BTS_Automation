/**
 * 
 */
package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.CaptureScreenshot;
import pages.PropertyProfilePage;
import pages.SetRestrictionsPage;

/**
 * @author SG0304279
 * @created on 27 Jan 2019
 *
 */
public class BaseClass {

	String baseUrl="https://bts-qa.shs.dev.asc.sabre.com/";
	protected WebDriver driver;
	
	PropertyProfilePage propertyProfilePage;
	SetRestrictionsPage setRestrictionsPage;
	
	
	@BeforeSuite
	public void setUp(){
		System.setProperty("webdriver.gecko.driver","C:\\Projects\\chromedriver.exe");
		driver=new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		System.out.println("Title is="+driver.getTitle()); 	
	}
	
	@BeforeTest
	public void initiateObject() {
		propertyProfilePage =new PropertyProfilePage(driver);	
		setRestrictionsPage=new SetRestrictionsPage(driver);
	}
	

	@AfterTest
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			CaptureScreenshot.captureScreenshot(driver,result.getName());
		}
		driver.quit();
	}
}

