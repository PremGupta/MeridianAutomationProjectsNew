package ObjectRepository_Childrens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BabyCare{
	
	public static WebDriver driver;

	//By cupthermalcoffeemaker =By.xpath("//a[text()='10-Cup Thermal Coffeemaker']");
	By addtocart =By.xpath("//button[text()='Add To Cart']");
	By color =By.xpath("//select[text()='Color']");
	By size =By.xpath("//select[text()='Size']");
	
	   
	public BabyCare(WebDriver driver)
	{
		this.driver=driver;
	}
	
	  /* public  WebElement CupThermalCoffeemaker()
	   {
		   return driver.findElement(cupthermalcoffeemaker);
	   }*/
	   
	   public  WebElement AddToCart()
	   {
		   return driver.findElement(addtocart);
	   }
	   
	   
	   public void Color()
	   {
		   Select sel=new Select((WebElement) color);
		   sel.selectByIndex(0);
	   }
	   public void Size()
	   {
		   Select sel=new Select((WebElement) size);
		   sel.selectByIndex(0);
	   }
	  
	  
   
}
