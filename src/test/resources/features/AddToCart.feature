@ui @smoke @regression
Feature: Adding and v0erifying cart functionality

  Background:
    Given User should be on the web page of the application


  Scenario: As a user I should be able to add products to cart
      When User look for "watches" in the search bar
      And User click on the search button
      Then The page should show only "watches" result
      When User filter the search and select Garmin Brand
      Then the user should see only "Garmin" Brand watches
      When User add to cart "Garmin Forerunner 45S Sports Smartwatch (39mm) - Black"
      And User clicks on cart Button
      Then Cart count should be "1"
      And User should see the "Garmin Forerunner 45S Sports Smartwatch (39mm) - Black"


  Scenario: Verify if a specific item is on the list
    When User look for "watches" in the search bar
    And User click on the search button
    Then The page should show only "watches" result
    When User filter the search and select Garmin Brand
    Then User should check if "Garmin QuickFit 22mm Silicone Watch Band - Amp Yellow" item is on the list



