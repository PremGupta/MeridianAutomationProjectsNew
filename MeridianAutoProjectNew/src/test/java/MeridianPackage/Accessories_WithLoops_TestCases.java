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
import ObjectRepository.Shoppingcart;
import ObjectRepository.AwardsCentralHomePage;
import ObjectRepository.Blenders;
import ObjectRepository.CoffeeBevarages;
import ObjectRepository.loginPage;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;


//import Resources.base;

public class Accessories_WithLoops_TestCases {
 
	public static WebDriver driver;
	
/*@BeforeTest
public static void initializeBrowser() throws IOException
{
	driver=browseropen();
}*/

	@BeforeSuite

	public void LoginMethod()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Mee\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demosite.meridinet.com/template/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		loginPage lp=new loginPage(driver);
		
		lp.Username().sendKeys("Meridian");
		lp.Password().sendKeys("Demo");
		lp.LoginButton().click();
		HomePage hp=new HomePage(driver);
		WebElement awards=driver.findElement(By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Awards']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(awards).build().perform();
		awards.click();
		hp.AwardsCentral().click();
	}
	
@Test(dataProvider="getData2")
public void FirstTestCase(String ParentLink, String ChildLink1 ,String ChildLink2) throws IOException, InterruptedException
{

	AwardsCentralHomePage achp=new AwardsCentralHomePage(driver);
	WebElement shopbydepartment=driver.findElement(By.xpath("//li[text()='Shop by Department ']"));
	Actions act2=new Actions(driver);
	
	act2.moveToElement(shopbydepartment).moveToElement(driver.findElement(By.xpath(ParentLink))).build().perform();
	achp.Blenders().click();
	
	Blenders blenders=new Blenders(driver);
	driver.findElement(By.xpath(ChildLink1)).click();
    blenders.AddToCart().click();
    
    Shoppingcart sc1=new Shoppingcart(driver);
    sc1.ShoppingCart().click();
    
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
	WebElement shopbydepartment1=driver.findElement(By.xpath("//li[text()='Shop by Department ']"));
	act2.moveToElement(shopbydepartment1).moveToElement(driver.findElement(By.xpath(ParentLink))).build().perform();
	achp.CoffeeBeverages().click();
	
	
	CoffeeBevarages cb=new CoffeeBevarages(driver);
	driver.findElement(By.xpath(ChildLink2)).click();
    cb.AddToCart().click();
    
    Shoppingcart sc2=new Shoppingcart(driver);
    sc2.ShoppingCart().click();
    
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	
}
	

	@DataProvider
	public Object[][] getData2()
	{
		Object[][] data=new Object[1][3];
		
		data[0][0]="//a[text()='Appliances']";
		data[0][1]="//a[text()='2-Speed Hand Blender']";
		data[0][2]="//a[text()='10-Cup Thermal Coffeemaker']";
	
		/*data[1][0]="//a[text()='Appliances']";
		data[1][1]="//a[text()='Coffee & Beverages']";*/
		/*data[1][0]="//a[text()='Children's']";
		data[1][1]="//a[text()='Baby Care']";*/
		return data;
	}
}