package simplepclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProject {
	
	public static void main(String[] arg) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//To Maximize the windows
		driver.manage().window().maximize();
		//Enter the url
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
		    driver.findElement(By.id("nav-search-submit-button")).click();
		    
		    JavascriptExecutor sw=(JavascriptExecutor)driver;
			//Assign up to Which Path we wan to down 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			WebElement w= driver.findElement(By.xpath("//div[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]"));
			//Scroll down up to particular path
			sw.executeScript("arguments[0].scrollIntoView(true)",w);
			//w.click();
		    //driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]")); // Select 4th result
		    driver.findElement(By.linkText("HP Laptop 15s, 12th Gen Intel Core i5-1235U, 15.6-inch (39.6 cm), FHD, 16GB DDR4, 512GB SSD, Intel Iris Xe Graphics, 720p HD Camera, Backlit KB, Thin & Light (Win 11, Silver, 1.69 kg), fy5009TU"));
		    //Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[@id=\"a-autoid-5-announce\"]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//div[@id='nav-cart-count-container']/span[1]")).click();
	}

}
