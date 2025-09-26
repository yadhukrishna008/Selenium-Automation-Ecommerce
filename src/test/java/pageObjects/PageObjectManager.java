package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	WebDriver driver;
	HomePageObject homePO;
	TopDealsPage topPO;
	
	public PageObjectManager(WebDriver driver){
		this.driver= driver;
	}
	
	public HomePageObject homePageObject() {
		homePO= new HomePageObject(driver);
		return homePO;
	}
	
	public TopDealsPage TopDealPageObject() {
		topPO = new TopDealsPage(driver);
		return topPO;
	}
	
}
