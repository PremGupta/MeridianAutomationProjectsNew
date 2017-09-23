package MeridianPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository_Accessories.Shoppingcart;
import ObjectRepository.AwardsCentralHomePage;
import ObjectRepository_Accessories.Blenders;
import ObjectRepository_Accessories.CoffeeBevarages;
import ObjectRepository.loginPage;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;


//import Resources.base;

public class Accessories_CoffeeBevarages_TestCases2 {
 
	public static WebDriver driver;
	
	
@Test(dataProvider="getData2")
public void SecondTestCase(String ParentLink, String ChildLink) throws IOException, InterruptedException
{

	AwardsCentralHomePage achp=new AwardsCentralHomePage(driver);
	WebElement shopbydepartment=driver.findElement(By.xpath("//li[text()='Shop by Department ']"));
	Actions act2=new Actions(driver);
	
	act2.moveToElement(shopbydepartment).moveToElement(driver.findElement(By.xpath(ParentLink))).build().perform();
	achp.CoffeeBeverages().click();
	
	
	CoffeeBevarages cb=new CoffeeBevarages(driver);
	driver.findElement(By.xpath(ChildLink)).click();
    cb.AddToCart().click();
    
    Shoppingcart sc=new Shoppingcart(driver);
    sc.ShoppingCart().click();
    
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	
}
	

	@DataProvider
	public Object[][] getData2()
	{
		Object[][] data=new Object[1][2];
		
		data[0][0]="//a[text()='Appliances']";
		data[0][1]="//a[text()='Coffee & Beverages']";
		/*data[1][0]="//a[text()='Children's']";
		data[1][1]="//a[text()='Baby Care']";*/
		return data;
	}
}
