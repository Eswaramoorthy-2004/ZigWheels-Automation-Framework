package org.zigWheelsAutomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpcomingHondaBikesPage extends HomePage{

    public UpcomingHondaBikesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(@title,'upcoming Honda bikes')]")
    WebElement hondaButton;

    public void clickHondaButton(){
        javaScriptUtil.scrollIntoView(hondaButton);
        javaScriptUtil.clickElement(hondaButton);
    }
}
