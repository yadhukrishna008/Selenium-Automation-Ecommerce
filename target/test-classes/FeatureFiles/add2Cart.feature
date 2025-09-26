Feature: Validate that user is able to search and add the product to cart

@add2cart
Scenario: Search for a product and add to cart
	Given User is on GreenKart home page
	When Search with "Car" for Carrot
	And Add the "3"
	And Add the product to cart
	And User opens the cart
	Then Check if 3 quatity of the product is added and verify total price is 168
	And Product is succesfully added