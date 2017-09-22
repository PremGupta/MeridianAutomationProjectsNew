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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.Shoppingcart;
import ObjectRepository.AwardsCentralHomePage;
import ObjectRepository.Blenders;
import ObjectRepository.loginPage;


//import Resources.base;

public class FirstLinkTestCases  {
 
	public static WebDriver driver;
	
/*@BeforeTest
public static void initializeBrowser() throws IOException
{
	driver=browseropen();
}*/
	
@Test
public void firstTestCases() throws IOException, InterruptedException
{

    loginPageTestCases lcs=new loginPageTestCases();
    lcs.loginTestCases("Meridian", "Demo");
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	HomePage hp=new HomePage(driver);
	WebElement awards=driver.findElement(By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Awards']"));
	Actions act1=new Actions(driver);
	act1.moveToElement(awards).build().perform();
	awards.click();
	hp.AwardsCentral().click();

	AwardsCentralHomePage achp=new AwardsCentralHomePage(driver);
	WebElement shopbydepartment=driver.findElement(By.xpath("//li[text()='Shop by Department ']"));
	Actions act2=new Actions(driver);
	
	act2.moveToElement(shopbydepartment).moveToElement(driver.findElement(By.xpath("//a[text()='Appliances']"))).build().perform();
	achp.Blenders().click();
	
    Blenders blenders=new Blenders(driver);
    blenders.SpeedHandBlender().click();
    blenders.AddToCart().click();
    
    Shoppingcart sc=new Shoppingcart(driver);
    sc.ShoppingCart().click();
	
}


}
