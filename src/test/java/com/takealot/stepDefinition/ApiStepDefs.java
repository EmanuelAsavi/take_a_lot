package com.takealot.stepDefinition;

import com.takealot.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class ApiStepDefs {

    Response response;
    String key;
    String value;
    String baseURI = ConfigurationReader.get("uri");

    @Given("I connect to Current Weather API using valid credentials")
    public void i_connect_to_Current_Weather_API_using_valid_credentials() {
        key = ConfigurationReader.get("authorizationKey");
        value = ConfigurationReader.get("authorizationValue");
    }

    @When("I send get request to retrieve data for {string} location")
    public void i_send_get_request_to_retrieve_data_for_location(String cityName) {
        String url = ConfigurationReader.get("uri");
        response = given().accept(ContentType.JSON)
                    .and()
                    .queryParam("q",cityName)
                    .and()
                    .queryParam(key,value)
                    .when().get(baseURI+"/data/2.5/weather");

        response.prettyPrint();
    }

    @Then("Status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();

        assertEquals(expectedStatusCode,actualStatusCode);

        System.out.println("actualStatusCode = " + actualStatusCode);
    }

    @Then("Content type should be {string}")
    public void content_type_should_be(String expectedContentType) {
        String actualContentType = response.getContentType();

        assertEquals(expectedContentType,actualContentType);

    }

    @Then("Location name should be {string}")
    public void Location_name_should_be(String expectedLocationName) {
        String actualLocationName = response.path("name");

        assertEquals(expectedLocationName,actualLocationName);
    }

    @Then("City id should be {int}")
    public void City_id_should_be(int expectedId) {
        int actualId = response.path("id");

        assertEquals(expectedId,actualId);
    }

    @Then("The longitude should be {string}")
    public void the_longitude_should_be(String expectedLongitude) {
        JsonPath jsonPath = response.jsonPath();

        double actualLong = jsonPath.getDouble("coord.lon");
        String actualLongitude = Double.toString(actualLong);

        assertEquals(expectedLongitude,actualLongitude);
    }

    @Then("the latitude should be {string}")
    public void the_latitude_should_be(String expectedLatitude) {
        JsonPath jsonPath = response.jsonPath();

        double actualLat = jsonPath.getDouble("coord.lat");
        String actualLatitude = Double.toString(actualLat);

        assertEquals(expectedLatitude,actualLatitude);
    }

    @Then("The country code should be {string}")
    public void the_country_code_should_be(String expectedCountryCode) {
        JsonPath jsonPath = response.jsonPath();

        String actualCountryCode = jsonPath.getString("sys.country");

        assertEquals(expectedCountryCode,actualCountryCode);
    }

    @Then("The sunrise time \\(UTC) is {string}")
    public void the_sunrise_time_UTC_is(String expectedSunriseTime) {
        JsonPath jsonPath = response.jsonPath();

        long sunriseTime = jsonPath.getLong("sys.sunrise");
        String actualSunriseTime = Long.toString(sunriseTime);

        assertEquals(expectedSunriseTime,actualSunriseTime);
    }

    @Then("The sunset time \\(UTC) is {string}")
    public void the_sunset_time_UTC_is(String expectedSunsetTime) {
        JsonPath jsonPath = response.jsonPath();

        long sunsetTime = jsonPath.getLong("sys.sunset");
        String actualSunsetTime = Long.toString(sunsetTime);

        assertEquals(expectedSunsetTime,actualSunsetTime);
    }

    @Then("Weather id is {int}")
    public void weather_id_is(int expectedWeatherId) {
        JsonPath jsonPath = response.jsonPath();

        int actualWeatherId = jsonPath.getInt("weather[0].id");

        assertEquals(expectedWeatherId,actualWeatherId);
    }

    @Then("Main weather is {string}")
    public void main_weather_is(String expectedMainWeather) {
        JsonPath jsonPath = response.jsonPath();

        String actualMainWeather = jsonPath.getString("weather[0].main");

        assertEquals(expectedMainWeather,actualMainWeather);
    }

    @When("I send get request for {string} location without using an API key")
    public void i_send_get_request_for_location_without_using_an_API_key(String cityName) {
        String url = ConfigurationReader.get("uri");

        response = given().accept(ContentType.JSON)
                .and()
                .queryParam("q",cityName)
                .when().get(baseURI+"/data/2.5/weather");

        response.prettyPrint();
    }

    @And("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {

        String actualMessage = response.path("message");

        assertEquals(expectedMessage,actualMessage);
    }
}
