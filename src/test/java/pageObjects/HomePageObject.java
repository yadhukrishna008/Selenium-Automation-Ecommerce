package pageObjects;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.bidi.module.Input;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
//		PageFactory.initElements(driver, this);
	}
	
//	Locators
	private By searchVeg= By.xpath("//input[@class='search-keyword']");
	private By add2CartBut= By.xpath("//button[normalize-space()='ADD TO CART']");
	private By getProdName= By.xpath("//h4[@class='product-name']");
	private By increaseProdQauntity= By.xpath("//div[@class='stepper-input']/a[@class='increment']");
	private By decreaseProdQauntity= By.xpath("//div[@class='stepper-input']/a[@class='decrement']");
	private By cartIcon= By.xpath("//a[@class='cart-icon']");
	private By cartItem= By.xpath("//div[@class='cart-preview active']//p[@class='product-name']");
	private By topDealsLink= By.xpath("//div[@class='cart']/a[text()='Top Deals']");
	
	
//	Actions
	public void searchProd(String prod) {
		driver.findElement(searchVeg).sendKeys(prod);
	}
	
	public String getProdName() {
		return driver.findElement(getProdName).getText().split(" ")[0];
	}
	
	public void addQuantity(String addBy) {
		int q=Integer.parseInt(addBy);
		for(int i=1; i<q;i++) {
			driver.findElement(increaseProdQauntity).click();
		}
	}
	
	public void reduceQuantity(String reduceBy) {
		driver.findElement(decreaseProdQauntity).click();
	}
	
	public void addToCart() {
		driver.findElement(add2CartBut).click();
	}
	
	public void clickOnCart() {
		driver.findElement(cartIcon).click();
	}
	
	public String getCartProdName() {
		return driver.findElement(cartItem).getText().split(" ")[0];
	}
	
	public void clickTopDealsLink() {
		driver.findElement(topDealsLink).click();
	}
	
}
