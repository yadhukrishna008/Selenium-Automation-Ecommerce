package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= "src/test/resources/FeatureFiles/",
		glue= {"stepDefinitions"},
		tags= "@add2cart or @topDeal",
		dryRun=false,
		monochrome= true,
		plugin= {"pretty", 
				"html:C:\\Users\\yadhu\\eclipse-workspace\\MyTest\\GreenKart\\target\\jsonReports\\search.html",
				"json:target/jsonReports/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_Scenarios.txt"
		}
		)

public class MyRunnerTest extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
