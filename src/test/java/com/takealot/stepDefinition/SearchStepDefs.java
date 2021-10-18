package com.takealot.stepDefinition;

import com.takealot.pages.SearchPage;
import com.takealot.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchStepDefs {

    SearchPage searchPage = new SearchPage();

    @When("User look for {string} in the search bar")
    public void user_look_for_in_the_search_bar(String itemToSearch) {
        searchPage.searchBar.sendKeys(itemToSearch);
    }

    @When("User click on the search button")
    public void user_click_on_the_search_button() {
        searchPage.searchBtn.click();
    }

    @Then("The page should show only {string} result")
    public void the_page_should_show_only_watches_result(String searchResultItem) {
        String result = searchPage.searchResult.getText();
        Assert.assertTrue(result.contains(searchResultItem));
    }

    @When("User filter the search and select Garmin Brand")
    public void user_filter_the_search_and_select_Brand() {
        BrowserUtils.waitFor(2);
        searchPage.garminBrandCheckBox.click();
    }

    @Then("the user should see only {string} Brand watches")
    public void the_user_should_see_only_Garmin_Brand_watches(String brandName) {
        try {
            // looking for LOAD MORE BUTTON
            while (searchPage.loadMoreBtn.isDisplayed()) {
                BrowserUtils.scrollToElement(searchPage.loadMoreBtn);
                BrowserUtils.waitFor(3);
                searchPage.loadMoreBtn.click();
            }
        } catch (StaleElementReferenceException exception) {
            BrowserUtils browserUtils = new BrowserUtils();

            // verify if user see BRAND NAME for the all results in page
            for (String eachItem : browserUtils.convertWebElementsToListToString(searchPage.allWatchesOnThePage)) {
                Assert.assertTrue(eachItem.contains(brandName));
            }
        }

    }

    @When("User add to cart {string}")
    public void user_add_to_cart(String itemName) {

        // looking for the element and click on "Add to Cart" button
        boolean flag = true;

        do {
            BrowserUtils.scrollToElement(searchPage.findItem(itemName));
            if (searchPage.findItem(itemName).isDisplayed()) {
                searchPage.findItem(itemName).click();
                flag = false;
            } else {
                BrowserUtils.scrollToElement(searchPage.loadMoreBtn);
                searchPage.loadMoreBtn.click();
            }
        } while (flag);
    }

    // Cart button from the base page
    @When("User clicks on cart Button")
    public void user_clicks_on_cart_Button() {
        BrowserUtils.scrollToElement(searchPage.cartBtn);
        searchPage.cartBtn.click();
    }

    @Then("Cart count should be {string}")
    public void cart_count_should_be(String expectedCartCount) {
        String actualCartCount = searchPage.cartBtn.getText();

        // verify the Cart count is equal with expected count
        Assert.assertEquals(expectedCartCount, actualCartCount);
    }

    // user should see the specific item in the Cart
    @Then("User should see the {string}")
    public void user_should_see_the(String watchName) {
        List<String> cart = new ArrayList<>();

        for (WebElement item : searchPage.cartItems) {
            cart.add(item.getText());
        }
        Assert.assertTrue(cart.contains(watchName));
    }

    @Then("User should check if {string} item is on the list")
    public void user_should_check_if_item_is_on_the_list(String itemName) {

        // looking for the specific item on page
        try {
            while (searchPage.loadMoreBtn.isDisplayed()) {
                BrowserUtils.scrollToElement(searchPage.loadMoreBtn);
                BrowserUtils.waitFor(2);
                searchPage.loadMoreBtn.click();
            }
        } catch (StaleElementReferenceException exception) {
            List<String> watchBands = new ArrayList<>();

            for (WebElement watchBand : searchPage.all22mmWatchBands) {
                watchBands.add(watchBand.getText());
            }
            System.out.println("watchBands = " + watchBands);

            // verify if the searched item is on the listed page
            Assert.assertTrue(watchBands.contains(itemName));
        }


    }
}
