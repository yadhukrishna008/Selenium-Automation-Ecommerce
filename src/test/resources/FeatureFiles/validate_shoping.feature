Feature: Validate GreenKart Shopping Application
# Already have Prodcheckout and TopDeals search – now adding 5 more

#	@common
	Scenario: Check cart persistence after navigation
    Given User is on GreenKart home page
    When User searches for "Tomato"
    And User adds "2" quantity of product
    And Add the product to cart
    And User opens the cart
    And User closes the cart
    And User opens the cart
    Then Cart should contain "Tomato"
    And Verify there are no other extra products in cart
    
	#done - need to ask abt 4 then statements
	@common
  Scenario: Verify quantity update in Cart
    Given User is on GreenKart home page
    When User searches for "Carrot"
    And Add the product to cart
    And User opens the cart
    And User closes the cart
    And User adds "3" quantity of product
    And Add the product to cart
    And User opens the cart
    Then Check if "4" quantity of the product is added
    And Verify total price is "224"
    And Cart should contain "Carrot"
    And Verify there are no other extra products in cart

#done
  @common
    Scenario: Remove item from cart
    Given User is on GreenKart home page
    When User searches for "Potato"
    And User adds "1" quantity of product
    And Add the product to cart
    And User searches for "Onion"
    And User adds "1" quantity of product
    And Add the product to cart
    And User opens the cart
    And User removes "Onion" from cart
    Then Cart should contain "Potato"
    And Verify there are no other extra products in cart

#done
#@common
  Scenario: Validate Checkout button navigation
    Given User is on GreenKart home page
    When User searches for "Cucumber"
    And User adds "2" quantity of product
    And Add the product to cart
    And User opens the cart
    And checkout the product
    Then User should be redirected to Checkout page
    