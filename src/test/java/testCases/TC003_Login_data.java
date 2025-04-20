package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
public class TC003_Login_data extends BaseClass {
	
	

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)


	public void Login_test(String email,String password,String exp) {


		logger.info("Starting TC003 Login_Test");
		try {


			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lg = new LoginPage(driver);
			lg.setEmail(email);
			lg.setPassword(password);
			lg.clickLogin();

			MyAccountPage ma = new MyAccountPage(driver);
			boolean pageDisplayed = ma.myAccountPageIsDisplayed();

			if(exp.equalsIgnoreCase("Valid"))
			{
				if(pageDisplayed==true) {
					ma.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(pageDisplayed==true) {
					ma.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}

			}
		} catch (Exception e) {
			Assert.fail("An Exception is seen: "+e.getMessage());
		}
		logger.info("TC003 Completed");
	}
}