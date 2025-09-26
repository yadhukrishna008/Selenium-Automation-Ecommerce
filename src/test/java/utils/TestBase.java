package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
//	private String browser;
	
	public WebDriver webDriverManager() throws IOException{
		String myBrowser, myApp, browser_properties, browser_maven;
		
		FileInputStream FIS= new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
		Properties prop= new Properties();
		prop.load(FIS);
		
		browser_properties= prop.getProperty("browser");
		browser_maven= System.getProperty("browser");
		
		myApp= prop.getProperty("QAUrl");
		
		if(driver == null) {
			myBrowser= browser_maven==null?browser_properties:browser_maven;
			switch (myBrowser.toLowerCase()){
				case "chrome":
//					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
					WebDriverManager.chromedriver().setup();
					driver= new ChromeDriver();
					break;
				case "edge":
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\edgedriver-win64\\msedgedriver.exe");
					driver= new EdgeDriver();
					break;
				default:
					System.out.println("Browser is not valid");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get(myApp);
		}
 
		return driver;
	}
}
