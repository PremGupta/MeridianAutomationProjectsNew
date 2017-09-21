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
import ObjectRepository.AwardsCentralHomePage;
import ObjectRepository.Blenders;
import ObjectRepository.loginPage;


//import Resources.base;

public class loginPageTestCases  {
 
	public static WebDriver driver;
	
/*@BeforeTest
public static void initializeBrowser() throws IOException
{
	driver=browseropen();
}*/
	
@Test(dataProvider="getData")
public void loginTestCases(String username, String pass) throws IOException, InterruptedException
{

	/*Properties prop=new Properties();
	FileInputStream file=new FileInputStream("C:\\Users\\Prem\\AltimetrikProject\\AltimetrikProject\\src\\main\\java\\Resources\\data.properties");
	prop.load(file);
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prem\\Downloads\\Study\\Selenium Files\\Zip Files\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
   System.out.println("Chrome browser launched");
	prop.getProperty("url");*/
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prem\\Downloads\\Study\\Selenium Files\\Zip Files\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://demosite.meridinet.com/template/login.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	loginPage lp=new loginPage(driver);
	
	lp.Username().sendKeys(username);
	lp.Password().sendKeys(pass);
	lp.LoginButton().click();
/*}

@Test
public void HomePage()
{*/
	HomePage hp=new HomePage(driver);
	WebElement awards=driver.findElement(By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Awards']"));
	Actions act1=new Actions(driver);
	act1.moveToElement(awards).build().perform();
	awards.click();
	hp.AwardsCentral().click();
/*}
	  
	@Test
	public void TestCase1_AccessoriesBlender()
	{*/
	AwardsCentralHomePage achp=new AwardsCentralHomePage(driver);
	WebElement shopbydepartment=driver.findElement(By.xpath("//li[text()='Shop by Department ']"));
	Actions act2=new Actions(driver);
	
	act2.moveToElement(shopbydepartment).moveToElement(driver.findElement(By.xpath("//a[text()='Appliances']"))).build().perform();
	achp.Blenders().click();
	
    Blenders blenders=new Blenders(driver);
    blenders.SpeedHandBlender().click();
    blenders.AddToCart().click();
	
}

/*	@AfterTest
	public void closebrowser()
	{
		driver.close();
		driver=null;
	}*/
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		
		data[0][0]="Meridian";
		data[0][1]="Demo";
		return data;
	}

}
