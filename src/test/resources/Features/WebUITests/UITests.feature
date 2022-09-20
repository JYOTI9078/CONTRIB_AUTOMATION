@uitests
Feature: UI Tests - Demo Feature

  Background:
    Given user logs into SwagLabs portal


  Scenario Outline: Verify the price of item
    When user is on Products page
    Then verify that price of <Product> is <Price>
    Examples:
      | Product                   | Price    |
      | Sauce Labs Bolt T-Shirt   | $15.99   |
      | Sauce Labs Fleece Jacket  | $49.99   |
      | Sauce Labs Backpack       | $50.00   |
      | Sauce Labs Bike Light     | $9.99    |
      | Sauce Labs Bolt Jeans     | $15.99   |