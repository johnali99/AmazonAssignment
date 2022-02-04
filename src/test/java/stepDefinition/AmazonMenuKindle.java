package stepDefinition;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.KindlePageObject;
import utilities.UtilityClass;

public class AmazonMenuKindle extends Base{
	
	KindlePageObject kindlePageObj = new KindlePageObject();
	
	@Given("user is on Amazon website")
	public void user_is_on_Amazon_website() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		
		Assert.assertEquals(expectedTitle, actualTitle);
		//the logger method is used to provide logs
		logger.info("Actual title is matching with expected title");
		// We take the screen shot using the below utility method and store in screenshots folder and provide the date taken
		UtilityClass.takeScreenShot();
	}
	
	@And("user click on hamburger menu")
	public void user_click_on_hamburger_menu() {
		kindlePageObj.clickOnHumbergerMenuIcon();
		logger.info("User clicked on Humberger menu");
		UtilityClass.takeScreenShot();
	}
	
	@And("user select Kindle under Digital Content and Devices")
	public void user_select_Kindle_under_Digital_Content_and_Devices() {
		kindlePageObj.clickOnKindle();
		logger.info("User clicked on Kindle under Digital Content and Devices in Main menu");
		UtilityClass.takeScreenShot();
	}
	
	@And("user click Kindle under Kindle E-Reader")
	public void user_click_Kindle_under_Kindle_E_Reader(){
		kindlePageObj.clickOnKindleUnderEReader();
		logger.info("User clicked on Kindle under Kindle E-Reader sub-menu");
		UtilityClass.takeScreenShot();
	}
	
	@And("user click Buy Now")
	public void user_click_Buy_Now() {
		kindlePageObj.clickBuyNowButton();
		logger.info("User clicked on Buy Now button");
		UtilityClass.takeScreenShot();
	}
	
	@Then("user should see {string} text")
	public void user_should_see_text(String expectedEmailTextMsg) {
		
		String actualText = kindlePageObj.emailTextPresent();
		String expectedText = expectedEmailTextMsg;
		
		Assert.assertEquals(expectedText, actualText);
		logger.info("The text " +actualText+ " is present. Actual and expected titles are matched");
		UtilityClass.takeScreenShot();
	}
}
