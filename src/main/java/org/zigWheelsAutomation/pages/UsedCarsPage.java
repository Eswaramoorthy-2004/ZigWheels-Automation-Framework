package org.zigWheelsAutomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class UsedCarsPage {

    public WebDriver driver;

    public UsedCarsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='MORE']")
    WebElement moreMenu;

    @FindBy(xpath = "//a[contains(@title,'Used Cars') and contains(@data-track-label,'nav-used-car')]")
    WebElement usedCarsOption;

    public void clickMore() {
        moreMenu.click();
    }

    public void clickUsedCars() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", usedCarsOption);
        js.executeScript("arguments[0].click();", usedCarsOption);

    }}