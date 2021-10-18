package com.takealot.pages;

import com.takealot.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegisterPage extends BasePage {

    // find REGISTER NOW BUTTON
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement registerNowBtn;

    // find REGISTER SUCCESSFULLY BOX
    @FindBy(xpath = "//div[@class='fancybox-skin']/..")
    public WebElement registerSuccessfullyBox;

    // find REGISTER SUCCESSFULLY MESSAGE
    @FindBy(xpath = "//div[@class='fancybox-skin']//h3")
    public WebElement registerSuccessfullyMessage;


    public List<WebElement> registerFormLocators = new ArrayList<>();
    // find ALL FIELDS IN REGISTER FORM
    public List<WebElement> registerFormInputFields(Map<String,String> mandatoryFields){
        for (String fieldName : mandatoryFields.keySet()) {
            WebElement locator = Driver.get().findElement(By.xpath("//label[text()='" + fieldName + "']/../input"));
            registerFormLocators.add(locator);
        }
        return registerFormLocators;
    }


}
