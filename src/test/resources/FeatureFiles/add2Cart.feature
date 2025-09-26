Feature: choose a product and add it to the cart

@add2cart
Scenario: Search for a product and add to cart
	Given User is on GreenKart home page
	When Search with "Car" for Carrot
	And Add the "3"
	And Add the product to cart
	And Go to the Cart
	Then Product is succesfully added