Feature: Critical Path Scenario - Yakaboo
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: User Adds a Book to the Cart and Completes the Purchase
    Given I is on the Yakaboo homepage "https://www.yakaboo.ua"
    When I searches for a book "Гаррі Поттер. Історія магії"
    And I selects the first search result
    Then I should see the product details page
    And I click on To the basket button
    And I should see that the book has been added to the basket
    When I click on Basket button
    Then I should see the basket page with added book
    And I click on Go to checkout button
    Then I should be on the checkout page
    And I fill in the required contact information
    And I fill in the required delivery information
    And I click on Pay button
    Then I go to the payment page
    And I enter my card details



