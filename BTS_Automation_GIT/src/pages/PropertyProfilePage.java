package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tests.BaseClass;

public class PropertyProfilePage{
	
	WebDriver driver;
	protected Actions actions ;
	protected WebDriverWait wait;
	protected Select select;
	JavascriptExecutor js;
	String userNameString="hgc_payal";
	String passwordString="Success@2019";
	String viewPropertyDetailsExpectedText="View Property Details";
	String viewPropertyExpectedText="View Property";
	public String actualPropertyName;
	
	By userName=By.xpath("//*[contains(text(),'Username')]");
	By passWord=By.xpath("//*[contains(text(),'Password')]");
	By submitButton=By.xpath("//button[@type='submit']");
	By propertyProfileTab=By.xpath("//*[contains(text(),'property profile')]");
	By showFilterText=By.xpath("//*[contains(text(),'Show filters')]");
	By seasonYear=By.xpath("//*[@class='title-attribute']//following::select[2]");
	By activeButton=By.xpath("//*[contains(text(),'Active')]");
	By applyButton=By.xpath("//*[contains(text(),'APPLY')]");
	By hideFilterText=By.xpath("//*[contains(text(),'Hide filters')]");
	By propertiesCheckBox=By.xpath("//input[@class='spark-checkbox__input']"); 
	By setRestrictionsText=By.xpath("//*[contains(text(),'Set Restricted Questions')]");
	By viewPropertyDetailsText=By.xpath("//*[contains(text(),'View Property Details')]");
	By viewPropertyText=By.xpath("//*[contains(text(),'View Property')]");
	By propertyNameOnListPage=By.xpath("//tbody//a");
	By reviewAndEditPageText=By.xpath("//*[contains(text(),'Edit Property Profile on Behalf of Hotel')]");
	
	
	public PropertyProfilePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void doLogin() {		
		actions = new Actions(driver);
		wait=new WebDriverWait(driver, 50);
		js=(JavascriptExecutor) driver;
		actions.moveToElement(driver.findElement(userName));
		actions.click();
		actions.sendKeys(userNameString);
		actions.build().perform();
			
		actions.moveToElement(driver.findElement(passWord));
		actions.click();
		actions.sendKeys(passwordString);
		actions.build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		driver.findElement(submitButton).click();
	}
	
	public void goTOPropertyProfileTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(propertyProfileTab));
		driver.findElement(propertyProfileTab).click();
	}
	
	public void verifyActiveProperties() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(showFilterText));
		driver.findElement(showFilterText).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(seasonYear));
		driver.findElement(seasonYear).click();
		select=new Select(driver.findElement(seasonYear));
		Thread.sleep(3000);
		List <WebElement> seasonYearCount = select.getOptions();
		select.selectByVisibleText("2019");
		//Click on Inactive property
		driver.findElement(activeButton).click();
		driver.findElement(applyButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hideFilterText));
		driver.findElement(hideFilterText).click();
		Thread.sleep(3000);		
		//Checking size of Active Properties check box
		List<WebElement> checkboxlist=driver.findElements(propertiesCheckBox);
		System.out.println("Checkbox list= "+checkboxlist.size());		
		actions.moveToElement(checkboxlist.get(1)).click().build().perform();
		String viewPropertyDetailsActualText=driver.findElement(viewPropertyDetailsText).getText();
		Assert.assertEquals(viewPropertyDetailsActualText, viewPropertyDetailsExpectedText);	
		
	}
	
	public void verifyInActiveProperties() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(showFilterText));
		driver.findElement(showFilterText).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(seasonYear));
		driver.findElement(seasonYear).click();
		select = new Select(driver.findElement(seasonYear));
		Thread.sleep(3000);
		List<WebElement> seasonYearCount = select.getOptions();
		select.selectByVisibleText("2019");
		// Click on Inactive property
		driver.findElement(activeButton).click();
		driver.findElement(applyButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hideFilterText));
		driver.findElement(hideFilterText).click();
		Thread.sleep(3000);
		// Checking size of Active Properties check box
		List<WebElement> checkboxlist = driver.findElements(propertiesCheckBox);
		System.out.println("Checkbox list= " + checkboxlist.size());
		actions.moveToElement(checkboxlist.get(1)).click().build().perform();
		String viewPropertyActualText = driver.findElement(viewPropertyText).getText();
		Assert.assertEquals(viewPropertyActualText, viewPropertyExpectedText);
	}
	
	
	public void navigateToSetRestrictionsPage() {
		driver.findElement(setRestrictionsText).click();
	}
	
	public void navigateToReviewAndEditPage() {
		driver.findElement(reviewAndEditPageText).click();
	}
	
	public void applyFilter() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(showFilterText));
		driver.findElement(showFilterText).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(seasonYear));
		driver.findElement(seasonYear).click();
		select=new Select(driver.findElement(seasonYear));
		Thread.sleep(3000);
		List <WebElement> seasonYearCount = select.getOptions();
		System.out.println("Season Year Count=="+seasonYearCount.size());
		select.selectByVisibleText("2019");
		//Click on Inactive property
		driver.findElement(activeButton).click();
		driver.findElement(applyButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hideFilterText));
		driver.findElement(hideFilterText).click();
	}
	
	public String selectProperty() throws InterruptedException {
		Thread.sleep(3000);		
		//Checking size of Active Properties check box
		List<WebElement> checkboxlist=driver.findElements(propertiesCheckBox);
		System.out.println("Checkbox list= "+checkboxlist.size());		
		Thread.sleep(3000);
		List<WebElement> propertyNameList=driver.findElements(propertyNameOnListPage);
		System.out.println("Property Name list size= "+propertyNameList.size());		
		//for(int i=0;i<=propertyNameList.size();i++) {
		actualPropertyName=propertyNameList.get(0).getText();
		System.out.println("Actual Property Name is==="+actualPropertyName);
		//}
		actions.moveToElement(checkboxlist.get(1)).click().build().perform();
		return actualPropertyName;
	}
	
	
	public String selectPropertyForReviewAndEdit() throws InterruptedException {
		Thread.sleep(3000);		
		//Checking size of Active Properties check box
		List<WebElement> checkboxlist=driver.findElements(propertiesCheckBox);
		System.out.println("Checkbox list= "+checkboxlist.size());		
		Thread.sleep(3000);
		List<WebElement> propertyNameList=driver.findElements(propertyNameOnListPage);
		System.out.println("Property Name list size= "+propertyNameList.size());		
		//for(int i=0;i<=propertyNameList.size();i++) {
		actualPropertyName=propertyNameList.get(0).getText();
		System.out.println("Actual Property Name is==="+actualPropertyName);
		//}
		actions.moveToElement(checkboxlist.get(1)).click().build().perform();
		return actualPropertyName;
	}
	

}
