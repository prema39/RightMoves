package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilities.Configuration;

public class BaseTest {
	public static WebDriver driver;
	
	public static void launchBrowser(){
		Configuration.loadConfiguration();
		
		String browserName = Configuration.getBrowserName().trim().toLowerCase();
		switch(browserName){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/premalathaeddyam/eclipse-workspace/chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "binaries\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		//case "ie":
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", "binaries\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
			default:
			System.out.println("Please enter a valid browser name. entered name is - "+browserName);
		}
		//driver.manage().window().maximize();
		driver.get(Configuration.getURL());
	}
	
	public static void closeBrowser(){
		//driver.quit();
	}
	
	
	
}
