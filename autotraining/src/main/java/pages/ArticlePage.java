package pages;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ArticlePage extends BasePage {
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")
	private WebElement cant;
	
	//Selecciono el 3 elemento de la lista de resultados, index = 2
	@FindBy(xpath = "//div[@data-index='2']")
	private WebElement select3rdElement;
	
	@FindBy(xpath = "//*[@id=\"add-to-cart-button-ubb\"]")
	private WebElement addToCart;
	
	public void validateAddToKart() {
		
		try {
			WebDriverWait browser = getWait();
			browser.until(ExpectedConditions.visibilityOf(cant));
		}catch(Exception TimeoutException) {
			System.out.println("Loading took too much time!"); 
		}
		
		clickElement(select3rdElement);
		verifyNull(addToCart);
		
	}
	
	

}
