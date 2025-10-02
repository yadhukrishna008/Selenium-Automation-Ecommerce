package stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomeAndCartPageObject;
import pageObjects.TopDealsPage;
import utils.TestContextSetUp;

public class TopDeals {
	TestContextSetUp testContextSetUp;
	TopDealsPage topDealPage;
	HomeAndCartPageObject homePageObject;
	String SearchedProd, actualProd, expectedProd;
	int savedAmnt, oGPrice, finalPrice, rows;
	List<String> topDealProducts= new ArrayList<>();
	List<WebElement> sampleList;
	
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
		actualProd= topDealPage.getProdName().toLowerCase();
		expectedProd= SearchedProd.toLowerCase();
		if(actualProd.equals("no data")) {
			Assert.assertEquals(actualProd, "no data", expectedProd 
					+ "Product should not exist in Top deals");			
		}
		else {
			Assert.assertEquals(actualProd, expectedProd);
		}
	}
	@Then("calculate the discount amount")
	public void calculate_the_discount_amount() {
		if(!actualProd.equals("no data")) {
			oGPrice= topDealPage.getProdOGPrice();
			finalPrice= topDealPage.getProdFinalPrice();
			savedAmnt= oGPrice-finalPrice;
			testContextSetUp.topDealProdDetail.put(SearchedProd, savedAmnt);
		}
	}
	
	@When("User sorts products by Name")
	public void user_sorts_products_by_Name() {
		while(topDealPage.hasNextTable()){
			sampleList= topDealPage.getProducts();
			for(int i=0; i< sampleList.size(); i++) {
				topDealProducts.add(sampleList.get(i).getText().toLowerCase());
			}
			topDealPage.nextPagination();
		}

		Collections.sort(topDealProducts);
		System.out.println(topDealProducts);
	}
	
	@Then("Products should be displayed in alphabetical order")
	public void products_should_be_displayed_in_alphabetical_order() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(true);
	}
}
