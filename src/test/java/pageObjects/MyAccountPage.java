package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//h2[text()='MyAccount']")
	WebElement pgTitle;	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement logoutbtn;
	
	public boolean myAccountPageIsDisplayed() {
		try {
			return (pgTitle.isDisplayed());
		}
		catch (Exception e) {
			return (false);
		}
	}
		
	public void clickLogout() {
		logoutbtn.click();
		
		}
	
}
