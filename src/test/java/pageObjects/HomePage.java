package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[text()='My Account']") WebElement myAccount;
	@FindBy(linkText="Register") WebElement register;
	@FindBy(linkText="Login") WebElement login;

	public void clickMyAccount() {
		myAccount.click();	
	}

	public void clickRegister() {
		register.click();	
	}

	public void clickLogin() {
		login.click();	
	}
}
