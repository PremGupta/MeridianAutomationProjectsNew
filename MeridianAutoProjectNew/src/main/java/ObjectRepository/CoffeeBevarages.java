package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CoffeeBevarages{
	
	public static WebDriver driver;

	By cupthermalcoffeemaker =By.xpath("//a[text()='10-Cup Thermal Coffeemaker']");
	By addtocart =By.xpath("//button[text()='Add To Cart']");
	
	   
	public CoffeeBevarages(WebDriver driver)
	{
		this.driver=driver;
	}
	
	   public  WebElement CupThermalCoffeemaker()
	   {
		   return driver.findElement(cupthermalcoffeemaker);
	   }
	   
	   public  WebElement AddToCart()
	   {
		   return driver.findElement(addtocart);
	   }
	  
   
}
