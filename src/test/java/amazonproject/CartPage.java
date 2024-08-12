package amazonproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
	 WebDriver driver;

	    By addToCartButton = By.xpath("//button[@id=\"a-autoid-5-announce\"]");
	    By cartCount = By.id("nav-cart-count-container");
	    By cartText = By.xpath("//span[@id='sc-subtotal-label-buybox']");
	    By deleteButton = By.xpath("//input[@value='Delete']");
	    By quantityDropdown = By.xpath("//select[@class='a-native-dropdown a-declarative sc-update-quantity-select']");

	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickAddToCartButton() throws InterruptedException {
	        driver.findElement(addToCartButton).click();
	        Thread.sleep(2000);
	    }

	    public void updateQuantity(String quantity){
	        WebElement dropdownElement = driver.findElement(quantityDropdown);
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText(quantity);
	        
	    }

	    public String getCartText() {
	        return driver.findElement(cartText).getText();
	    }

	    public void deleteProductFromCart() {
	        driver.findElement(deleteButton).click();
	    }
	}
