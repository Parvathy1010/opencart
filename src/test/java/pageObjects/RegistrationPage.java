package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage   {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-firstname") WebElement firstName;
	@FindBy(id="input-lastname") WebElement lastName;
	@FindBy(id="input-email") WebElement emailId;
	@FindBy(id="input-telephone") WebElement phone;
	@FindBy(id="input-password") WebElement passwd;
	@FindBy(id="input-confirm") WebElement confirmPasswd;
	@FindBy(xpath="//input[@value='Continue']") WebElement continueButton;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]") WebElement errorMsg;

	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}

	public void enterEmail(String email) {
		emailId.sendKeys(email);
	}

	public void enterPhone(String phonee) {
		phone.sendKeys(phonee);
	}

	public void enterPassword(String passwrd) {
		passwd.sendKeys(passwrd);
	}
	
	public void enterConfirmPassword(String confirmpasswrd) {
		confirmPasswd.sendKeys(confirmpasswrd);
	}

	public void clickContinue() {
		continueButton.click();
	}
	
	public String getErrorMessage() {

		return errorMsg.getText();
	}
	
}
