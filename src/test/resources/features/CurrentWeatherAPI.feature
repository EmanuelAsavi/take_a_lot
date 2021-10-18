@api
Feature: Verify Current Weather data

  Background:
    Given I connect to Current Weather API using valid credentials
    When I send get request to retrieve data for "London" location


  Scenario: Verify status code
    Then Status code should be 200
    And Content type should be "application/json; charset=utf-8"


  Scenario: Verify location name and id
    Then Status code should be 200
    And Location name should be "London"
    And City id should be 2643743


  Scenario: Verify geographical coordinates
    Then Status code should be 200
    And The longitude should be "-0.1257"
    And the latitude should be "51.5085"


  Scenario: Verify country code, sunrise time (unix, UTC) and sunset time (unix, UTC)
    Then Status code should be 200
    And The country code should be "GB"
    And The sunrise time (UTC) is "1634452069"
    And The sunset time (UTC) is "1634490211"


  Scenario: Verify weather information
    Then Status code should be 200
    And Weather id is 803
    And Main weather is "Clouds"


