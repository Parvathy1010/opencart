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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {
	
	@Test (groups = {"Regression" , "Master"})
	
	public void Login_test() {
		
		logger.info("Starting TC002 Login_Test");
	

	try {
		
		HomePage hm = new HomePage(driver);
		hm.clickMyAccount();
		logger.info("My Account link Clicked");
		hm.clickLogin();
		logger.info("Login link Clicked");
		
		LoginPage lg = new LoginPage(driver);
		lg.setEmail(prop.getProperty("email"));
		lg.setPassword(prop.getProperty("password"));
		lg.clickLogin();
		logger.info("Login Button Clicked");
		
		MyAccountPage ma = new MyAccountPage(driver);
		boolean pageDisplayed = ma.myAccountPageIsDisplayed();
		
	Assert.assertEquals(pageDisplayed, true, "Login not successful");
	}
	catch(Exception e) {
		Assert.fail();
	}
	
	logger.info("Login Test Completed");
}
	
}
