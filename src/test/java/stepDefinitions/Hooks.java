package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetUp;

public class Hooks {
	public TestContextSetUp testContextSetUp;
	public WebDriver driver;
	
	public Hooks(TestContextSetUp testContextSetUp) throws IOException {
		this.testContextSetUp= testContextSetUp;
		this.driver= testContextSetUp.test.webDriverManager();
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
//	        System.out.println(">>> Closing browser");
	        driver.quit();
	    }
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent= FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
	
	@After
	public void getTopDeal() {
		if (testContextSetUp.topDealProdDetail != null) {
			System.out.println(testContextSetUp.topDealProdDetail);
		}
	}
}
