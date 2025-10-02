package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {
	WebDriver driver;
	public WebDriverWait myWait;
	HomeAndCartPageObject homePO;
	TopDealsPage topPO;
	CheckOutPage CheckoutPO;
	CustomerDetailsPage CustomerDetailsPO;
	
	public PageObjectManager(WebDriver driver){
		this.driver= driver;
	}
	
	public HomeAndCartPageObject homePageObject() {
		homePO= new HomeAndCartPageObject(driver);
		return homePO;
	}
	
	public TopDealsPage TopDealPageObject() {
		topPO = new TopDealsPage(driver);
		return topPO;
	}
	
	public CheckOutPage CheckOutPageObject() {
		CheckoutPO = new CheckOutPage(driver);
		return CheckoutPO;
	}
	
	public CustomerDetailsPage CustomerDetailsPageObject() {
		CustomerDetailsPO = new CustomerDetailsPage(driver);
		return CustomerDetailsPO;
	}
	
}
