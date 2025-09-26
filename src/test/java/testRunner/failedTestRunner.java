package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= "@target/failed_Scenarios.txt",
		glue= "stepDefinitions",
		dryRun=false,
		monochrome= true,
		plugin= {"pretty", 
				"html:C:\\Users\\yadhu\\eclipse-workspace\\MyTest\\GreenKart\\target\\jsonReports\\search.html",
				"json:target/jsonReports/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)

public class failedTestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
