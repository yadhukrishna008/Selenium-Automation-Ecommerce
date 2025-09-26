package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObject;
import pageObjects.TopDealsPage;
import utils.TestContextSetUp;

public class TopDeals {
	TestContextSetUp testContextSetUp;
	TopDealsPage topDealPage;
	HomePageObject homePageObject;
	String SearchedProd;
	int savedAmnt, oGPrice, finalPrice;
	
	public TopDeals(TestContextSetUp testContextSetUp){
		this.testContextSetUp= testContextSetUp;
		this.topDealPage= testContextSetUp.pageObjectManager.TopDealPageObject();
		this.homePageObject= testContextSetUp.pageObjectManager.homePageObject();
	}
	
	@When("Click on the topdeals link and go to the topdeals page")
	public void click_on_the_topdeals_link_and_go_to_the_topdeals_page() {
		homePageObject.clickTopDealsLink();
		testContextSetUp.genericUtils.switchToChildSite();
	}
	@When("Search for the {string}")
	public void search_for_the(String string) throws InterruptedException {
		SearchedProd= string;
		topDealPage.productSearch(SearchedProd);
	}
	@Then("Check if element exist")
	public void check_if_element_exist() {
		if(topDealPage.getProdName() !=null) {
//			System.out.println(topDealPage.getProdName().toLowerCase());
			Assert.assertEquals(SearchedProd.toLowerCase(), topDealPage.getProdName().toLowerCase());			
		}
		else {
			Assert.assertTrue(false);
		}
	}
	@Then("calculate the discount amount")
	public void calculate_the_discount_amount() {
		if(topDealPage.getProdName() !=null) {
			oGPrice= topDealPage.getProdOGPrice();
			finalPrice= topDealPage.getProdFinalPrice();
			savedAmnt= oGPrice-finalPrice;
			testContextSetUp.topDealProdDetail.put(SearchedProd, savedAmnt);
		}
	}
}
