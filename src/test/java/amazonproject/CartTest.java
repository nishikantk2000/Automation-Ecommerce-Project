package amazonproject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
	  @Test
	    public void addProductToCart() throws InterruptedException {
	        SearchPage searchPage = new SearchPage(driver);
	        searchPage.enterSearchTerm("Laptop");
	        searchPage.clickSearchButton();
	        //searchPage.clickOnProduct();
	        
	        CartPage cartPage = new CartPage(driver);
	        cartPage.clickAddToCartButton();
	        String cartText = cartPage.getCartText();
	        Assert.assertTrue(cartText.contains("1 in cart"));
	    }

	    @Test
	    public void updateQuantityInCart() throws InterruptedException {
	        addProductToCart();
	        CartPage cartPage = new CartPage(driver);
	        cartPage.updateQuantity("2");
	        Thread.sleep(2000);
	        String cartText = cartPage.getCartText();
	        Assert.assertTrue(cartText.contains("Subtotal (2 items)"));
	    }

	    @Test
	    public void removeProductFromCart() throws InterruptedException {
	        addProductToCart();
	        CartPage cartPage = new CartPage(driver);
	        cartPage.deleteProductFromCart();
	        Assert.assertTrue(cartPage.getCartText().contains("Your Amazon Cart is empty."));
	    }
	}
