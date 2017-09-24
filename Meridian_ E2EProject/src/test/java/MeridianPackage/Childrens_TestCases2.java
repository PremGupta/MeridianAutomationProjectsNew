package MeridianPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Screen;

import ObjectRepository.HomePage;
import ObjectRepository_Accessories.Shoppingcart;
import ObjectRepository.AwardsCentralHomePage;
import ObjectRepository_Accessories.Blenders;
import ObjectRepository_Accessories.CoffeeBevarages;
import ObjectRepository.loginPage;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;


//import Resources.base;

public class Childrens_TestCases2 {
 
	public static WebDriver driver;
	

	@Test(dataProvider="getData2")

	public void FirstTestCase(String Childrens) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prem\\Downloads\\Study\\Selenium Files\\Zip Files\\chromedriver_win32\\chromedriver.exe");
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
	
		Childrens_TestCases2.ShopbyDepartment_Appliances();
	
	
	List<WebElement> MainCat1=driver.findElements(By.xpath("//ul[@id='categories'] /li[contains(@id, 'li_')]"));
	int MainCatSize1=MainCat1.size();
	//System.out.println(MainCatSize1);
	
	for (int i1 = 2; i1 < MainCatSize1; i1++) {
		//System.out.println(driver.findElements(By.xpath("//ul[@id='categories'] /li[contains(@id, 'li_')]")).get(i1).getText());
		
		List<WebElement> SubCat1=driver.findElements(By.xpath("//li[starts-with(@id, 'li_')]/div/ul/li/a"));
		int SubCatSize1=SubCat1.size();
		//System.out.println(SubCatSize1);
		

		for (int j1 = 15; j1 < SubCatSize1; j1++) {
			System.out.println(j1+"> "+driver.findElements(By.xpath("//li[starts-with(@id, 'li_')]/div/ul/li/a")).get(j1).getText());
			System.out.println("------------------------------------------");
			driver.findElements(By.xpath("//li[starts-with(@id, 'li_')]/div/ul/li/a")).get(j1).click();
			
			List<WebElement> prods1=driver.findElements(By.xpath(".//*[@id='content']/div[2]//a/img"));
			int ProdsCounts1=prods1.size();
			//System.out.println(ProdsCounts1);
			
			for (int j11 = 0; j11 < ProdsCounts1-1; j11++) {
				System.out.println("==========================================");
				System.out.println(driver.findElements(By.xpath(".//a[@class='productName']")).get(j11).getText());
				driver.findElements(By.xpath(".//*[@id='content']/div[2]//a/img")).get(j11).click();
				
				Childrens_TestCases2.colorsize();
				System.out.println("                                          ");
				
				//For all products
			    //driver.navigate().to("https://demosite.meridinet.com/merlin/awardscentral?mgr=Item&command=getSubCategoryItems&style=sub_category&category_cd=CHL&sub_category_cd=APL");

			
				
				try{
					
					Childrens_TestCases2.ShopbyDepartment_Appliances();
					
				List<WebElement> MainCat2=driver.findElements(By.xpath("//ul[@id='categories'] /li[contains(@id, 'li_')]"));
				int MainCatSize2=MainCat2.size();
				//System.out.println(MainCatSize1);
				
				for (int i2 = 2; i2 < MainCatSize2; i2++) {
					//System.out.println(driver.findElements(By.xpath("//ul[@id='categories'] /li[contains(@id, 'li_')]")).get(i2).getText());
					
					List<WebElement> SubCat2=driver.findElements(By.xpath("//li[starts-with(@id, 'li_')]/div/ul/li/a"));
					int SubCatSize2=SubCat2.size();
					//System.out.println(SubCatSize2);

					for (int j2 = 16; j2 < SubCatSize2; j2++) {
						System.out.println(j2+"> "+driver.findElements(By.xpath("//li[starts-with(@id, 'li_')]/div/ul/li/a")).get(j2).getText());
						driver.findElements(By.xpath("//li[starts-with(@id, 'li_')]/div/ul/li/a")).get(j2).click();
						
						List<WebElement> prods2=driver.findElements(By.xpath(".//*[@id='content']/div[2]//a/img"));
						int ProdsCounts2=prods2.size();
						//System.out.println(ProdsCounts2);
						
						for (int j22 = 0; j22 <= ProdsCounts2-1; j22++) {
							System.out.println("==========================================");
							System.out.println(driver.findElements(By.xpath(".//a[@class='productName']")).get(j22).getText());
							driver.findElements(By.xpath(".//*[@id='content']/div[2]//a/img")).get(j22).click();
                            addToCart();
                            System.out.println("                                          ");
                            
						    //driver.navigate().to("https://demosite.meridinet.com/merlin/awardscentral?mgr=Item&command=getSubCategoryItems&style=sub_category&category_cd=CHL&sub_category_cd=BBY");

						}
		         }
	       }
				}
				catch (StaleElementReferenceException e) {
//e.printStackTrace();				

				}
				
	}
}	

   }
}

public static void ShopbyDepartment_Appliances()
{
	AwardsCentralHomePage achp=new AwardsCentralHomePage(driver);
	Actions act2=new Actions(driver);
	WebElement shopbydepartment1=driver.findElement(By.xpath("//li[text()='Shop by Department ']"));
	act2.moveToElement(shopbydepartment1).moveToElement(driver.findElement(By.xpath("//a[starts-with(text(), 'Children')]"))).build().perform();
}

public static void colorsize()
{
	try {
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	} 
	
	catch (Exception e) {	
}
	
	driver.findElement(By.xpath(".//*[@id='product']//li[1]/select")).click();
	Select sel1=new Select(driver.findElement(By.xpath(".//*[@id='product']//li[1]/select")));
	sel1.selectByIndex(1);
	Select sel2=new Select(driver.findElement(By.xpath(".//*[@id='product']//li[2]/select")));
	sel2.selectByIndex(1);
	addToCart();
}

public static void addToCart()
{
	driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
	Shoppingcart sc1=new Shoppingcart(driver);
    sc1.ShoppingCart().click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

@AfterTest

public void BrowserClose()
{
	driver.close();
}

	@DataProvider
	public Object[][] getData2()
	{
		Object[][] data=new Object[1][1];
		
		data[0][0]="//a[text()='Children's']";
	
		return data;
	}
	
}