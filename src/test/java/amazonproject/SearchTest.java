package amazonproject;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
	 @Test
	    public void searchNonExistingProduct() {
	        SearchPage searchPage = new SearchPage(driver);
	        searchPage.selectSearchCategory("Amazon Devices");
	        searchPage.enterSearchTerm("ld345tsxslfer");
	        searchPage.clickSearchButton();
	        String resultText = searchPage.getNoResultsText();
	        Assert.assertEquals(resultText, "No results for ld345tsxslfer.");
	    }

	    @Test
	    public void searchExistingProduct() {
	        SearchPage searchPage = new SearchPage(driver);
	        searchPage.enterSearchTerm("Laptop");
	        searchPage.clickSearchButton();
	        Assert.assertTrue(searchPage.isProductDisplayed());
	    }
	}