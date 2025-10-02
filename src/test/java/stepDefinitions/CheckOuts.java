package stepDefinitions;

import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import utils.TestContextSetUp;

public class CheckOuts {
	TestContextSetUp testContextSetUp;
	CheckOutPage checkPO;
	Set<String> checkedOutProds;
	
	public CheckOuts(TestContextSetUp testContextSetUp){
		this.testContextSetUp= testContextSetUp;
		this.checkPO= testContextSetUp.pageObjectManager.CheckOutPageObject();
	}
	
	@When("Make order for the checked out product")
	public void make_order_for_the_checked_out_product() {
	    checkPO.placeOrder();
	}
	
	@Then("User should be redirected to Checkout page")
	public void user_should_be_redirected_to_checkout_page() throws InterruptedException {
	    Assert.assertTrue(checkPO.checkPlaceOrder());
	}
	
	@Then("Checkout page should contain {string}")
	public void checkout_page_should_contain(String string) {
		checkedOutProds= checkPO.checkedOutProdNames();
		Assert.assertTrue(checkedOutProds.contains(string));
	}
	
	@Then("No. of Items should be {string}")
	public void no_of_items_should_be(String string) {
		Assert.assertEquals(checkPO.getNoOfItems(), Integer.parseInt(string));
	}
	
}
