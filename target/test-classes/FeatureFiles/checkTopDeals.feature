Feature: Check if a product is in Topdeals page

@topDeal
Scenario Outline: Go to topdeals page and search for the product
	Given User is on GreenKart home page
	When Click on the topdeals link and go to the topdeals page
	And Search for the "<product>"
	Then Check if element exist
	And calculate the discount amount
	
	Examples:
	|product|
	|carrot|
	|guava|
	|cheese|
	|almond|
	|cucumber|
	|mushroom|