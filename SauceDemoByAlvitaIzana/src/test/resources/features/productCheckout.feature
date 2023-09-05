Feature: Success to checkout item

  Background:
    Given access to page login
    When user input username1
      | username1 |
      | standard_user |
    And user input password
      | password |
      | secret_sauce |
    Then user success login to first account

  @regression
  Scenario: Success to checkout item
    And add some item
    And user verify the item
    And user check item in cart
    And user click Checkout
    When user input name and postal code
      | firstName | lastName | postalCode |
      | Sauce     | Demo     | 12345      |
    And user click Continue
    And Checkout Overview displayed
    When user click Finish
    Then user success to checkout item
