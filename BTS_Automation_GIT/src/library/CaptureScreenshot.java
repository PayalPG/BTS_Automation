/**
 * 
 */
package library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author SG0304279
 *
 */
public class CaptureScreenshot {
	
	
	public static void captureScreenshot(WebDriver driver,String fileName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("C:\\SabreBTS\\Selenium_Automation\\BTS_Automation\\Screenshots\\"+fileName+".png"));
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			e.getMessage();
		}

	}

}
