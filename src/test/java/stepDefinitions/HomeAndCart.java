package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.HomeAndCartPageObject;
import utils.TestContextSetUp;

import java.util.HashSet;
import java.util.Set;
import org.testng.Assert;

public class HomeAndCart {
	TestContextSetUp testContextSetUp;
	HomeAndCartPageObject homePO;
	CheckOutPage checkPO;
	public String productName, prodInCartName, searchedName;
	public Set<String> toCheckInCart= new HashSet<>();
	
	public HomeAndCart(TestContextSetUp testContextSetUp){
		this.testContextSetUp= testContextSetUp;
		this.homePO= testContextSetUp.pageObjectManager.homePageObject();
		this.checkPO= testContextSetUp.pageObjectManager.CheckOutPageObject();
	}
	
	@Given("User is on GreenKart home page")
	public void user_is_on_green_kart_home_page() {
	    //assert later
	}
	
	@When("User searches for {string}")
	public void User_searches_for(String string) throws InterruptedException {
	    homePO.searchProd(string);
	    productName= homePO.getProdName();
	}
	
	@When("User adds {string} quantity of product")
	public void User_adds_quantity_of_product(String string) throws InterruptedException {
	    homePO.addQuantity(string);
	}
	
	@When("Add the product to cart")
	public void add_the_product_to_cart() throws InterruptedException {
	    homePO.addToCart();
//	    Thread.sleep(1000);
	}
	
	@When("User opens the cart")
	public void User_opens_the_cart() {
	    homePO.clickOnCart();
	}
	
	@When("User closes the cart")
	public void user_closes_the_cart() {
		homePO.clickOnCart();
	}
	
	@Then("Check if {string} quantity of the product is added")
	public void check_if_quatity_of_the_product_is_added_and_verify_total_price(String string1) {
		Assert.assertEquals(homePO.getProdQuantity(), Integer.parseInt(string1));
	}
	
	@Then("Verify total price is {string}")
	public void Verify_total_price_is(String string) {
		Assert.assertEquals(homePO.getProdTotalPrice(), Integer.parseInt(string));
	}
	
	@Then("{string} is succesfully added")
	public void product_is_succesfully_added(String string){
		prodInCartName= homePO.getCartProdName();
	    Assert.assertEquals(prodInCartName, productName);
	}
	
	@When("User removes {string} from cart")
	public void user_removes_from_cart(String string) {
		homePO.removeFromCart(string);
	}
	
	@Then("Cart should contain {string}")
	public void cart_should_contain(String string) {
		toCheckInCart.add(string);
//		System.out.println(toCheckInCart);
//		System.out.println("In cart" + homePO.getCartProdNames());
		if(homePO.getCartProdNames().contains(string)) {
			Assert.assertTrue(true);
		}
	}
	
	@Then("Verify there are no other extra products in cart")
	public void verify_there_are_no_other_extra_products_in_cart() {
		Assert.assertEquals(homePO.getCartProdNames(), toCheckInCart);
	}

	@When("checkout the product")
	public void checkout_the_product() {
	    homePO.checkoutProd();
	}
	
}
