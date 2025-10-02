package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerDetailsPage {
	WebDriver driver;
	WebDriverWait myWait;
	
	CustomerDetailsPage(WebDriver driver){
		this.driver= driver;
		this.myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
//	Locators
	@FindBy(xpath="//div[@class='wrapperTwo']//select")
	WebElement dropdown1;
	@FindBy(css="input.chkAgree")
	WebElement agreebox;
	@FindBy(xpath="//button[normalize-space()='Proceed']")
	WebElement proceedBtn;
	@FindBy(xpath="//span[contains(text(),'order has been placed successfully')]")
	WebElement orderStatus;
//	Actions
	public void chooseCountry(String country) {
		myWait.until(ExpectedConditions.elementToBeClickable(dropdown1));
		Select countryList= new Select(dropdown1);
		countryList.selectByValue(country);
	}
	
	public void agreeTerms() {
//		myWait.until(ExpectedConditions.elementToBeClickable(agreebox));
		agreebox.click();
	}
	
	public void orderProd() {
		myWait.until(ExpectedConditions.elementToBeClickable(proceedBtn));
		proceedBtn.click();
	}
	
	public boolean findOrderStatus() {
		return myWait.until(ExpectedConditions.visibilityOf(orderStatus)).isDisplayed();
	}
	
}
