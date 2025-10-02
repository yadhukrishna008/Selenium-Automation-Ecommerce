package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopDealsPage {
	WebDriver driver;
	WebDriverWait myWait;
	
	TopDealsPage(WebDriver driver){
		this.driver= driver;
		this.myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
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
	
	@FindBy(xpath="//table/tbody/tr/td[1]")
	List<WebElement> topDealProdNametable;
	
	@FindBy(xpath= "//a[@aria-label='Next']")
	WebElement topDealNext;
	
	//Action
	public void productSearch(String product) throws InterruptedException {
		productSearchField.sendKeys(product);
//		Thread.sleep(2000);
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
	
	public boolean hasNextTable() {
		String nextBtnStatus= topDealNext.getAttribute("aria-disabled");
		return topDealNext.isEnabled() && nextBtnStatus.equals("false");
	}
	
	public List<WebElement> getProducts() {
		return topDealProdNametable;
		
	}
	
	public void nextPagination() {
		myWait.until(ExpectedConditions.elementToBeClickable(topDealNext));

	    if (hasNextTable()) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topDealNext);
	        topDealNext.click();
	    }
	}
	
}
