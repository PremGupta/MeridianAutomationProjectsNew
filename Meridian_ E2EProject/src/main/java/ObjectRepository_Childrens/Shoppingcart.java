package ObjectRepository_Childrens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Shoppingcart{
	
	public static WebDriver driver;

	By shoppingcart =By.xpath("//*[@id='shopCart']/table/tbody/tr/td[6]/a/span");
	
	   
	public Shoppingcart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	   public  WebElement ShoppingCart()
	   {
		   return driver.findElement(shoppingcart);
	   }
	  
   
}
