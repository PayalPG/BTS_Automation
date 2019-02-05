/**
 * 
 */
package tests;

import org.testng.annotations.Test;
 
/**
 * @author SG0304279
 * @date 31 Jan 2019
 */
public class TestPropertyProfile extends BaseClass{

	
	/*@Test
	public void testActiveProperties() throws InterruptedException {
		propertyProfilePage.doLogin();
		propertyProfilePage.goTOPropertyProfileTab();
		propertyProfilePage.verifyActiveProperties();
	}
	
	@Test
	public void testInActiveProperties() throws InterruptedException {
		propertyProfilePage.doLogin();
		propertyProfilePage.goTOPropertyProfileTab();
		propertyProfilePage.verifyInActiveProperties();
	}*/
	
	
	@Test
	public void testSetRestrctions() throws InterruptedException {
		propertyProfilePage.doLogin();
		propertyProfilePage.goTOPropertyProfileTab();
		propertyProfilePage.applyFilter();
		String actualPropertyName=propertyProfilePage.selectProperty();
		propertyProfilePage.navigateToSetRestrictionsPage();
		setRestrictionsPage.verifyPropertyName(actualPropertyName);
	}
	
	@Test
	public void testReviewAndEdit() throws InterruptedException {
		propertyProfilePage.doLogin();
		propertyProfilePage.goTOPropertyProfileTab();
		propertyProfilePage.applyFilter();
		String actualPropertyName=propertyProfilePage.selectProperty();
		propertyProfilePage.navigateToReviewAndEditPage();
		
		
		
	}
	
}
