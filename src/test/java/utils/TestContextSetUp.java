package utils;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

public class TestContextSetUp {
	public WebDriver driver;
	public TestBase test;
	public PageObjectManager pageObjectManager;
	public Hooks hooks;
	public GenericUtils genericUtils;
	public HashMap<String, Integer> topDealProdDetail= new HashMap<String, Integer>();
	
	
	public TestContextSetUp() throws IOException{
		test= new TestBase();
		pageObjectManager = new PageObjectManager(test.webDriverManager());
		genericUtils= new GenericUtils(test.webDriverManager());
	}
	
	
	

}
