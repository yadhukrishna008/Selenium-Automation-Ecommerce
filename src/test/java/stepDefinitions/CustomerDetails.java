package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CustomerDetailsPage;
import utils.TestContextSetUp;

public class CustomerDetails {
	TestContextSetUp testContextSetUp;
	CustomerDetailsPage CustomerDetailsPO;
	
	public CustomerDetails(TestContextSetUp testContextSetUp){
		this.testContextSetUp= testContextSetUp;
		this.CustomerDetailsPO= testContextSetUp.pageObjectManager.CustomerDetailsPageObject();
	}
	
	@When("User selects the country {string} for delivery")
	public void user_selects_the_country_for_delivery(String string) {
		CustomerDetailsPO.chooseCountry(string);
	}
	@When("Agree to terms and conditions")
	public void agree_to_terms_and_conditions() {
		CustomerDetailsPO.agreeTerms();
	}
	@When("Proceed to order")
	public void proceed_to_order() {
		CustomerDetailsPO.orderProd();
	}
	
	@Then("Order is succesfully placed")
	public void order_is_succesfully_placed() {
	    Assert.assertTrue(CustomerDetailsPO.findOrderStatus());
	}
}
