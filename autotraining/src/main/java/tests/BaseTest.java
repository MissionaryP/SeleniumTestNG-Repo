package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;

public class BaseTest {
	MyDriver myDriver;
	
	private HomePage homeP;
	
	@BeforeSuite(alwaysRun =true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		homeP = new HomePage(myDriver.getDriver());
	}
	
	@AfterSuite(alwaysRun =true)
	public void afterSuite() {
		homeP.dispose();
	}
	
	public HomePage getHomePage() {
		return homeP;
	}
	
	public WebDriver returnDriver() {
		return myDriver.getDriver();
	}
	
	
}
