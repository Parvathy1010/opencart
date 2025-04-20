package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
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
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import testBase.BaseClass_OLD;



public class TC001_AccountRegistration extends BaseClass {

	
	@Test(groups = {"Sanity" , "Regression"})
	void verify_Registration() {
		logger.info("TC001_AccountRegistration Test Execution Started");
try {
		HomePage hm = new HomePage(driver);
		hm.clickMyAccount();
		logger.info("Clicked on My Account ");
		hm.clickRegister();
		logger.info("Clicked on Register ");

		RegistrationPage rp = new RegistrationPage(driver);


	
	rp.enterFirstName(prop.getProperty("firstName"));
	logger.info("FirstName Entered");

	rp.enterLastName("Nat");
	logger.info("LastName Entered");

	rp.enterEmail("Parvathynat@gmail.com");
	logger.info("Email Entered");

	rp.enterPhone("8902578963");
	logger.info("Phone Entered");

	rp.enterPassword("anvkdl");
	rp.enterConfirmPassword("anvkdl");

	rp.clickContinue();
	logger.info("Registration Successful");
	
} catch (Exception e) {
	logger.error("Test Failed" + e.getMessage());
	Assert.fail();
}
		
finally {
	logger.info("TC001_AccountRegistration Test execution completed");
}

	}

	@AfterClass(groups = {"Sanity" , "Master", "Regression"})

	void close() {
		driver.quit();
	}



	/*
	 * String randomAlphabets() {
	 * System.out.println(RandomStringUtils.randomAlphabetic(5)); return
	 * RandomStringUtils.randomAlphabetic(5); }
	 * 
	 * String randomNumbers() {
	 * System.out.println(RandomStringUtils.randomNumeric(10)); return
	 * RandomStringUtils.randomNumeric(10); }
	 */
}
