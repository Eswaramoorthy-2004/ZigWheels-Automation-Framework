package org.zigWheelsAutomation.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public JavaScriptUtil(WebDriver driver){
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void clickElement(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

}
