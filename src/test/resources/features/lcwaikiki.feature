Feature: LcWaikiki Test Automation

  Scenario: Go to website in valid credentials and add selected product to favorites, confirm and remove
    Given go to the lcWaikiki homepage
    And the user opened the login page
    And login with valid credentials and login verified
    When in the search area write "pantolan" and click search button
    And scroll to end of the page and click to see more products button
    And a random product is selected from the result products
    And choosing product add to basket
    Then click to basket page
    And  this product is the same as the product added to favorites
    And verified that the number of products is two by increasing the number.
    And the product is deleted from the basket and the basket is checked to be empty.