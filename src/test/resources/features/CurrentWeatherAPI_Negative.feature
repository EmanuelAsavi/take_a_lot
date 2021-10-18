@api
Feature: Verify Current Weather data with negative scenarios


  Scenario: Verify user cannot register a weather station without an API key
    Given I send get request for "London" location without using an API key
    Then Status code should be 401
    And "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info." message should be displayed


  Scenario: Verify user cannot register a weather station for an invalid city
    Given I connect to Current Weather API using valid credentials
    When I send get request to retrieve data for "Hello" location
    Then Status code should be 404
    And "city not found" message should be displayed
