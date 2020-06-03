package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		driver.get("http://www.fravega.com");
	}
	
	@FindBy(css="input.InputBar__SearchInput-t6v2m1-1.iJaFAt")
	private WebElement searchInput;
	
	@FindBy(css="input.InputBar__SearchButton-t6v2m1-2.jRChuZ")
	private WebElement searchButton;
	
	public ArticlePage buscar(String busqueda) {
		searchInput.sendKeys(busqueda);
		getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		return new ArticlePage(getDriver());
	}
}
