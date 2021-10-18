package com.takealot.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    // this method is a static method used to handle synchronization issues
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // this method is used to convert WEB ELEMENTS to STRING
    public List<String> convertWebElementsToListToString(List<WebElement> webElements){
        List<String> newList = new ArrayList<>();
        for (WebElement webElement : webElements) {
            newList.add(webElement.getText());
        }
        return newList;
    }

    // this method is used to SCROLL to SPECIFIED ELEMENT
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
