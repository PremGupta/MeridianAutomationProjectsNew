/*package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {


	public static WebDriver driver;
	

	public static WebDriver browseropen() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Prem\\AltimetrikProject\\AltimetrikProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(file);
		
		String browserName=prop.getProperty("browser");
		
		try {
			

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prem\\Downloads\\Study\\Selenium Files\\Zip Files\\chromedriver_win32\\chromedriver.exe");
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
	
	
}
*/