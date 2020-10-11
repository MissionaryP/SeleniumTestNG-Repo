package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class MyDriver{

	private WebDriver driver;
	
	public MyDriver(String browser) {
		switch(browser) {
		case "remoteFirefox":
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			String cwd = System.getProperty("user.dir")+"/src/test/Resources/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",cwd );
			driver = new ChromeDriver();
			break;
		default:
			break;
			
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

}
