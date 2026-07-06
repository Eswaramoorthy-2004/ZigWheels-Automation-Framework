package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.zigWheelsAutomation.utilities.JavaScriptUtil;

public class UsedCarsPage {

    public WebDriver driver;
    JavaScriptUtil javaScriptUtil;

    public UsedCarsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    @FindBy(xpath = "//span[text()='MORE']")
    WebElement moreMenu;

    @FindBy(xpath = "//a[contains(@title,'Used Cars') and contains(@data-track-label,'nav-used-car')]")
    WebElement usedCarsOption;

    public void clickMore() {
        moreMenu.click();
    }

    public void clickUsedCars() {
        javaScriptUtil.scrollIntoView(usedCarsOption);
        javaScriptUtil.clickElement(usedCarsOption);
    }
}