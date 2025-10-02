Feature: Validate that user is able to checkout and place order

@checkout
Scenario: Checkout product and verify number of items
	Given User is on GreenKart home page
	When User searches for "Car"
	And Add the product to cart
	And User opens the cart
	And checkout the product
	And User should be redirected to Checkout page
	Then Checkout page should contain "Carrot"
	And No. of Items should be "1"

@MakeOrder
	Scenario: Checkout product and make order
	Given User is on GreenKart home page
	When User searches for "Car"
	And User adds "2" quantity of product
	And Add the product to cart
	And User opens the cart
	And checkout the product
	And User should be redirected to Checkout page
	And Make order for the checked out product
	And User selects the country "Algeria" for delivery
	And Agree to terms and conditions
	And Proceed to order
	Then Order is succesfully placed
	