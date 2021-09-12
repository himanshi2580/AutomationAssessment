
Feature: QA Automation Task

  Scenario Outline: Automate filpkart site
    Given Open Google  and run in "<browser>"
    When Search for Flipkart
    Then Write all the search options displayed in the console from googles search field while we write Flipkart in that
    And Press enter to give out the search results and open the link for the flipkart website available
    And Close the login popup on the website if available
    And Click on TV & Appliances dropdown button and Navigate to Air Conditioners  Window ACs page
    And Click on the Add To Compare checkbox of the second third and sixth products displayed
    Then Click on the COMPARE button
    And Print Name and price of all three products in the console
    And Add all the three products into the cart one by one
    And Go to the cart and add your area Pincode and check the availability of the product delivery there
    And Print the message getting displayed for the availability delivery of the product in the console
    And Click the Deliver to input box available to the top of the page and add another pin code and check the availability of the product delivery there
    And Print the message getting displayed for the availability delivery of the product in the console for the changed Pincode
    And Close the browser

    Examples: 
      | browser |
      | chrome  |
      | firefox |
