package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class KindlePageObject extends Base {

	public KindlePageObject() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
	private WebElement clickHumberbergerMenu;
	
	@FindBy(xpath = "//div[text()='Kindle']")
	private WebElement clickOnKindleInDigitalContent;
	
	@FindBy(xpath = "//a[@class='hmenu-item' and text()='Kindle']")
	private WebElement clickOnEReaderKindle;
	
	@FindBy(xpath = "//input[@id='buy-now-button']")
	private WebElement clickBuyNow;
	
	@FindBy(xpath = "//label[@for='ap_email']")
	private WebElement verifyEmailText;
	
	
	public void clickOnHumbergerMenuIcon() {
		clickHumberbergerMenu.click();
	}
	
	public void clickOnKindle() {
		clickOnKindleInDigitalContent.click();
	}
	
	public void clickOnKindleUnderEReader() {
		clickOnEReaderKindle.click();
	}
	
	public void clickBuyNowButton() {
		clickBuyNow.click();
	}
	
	public String emailTextPresent() {
		return verifyEmailText.getText();
	}
		
}
