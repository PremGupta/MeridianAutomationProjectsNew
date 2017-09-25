package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {


	public static WebDriver driver;
	

	public static WebDriver browseropen(WebDriver driver) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("E:\\Meridian\\MeridianAutomation\\MeridianAutomationProjectsNew\\MeridianAutoProjectNew\\src\\main\\java\\Resources\\data.properties");
		prop.load(file);
		
		String browserName=prop.getProperty("browser");
		
		try {
			

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Mee\\chromedriver.exe");
			driver=new ChromeDriver();
	       System.out.println("Chrome browser launched");
			
		}
		
		if (browserName.equals("firefox")) {
            driver=new FirefoxDriver();
			System.out.println("Firefox browser launched");
			
		}
		
		if (browserName.equals("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Prem\\Downloads\\Study\\Selenium Files\\Zip Files\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
	       System.out.println("InternetExplorer browser launched");
			
		}
		} catch (Exception e) {
          e.printStackTrace();
		}
		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	 public static void getscreenshot(WebDriver driver) throws IOException
	    {
	    File snapshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    String screenshotname= "Image";
	    String filetype= ".png";
	    int randomnumber= (int) (100 + Math.random() * ((10000 - 1) + 1));
	    String Randomscreenshotname=screenshotname+randomnumber+filetype;

	    System.out.println("Randome image name"); 
	    System.out.println(Randomscreenshotname);
	    
	    FileUtils.copyFile(snapshot, new File("E:\\Meridian\\MeridianAutomation\\MeridianAutomationProjectsNew\\MeridianAutoProjectNew\\ErrorScreenshots\\"+Randomscreenshotname));
	    System.out.println("screenshot taken");
	    }

	
}
