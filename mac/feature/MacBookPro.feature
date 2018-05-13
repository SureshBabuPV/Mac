Feature: Buying a MacBook Pro on the website
  
  As an online customer
  I want to choose a MacBook with accessories on the website
  So that I can buy it online
  Scenario: A MacBook 15” with accessories can be ordered on the website
    Given I go to the website
    When I choose a MacBook Pro with the following features and accessories
      | Option          | Specification        |
      | Screen          | 15-Inch                 |
      | Processor       | 2.9 GHz              |
      | Colour          | Silver               |
      | Software        | Logic Pro X          |
      | Display adapter | USB-C to USB Adapter |
    Then I can place an order for it.
    
    
  Scenario: The correct price and VAT are displayed for a MacBook Pro 15” with accessories
    Given when I choose the following items:
      | Option          | Price in £ |
      | MacBook Pro     |   2,699.00 |
      | Logic Pro X     |     199.99 |
      | Display adapter |      19.00 |
    When I proceed to the checkout
    Then a total price of £"2,917.99" will be displayed
    And £"486.34" will be listed for VAT.
