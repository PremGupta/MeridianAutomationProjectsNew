package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AwardsCentralHomePage{
	
	public static WebDriver driver;

	By shopbydepartment =By.xpath("//a[text()='Shop by Department ']");
	By accessories =By.xpath("//a[text()='Accessories']");
	By blenders =By.xpath("//a[text()='Blenders']");
	
	By coffeebeverages =By.xpath("//a[text()='Coffee & Beverages']");
	
	
	   
	public AwardsCentralHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	   public  WebElement ShopByDepartment()
	   {
		   return driver.findElement(shopbydepartment);
	   }
	   
	   public  WebElement Accessories()
	   {
		   return driver.findElement(accessories);
	   }
	   
	   public  WebElement Blenders()
	   {
		   return driver.findElement(blenders);
	   }
	   
	   public  WebElement CoffeeBeverages()
	   {
		   return driver.findElement(coffeebeverages);
	   }
   
}
