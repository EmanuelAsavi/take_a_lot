package com.takealot.stepDefinition;

import com.takealot.pages.RegisterPage;
import com.takealot.utilities.ConfigurationReader;
import com.takealot.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.*;

public class RegisterStepDefs {

    RegisterPage registerPage = new RegisterPage();

    @Given("User should be on the web page of the application")
    public void user_should_be_on_the_web_page_of_the_application() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User click on {string} module")
    public void user_click_on_module(String module)  {
        registerPage.navigateModule(module);
    }

    @Then("User should be on register page")
    public void user_should_be_on_register_page() {
        // verify if user is on REGISTER PAGE
        Assert.assertEquals("Register on Takealot | takealot.com",Driver.get().getTitle());
    }

    @When("User fill up the mandatory fields")
    public void user_fill_up_the_mandatory_fields(Map<String,String> mandatoryFields) {
        registerPage.registerFormInputFields(mandatoryFields);

        // creating a LIST containing only MAP value
        List<String> values = new ArrayList<>(mandatoryFields.values());

        // assigning to INPUT FIELDS the MAP values
        int i = 0;
        for (WebElement eachLocator: registerPage.registerFormLocators) {
            if (i < values.size()){
                eachLocator.sendKeys(values.get(i));
                i++;
            }
        }

    }

    @When("User click on Register Now button")
    public void user_click_on() {
        registerPage.registerNowBtn.click();
    }

    @Then("User should be able to register")
    public void user_should_be_able_to_register() {
        // verify if user SUCCESSFULLY REGISTER
        Assert.assertTrue(registerPage.registerSuccessfullyBox.isDisplayed());
        Assert.assertEquals("Welcome to the TAKEALOT.com family!",registerPage.registerSuccessfullyMessage.getText());
    }

    @When("User does not fill out one or more mandatory fields {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_does_not_fill_out_one_or_more_mandatory_fields(String firstName, String lastName, String email, String retypeEmail, String password, String retypePassword, String mobileNumber) {
        // creating a MAP with KEYS and VALUES retrieved from "Register.feature" file
        Map<String, String> inputValues = new LinkedHashMap<>();

        inputValues.put("First Name", firstName);
        inputValues.put("Last Name", lastName);
        inputValues.put("Email", email);
        inputValues.put("Retype Email", retypeEmail);
        inputValues.put("Password", password);
        inputValues.put("Retype Password", retypePassword);
        inputValues.put("Mobile Number", mobileNumber);

        // calling registerFormInputFields using the MAP created above
        registerPage.registerFormInputFields(inputValues);

        // creating a LIST containing only MAP value
        List<String> values = new ArrayList<>(inputValues.values());

        // assigning to INPUT FIELDS the MAP values
            int i = 0;
            for (WebElement eachLocator: registerPage.registerFormLocators) {
                if (i < values.size()){
                    eachLocator.sendKeys(values.get(i));
                    i++;
                }
            }
    }

    @Then("User should not be able to register")
    public void user_should_not_be_able_to_register() {
        String actualTitle = Driver.get().getTitle();

        // verify if user is still on REGISTER PAGE and is NOT ABLE to REGISTER
        Assert.assertEquals("Register on Takealot | takealot.com",actualTitle);
    }
}
