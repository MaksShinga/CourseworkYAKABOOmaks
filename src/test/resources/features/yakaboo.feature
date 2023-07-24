Feature: Critical Path Scenario - Yakaboo
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: User Adds a Book to the Cart and Completes the Purchase
    Given I is on the Yakaboo homepage "https://www.yakaboo.ua"
    When I searches for a book "Гаррі Поттер. Історія магії"
    And I selects the first search result
    Then I should see the product details page
    And I click on "Buy now" button
    Then I should be on the checkout page
    And I fill in the required shipping and contact information
    And I click on "Pay" button
    Then I go to the payment page



