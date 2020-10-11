package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		driver.get("http://www.amazon.com");
	}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchInput;
	
	@FindBy(id="nav-search-submit-text")
	private WebElement searchButton;
	
	public ArticlePage buscar(String busqueda) {
		sendKeys(searchInput,busqueda);
		clickElement(searchButton);
		return new ArticlePage(getDriver());
	}
}
