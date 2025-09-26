package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopDealsPage {
	WebDriver driver;
	
	TopDealsPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(id="search-field")
	WebElement productSearchField;
	
	@FindBy(xpath="//table/tbody/tr/td[1]")
	WebElement topDealProdName;
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	WebElement topDealProdOGPrice;
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	WebElement topDealProdFinalPrice;
	
	//Action
	public void productSearch(String product) throws InterruptedException {
		productSearchField.sendKeys(product);
		Thread.sleep(2000);
	}
	
	public String getProdName() {
		if (topDealProdName != null) {
//			System.out.println(topDealProdName.getText());
			return topDealProdName.getText();			
		}
		return null;
	}
	
	public int getProdOGPrice() {
		return Integer.parseInt(topDealProdOGPrice.getText());
	}
	
	public int getProdFinalPrice() {
		return Integer.parseInt(topDealProdFinalPrice.getText());
		}
	
}
