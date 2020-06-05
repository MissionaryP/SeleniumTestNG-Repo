package pages;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ArticlePage extends BasePage {
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[3]/div/div/div[1]/ul/li[2]/ul/li[1]/ul/li/a/h4")
	private List<WebElement> filters;
	
	//no use un list de webelements, directamente usé el xpath relativo de la marcad "Vondom"
	@FindBy(xpath = "//*[@id=\"__next\"]/div[3]/div[2]/div/div[1]/ul/li[2]/ul/li[2]/ul/li[2]/a/label")
	private WebElement selectVondom;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div[3]/div[2]/div/div[2]/section/ul[1]/li[1]/div/a/article/div/h4")
	private List<WebElement> resultsList;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div[3]/div[2]/div/div[1]/ul/li[1]/span")
	private WebElement resultsNumber;
	
	public void getPageTitle() {
		
		Iterator<WebElement> itr = filters.iterator();
		
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfAllElements(filters));
		
		String text;
		
		for (int i=0; i<filters.size();i++){
			text = filters.get(i).getText();
			if(text.contains("Heladeras")) {
				filters.get(i).click();
			}
		}
		/*	
		}
		while(itr.hasNext()) {
			text = itr.next().getText();
			if(text.contains("Heladeras")) {
				itr.next().click();
			}	
		}*/
		
		selectBrand();
	}
	
	public void selectBrand() {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(selectVondom));
		selectVondom.click();
	}
	
	public void verifyResultsList() {
		
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfAllElements(resultsList));
		
		//Iterator<WebElement> itr = resultsList.iterator();
		String text;
		int var = 0;
		for (int i=0; i<resultsList.size();i++){
			text = resultsList.get(i).getText();
			if(text.contains("Vondom")) {
				var = 1;
				Assert.assertEquals(var,1);
			}else {
				Assert.assertEquals(var, 1);
			}
			
		}
		/*
		while(itr.hasNext()) {
			text = itr.next().getText();
			int var = 0;
			if(text.contains("Vondom")) {
				var = 1;
				Assert.assertEquals(var,1);
			}else {
				Assert.assertEquals(var, 1);
			}
		}*/
	
	}
	
	public void verifyQuantity() {
		int cantElementosLista = resultsList.size();
		int resultadosBusqueda = Integer.parseInt(resultsNumber.getText());
		Assert.assertEquals(cantElementosLista, resultadosBusqueda);
		
	}
	

}
