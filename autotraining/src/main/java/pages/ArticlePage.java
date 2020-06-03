package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage {
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div/div[1]/ul/li[2]/ul/li[1]/ul/li/a/h4")
	private List<WebElement> filters;
	
	@FindBy(name="viewAllBrands")
	private WebElement allBrandsLink;
	
	@FindBy(id="filterItemsamsung")
	private WebElement samsung;
	
	@FindBy(id="apply")
	private WebElement apply;
	
	public void getPageTitle() {
		
		Iterator<WebElement> itr = filters.iterator();
		while(itr.hasNext()) {
			if(itr.next().getText()=="Heladeras") {
				itr.next().click();
			}	
		    //System.out.println(itr.next().getText());
		}
	
	}
	
	public void selectAllBrands() {
		allBrandsLink.click();
	}
	
	public void selectBrand() {
		driver.switchTo().frame(0);	
		samsung.click();
		apply.click();
		driver.switchTo().defaultContent();
	}
}
