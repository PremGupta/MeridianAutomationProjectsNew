package ObjectRepository_Childrens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Apparel{
	
	public static WebDriver driver;

	//By speedhandblender =By.xpath("//a[text()='2-Speed Hand Blender']");
	By addtocart =By.xpath("//button[text()='Add To Cart']");
	
	   
	public Apparel(WebDriver driver)
	{
		this.driver=driver;
	}
	
	 /*  public  WebElement SpeedHandBlender()
	   {
		   return driver.findElement(speedhandblender);
	   }*/
	   
	   public  WebElement AddToCart()
	   {
		   return driver.findElement(addtocart);
	   }
	  
   
}
