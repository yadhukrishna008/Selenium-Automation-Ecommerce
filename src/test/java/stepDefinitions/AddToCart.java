package stepDefinitions;

//import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObject;
import utils.TestContextSetUp;
import org.testng.Assert;

public class AddToCart {
	TestContextSetUp testContextSetUp;
	HomePageObject homePO;
	public String productName, prodInCartName;
	
	public AddToCart(TestContextSetUp testContextSetUp){
		this.testContextSetUp= testContextSetUp;
		this.homePO= testContextSetUp.pageObjectManager.homePageObject();
	}
	
	@Given("User is on GreenKart home page")
	public void user_is_on_green_kart_home_page() {
	    //assert later
	}
	
	@When("Search with {string} for Carrot")
	public void search_with_for_carrot(String string) throws InterruptedException {
	    homePO.searchProd(string);
	    Thread.sleep(1000);
	    productName= homePO.getProdName();
	}
	
	@When("Add the {string}")
	public void add_the(String string) {
	    homePO.addQuantity(string);
	}
	
	@When("Add the product to cart")
	public void add_the_product_to_cart()  {
	    homePO.addToCart();
	}
	
	@When("User opens the cart")
	public void User_opens_the_cart() throws InterruptedException {
	    homePO.clickOnCart();
	}
	
	@Then("Check if {int} quatity of the product is added and verify total price is {int}")
	public void check_if_quatity_of_the_product_is_added_and_verify_total_price(Integer int1, Integer int2) {
		Assert.assertEquals(homePO.getProdQuantity(), int1);
		Assert.assertEquals(homePO.getProdTotalPrice(), int2);
	}
	
	@Then("Product is succesfully added")
	public void product_is_succesfully_added() {
		prodInCartName= homePO.getCartProdName();
	    Assert.assertEquals(prodInCartName, productName);
	}	

}
