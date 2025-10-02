package pageObjects;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	WebDriver driver;
	WebDriverWait myWait;
	Set<String> checkedOutProdList;
	
	CheckOutPage(WebDriver driver){
		this.driver= driver;
		this.myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
//	Locators
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	WebElement placeOrderBtn;
	@FindBy(css="input.promoCode")
	WebElement promoField;
	@FindBy(css=".promoBtn")
	WebElement promoBtn;
	@FindBy(xpath="//table[@class='cartTable']//p[@class='product-name']")
	List<WebElement> checkedOutProds;
	@FindBy(xpath = "//b[contains(text(),'No. of Items')]")
	WebElement label;
	
	
//	Actions
	public boolean checkPlaceOrder() {
		myWait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
		return placeOrderBtn.isEnabled();
	}
	
	public void placeOrder() {
//		myWait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
		placeOrderBtn.click();
	}
	
	public Set<String> checkedOutProdNames() {
		checkedOutProdList=new HashSet<>();
		for(WebElement prod : checkedOutProds) {
			checkedOutProdList.add(prod.getText().split(" ")[0]);
		}
		return checkedOutProdList;
	}
	
	public int getNoOfItems() {
		String script = "return arguments[0].nextSibling.textContent.trim();";
	    String number = (String)((JavascriptExecutor) driver).executeScript(script, label);
	    return Integer.parseInt(number);
	}
	
}
