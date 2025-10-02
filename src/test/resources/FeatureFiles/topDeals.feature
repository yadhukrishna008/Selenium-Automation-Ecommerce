Feature: Validate if a product is in Topdeals page

@topDeal    #need to check whether to add exception for expected fail scenario
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
	
	@topDeal
  Scenario: Validate product sorting by name in Top Deals
    Given User is on GreenKart home page
    And Click on the topdeals link and go to the topdeals page
    When User sorts products by Name
    Then Products should be displayed in alphabetical order