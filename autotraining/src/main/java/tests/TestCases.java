package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ArticlePage;
import pages.HomePage;

public class TestCases extends BaseTest {
	
	@Test
	public void searchAction() {
		HomePage homeP = getHomePage();
		ArticlePage articlePage = homeP.buscar("Alexia");
		articlePage.validateAddToKart();
		
	}
}
