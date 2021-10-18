package com.takealot.pages;

import com.takealot.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    // find GARMIN CHECKBOX in Brand filter
    @FindBy(xpath = "//div[@id='scroll-container']//label[@data-ref='checkbox-label-Garmin']")
    public WebElement garminBrandCheckBox;

    // select all GARMIN products in page
    @FindBy(xpath = "//span[@class='shiitake-children' and text()='Garmin']")
    public List<WebElement> allWatchesOnThePage;

    // find LOAD MORE button in page
    @FindBy(xpath = "//button[text()='Load More']")
    public WebElement loadMoreBtn;

    // check RESULT response
    @FindBy(xpath = "//div[contains(text(),'results for')]")
    public WebElement searchResult;

    //span[@aria-hidden='true' and contains(text(),'Garmin Forerunner 45S Sports Smartwatch (39mm) - Black')]/../../../../../..//button[@data-ref]

    // check ALL ITEMS in CART page
    @FindBy(xpath = "//article//h3")
    public List<WebElement> cartItems;

    // check for all "Garmin QuickFit 22mm Silicone Watch Band"
    @FindBy(xpath = "//span[contains(text(),'Garmin QuickFit 22mm Silicone Watch Band') and @class='shiitake-children']")
    public List<WebElement> all22mmWatchBands;

    // finding CART BUTTON ITEM with the given item name
    public WebElement findItem(String itemName){
        String itemPath = "//span[@aria-hidden='true' and contains(text(),'" + itemName + "')]/../../../../../..//button[@data-ref]";
        return Driver.get().findElement(By.xpath(itemPath));
    }

}
