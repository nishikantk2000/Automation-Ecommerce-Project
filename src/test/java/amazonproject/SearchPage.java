package amazonproject;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;


public class SearchPage {
	  WebDriver driver;

	    By searchDropdown = By.cssSelector("select[aria-describedby='searchDropdownDescription']");
	    By searchBox = By.id("twotabsearchtextbox");
	    By searchButton = By.id("nav-search-submit-button");
	    By noResultsText = By.xpath("//div[@tabindex='0']/div[1]");
	    By productLink = By.linkText("HP Laptop 15s, 12th Gen Intel Core i5-1235U, 15.6-inch (39.6 cm), FHD, 16GB DDR4, 512GB SSD, Intel Iris Xe Graphics, 720p HD Camera, Backlit KB, Thin & Light (Win 11, Silver, 1.69 kg), fy5009TU");

	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectSearchCategory(String category) {
	        Select dropdown = new Select(driver.findElement(searchDropdown));
	        dropdown.selectByVisibleText(category);
	    }

	    public void enterSearchTerm(String searchTerm) {
	        driver.findElement(searchBox).sendKeys(searchTerm);
	    }

	    public void clickSearchButton() {
	        driver.findElement(searchButton).click();
	        JavascriptExecutor sw=(JavascriptExecutor)driver;
	        sw.executeScript("arguments[0].scrollIntoView(true)",productLink);
	    }

	    public String getNoResultsText() {
	        return driver.findElement(noResultsText).getText();
	    }

	    public boolean isProductDisplayed() {
	        return driver.findElements(productLink).size() > 0;
	    }

	    public void clickOnProduct() {
	        driver.findElement(productLink);
	    }
	}
