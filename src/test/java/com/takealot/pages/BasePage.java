package com.takealot.pages;

import com.takealot.utilities.BrowserUtils;
import com.takealot.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    // find module locator using module name as a String
    public void navigateModule(String module) {
        String xpath = "//a[contains(text(),'"+ module +"')]";
        WebElement webElement = Driver.get().findElement(By.xpath(xpath));
        BrowserUtils.waitFor(4);
        webElement.click();

    }

    // find the SEARCH BAR
    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBar;

    // find SEARCH BUTTON
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBtn;

    // finding CART BUTTON
    @FindBy(xpath = "//div[@class='badge-button-outer']//div[@class='badge-count']")
    public WebElement cartBtn;
}
