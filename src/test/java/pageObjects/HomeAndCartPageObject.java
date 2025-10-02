package pageObjects;


import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeAndCartPageObject {
	WebDriver driver;
	WebDriverWait myWait;
	private int cartItemsSize;
	private Set<String> cartItemsNames;
	By productCard;
	
	public HomeAndCartPageObject(WebDriver driver) {
		this.driver=driver;
		this.myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		PageFactory.initElements(driver, this);
	}
	
//	Locators
	private By searchVeg= By.xpath("//input[@class='search-keyword']");
	private By add2CartBut= By.xpath(".//button[text()='ADD TO CART']");
	private By ProdName= By.xpath("//h4[@class='product-name']");
	private By increaseProdQauntity= By.xpath("//a[@class='increment']");
	private By decreaseProdQauntity= By.xpath("//a[@class='decrement']");
	private By cartIcon= By.xpath("//a[@class='cart-icon']");
	private By cartItem= By.xpath("//div[@class='cart-preview active']//p[@class='product-name']");
	private By cartItemPrice= By.xpath("//div[@class=\"cart\"]//p[@class='amount']");
	private By cartItemQuantity= By.xpath("//div[@class=\"cart\"]//p[@class='quantity']");
	private By topDealsLink= By.xpath("//div[@class='cart']/a[text()='Top Deals']");
	private By quantityInput = By.cssSelector("input.quantity");
	private By checkoutBtn= By.xpath("//button[text()='PROCEED TO CHECKOUT']");

	
//	Actions
	public void searchProd(String prod) {
		driver.findElement(searchVeg).clear();

		// Wait until search box is empty
	    myWait.until(ExpectedConditions.attributeToBe(searchVeg, "value", ""));

		driver.findElement(searchVeg).sendKeys(prod);
		
		// Wait until product with the right name is visible
		productCard = By.xpath("//h4[contains(text(),'" + prod + "')]/ancestor::div[@class='product']");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
	}
	
	public String getProdName() {
		return driver.findElement(ProdName).getText().split(" ")[0];
	}
	
	public void addQuantity(String addBy) {
		int q=Integer.parseInt(addBy);
		for(int i=1; i<q;i++) {
			int expected = i + 1;
			 try {
		            WebElement plusBtn = myWait.until(ExpectedConditions.elementToBeClickable(increaseProdQauntity));
		            plusBtn.click();

		            myWait.until(ExpectedConditions.attributeToBe(quantityInput, "value", String.valueOf(expected)));

		        } catch (StaleElementReferenceException e) {
		            // re-check after stale
		            myWait.until(ExpectedConditions.attributeToBe(quantityInput, "value", String.valueOf(expected)));
		        }
		}
	}
	
	public void reduceQuantity(String reduceBy) {
		driver.findElement(decreaseProdQauntity).click();
	}
	
	public void addToCart() {
		WebElement card = myWait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
	    
	    WebElement addBtn = card.findElement(add2CartBut);
	    addBtn.click();
	}
	
	public void removeFromCart(String prod) {
		cartItemsSize= driver.findElements(cartItem).size();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-preview active']//p[contains(text(), '" + prod + "')]/ancestor::li//a")));
		driver.findElement(By.xpath("//div[@class='cart-preview active']//p[contains(text(), '" + prod + "')]/ancestor::li//a")).click();
		
//		Wait until the product is removed
		myWait.until(driver -> driver.findElements(cartItem).size() < cartItemsSize);
	}
	
	public void clickOnCart() {
		driver.findElement(cartIcon).click();
//		myWait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
	}
	
	public String getCartProdName() {
		return driver.findElement(cartItem).getText().split(" ")[0];
	}

	//	To find all the products in the cart
	public Set<String> getCartProdNames() {
		Set<WebElement> cartItems = new HashSet<>(driver.findElements(cartItem));
		cartItemsNames= new HashSet<>();
		for (WebElement item : cartItems) {
			
			cartItemsNames.add(item.getText().split(" ")[0]);
		}
		return cartItemsNames;
	}
	
	public int getProdQuantity() {
		return Integer.parseInt(driver.findElement(cartItemQuantity).getText().split(" ")[0]);
	}
	
	public int getProdTotalPrice() {
		return Integer.parseInt(driver.findElement(cartItemPrice).getText().split(" ")[0]);
	}
	
	public void clickTopDealsLink() {
		driver.findElement(topDealsLink).click();
	}
	
	public void checkoutProd() {
		myWait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
	}
	
}
